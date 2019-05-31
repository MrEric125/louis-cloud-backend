
package com.louis.core.repository;

import com.google.common.collect.Sets;
import com.louis.core.entity.LogicDeleteable;
import com.louis.core.repository.callback.SearchCallback;
import com.louis.core.search.Searchable;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.jpa.provider.PersistenceProvider;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author John·Louis
 * @date 2019年5月30日22:53:36
 */
public class SimpleBaseRepository<M, ID extends Serializable> extends SimpleJpaRepository<M, ID> implements BaseRepository<M, ID> {
	

	public static final String LOGIC_DELETE_ALL_QUERY_STRING = "update %s x set x.deleted=true where x in (?1)";
	public static final String DELETE_ALL_QUERY_STRING = "delete from %s x where x in (?1)";
	public static final String FIND_QUERY_STRING = "from %s x where 1=1 ";
	public static final String COUNT_QUERY_STRING = "select count(x) from %s x where 1=1 ";

	private final EntityManager em;

	private final JpaEntityInformation<M, ID> entityInformation;

	private final RepositoryHelper repositoryHelper;

	private PersistenceProvider provider;

	private CrudMethodMetadata metadata;

	private Class<M> entityClass;
	
	private String entityName;
	
	private String idName;


	/**
	 * 查询所有的QL
	 */
	private String findAllQL;
	/**
	 * 统计QL
	 */
	private String countAllQL;



	private SearchCallback searchCallback = SearchCallback.DEFAULT;

	public SimpleBaseRepository(JpaEntityInformation<M, ID> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);

		this.entityInformation = entityInformation;
		this.entityClass = this.entityInformation.getJavaType();
		this.entityName = this.entityInformation.getEntityName();
		this.idName = this.entityInformation.getIdAttributeNames().iterator().next();
		
		this.em = entityManager;

		repositoryHelper= new RepositoryHelper(entityClass);
		
		repositoryHelper.setEntityManager(em);

		findAllQL = String.format(FIND_QUERY_STRING, entityName);
		countAllQL = String.format(COUNT_QUERY_STRING, entityName);
	}


	public void setRepositoryMethodMetadata(CrudMethodMetadata crudMethodMetadata) {
		super.setRepositoryMethodMetadata(crudMethodMetadata);
		this.metadata = crudMethodMetadata;
	}

	/**
	 * 设置searchCallback
	 *
	 * @param searchCallback
	 */
	public void setSearchCallback(SearchCallback searchCallback) {
		this.searchCallback = searchCallback;
	}

	/**
	 * 设置查询所有的ql
	 *
	 * @param findAllQL
	 */
	public void setFindAllQL(String findAllQL) {
		this.findAllQL = findAllQL;
	}

	/**
	 * 设置统计的ql
	 *
	 * @param countAllQL
	 */
	public void setCountAllQL(String countAllQL) {
		this.countAllQL = countAllQL;
	}


////////覆盖默认spring data jpa的实现///////////////////////////////////////////////////////////////////////

	/**
	 * 根据主键删除相应实体
	 *
	 * @param id 主键
	 */
/*	@Transactional
	@Override
	public void delete( ID id) {
		M m = findOne(id);
		delete(m);
	}*/


	/**
	 * 删除实体
	 *
	 * @param m 实体
	 */
	@Transactional
	@Override
	public void delete( M m) {
		if (m == null) {
			return;
		}
		if (m instanceof LogicDeleteable) {
			((LogicDeleteable) m).markDeleted();
			save(m);
		} else {
			super.delete(m);
		}
	}




	/**
	 * 根据主键删除相应实体
	 *
	 * @param ids 实体
	 */
	@Transactional
	@Override
	public void delete(final List<ID> ids) {
		if (CollectionUtils.isEmpty(ids)) {
			return;
		}
		List<M> models = new ArrayList<M>();
		for (ID id : ids) {
			M model = null;
			try {
				model = entityClass.newInstance();
			} catch (Exception e) {
				throw new RuntimeException("batch delete " + entityClass + " error", e);
			}
			try {
				BeanUtils.setProperty(model, idName, id);
			} catch (Exception e) {
				throw new RuntimeException("batch delete " + entityClass + " error, can not set id", e);
			}
			models.add(model);
		}
		deleteInBatch(models);
	}

	@Transactional
	@Override
	public void deleteInBatch(final Iterable<M> entities) {
		Iterator<M> iter = entities.iterator();
		if (entities == null || !iter.hasNext()) {
			return;
		}

		Set models = Sets.newHashSet(iter);

		boolean logicDeleteableEntity = LogicDeleteable.class.isAssignableFrom(this.entityClass);

		if (logicDeleteableEntity) {
			String ql = String.format(LOGIC_DELETE_ALL_QUERY_STRING, entityName);
			repositoryHelper.batchUpdate(ql, models);
		} else {
			String ql = String.format(DELETE_ALL_QUERY_STRING, entityName);
			repositoryHelper.batchUpdate(ql, models);
		}
	}

	/**
	 * 按照主键查询
	 *
	 * @param id 主键
	 * @return 返回id对应的实体
	 */
	@Transactional
	@Override
	public M findOne(ID id) {
		if (id == null) {
			return null;
		}
		if (id instanceof Integer && ((Integer) id).intValue() == 0) {
			return null;
		}
		if (id instanceof Long && ((Long) id).longValue() == 0L) {
			return null;
		}
		return super.findById(id).get();
	}



	@Override
	public Page<M> findAll(final Searchable searchable) {
		List<M> list = repositoryHelper.findAll(findAllQL, searchable, searchCallback);
		long total = searchable.hasPageable() ? count(searchable) : list.size();
		return new PageImpl<>(
				list,
				searchable.getPage(),
				total
				);
	}



	@Override
	public long count(final Searchable searchable) {
		return repositoryHelper.count(countAllQL, searchable, searchCallback);
	}

	/**
	 * 重写默认的 这样可以走一级/二级缓存
	 *
	 * @param id
	 * @return
	 */
	@Override
	public boolean exists(ID id) {
		return findOne(id) != null;
	}

}