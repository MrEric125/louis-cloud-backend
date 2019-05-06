package com.louis.service;

import com.exception.NotFoundEntityException;
import com.louis.common.entity.AbstractEntity;
import com.louis.repository.BaseRepository;
import com.louis.search.Searchable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/6
 * Description:
 *
 * 类中方法的顺序从上到下分别是增删改查
 */
@Transactional
public abstract class BaseService <T extends AbstractEntity,ID extends Serializable>{


    BaseRepository<T, ID> baseRepository;

    @Autowired
    public void setBaseRepository(BaseRepository<T, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    /**
     * 报错信息
     * @param t 实体
     */
    public T save(T t) {
       return baseRepository.save(t);
    }

    /**
     * 通过id来查找
     * @param id 唯一id
     * @return 对应的实体
     * @throws NotFoundEntityException
     */
    public T findById(ID id) throws NotFoundEntityException {
        return baseRepository
                .findById(id)
                .orElseThrow(()->new NotFoundEntityException("没有找到实体对象"));
    }


    /**
     * 查询分页条件
     * @param pageable 分页条件
     * @return list<T>
     */
    public Page<T> findAll(Pageable pageable) {
        return baseRepository.findAll(pageable);
    }

    /**
     * 通过查询条件查询分页数据
     * @param searchable 查询条件
     * @return 分页数据
     */
    public Page<T> findAll(Searchable searchable) {
        return baseRepository.findAll(searchable);
    }

    /**
     * 排序条件查询
     * @param sort 排序条件
     * @return List<T> 返回集合
     */
    public List<T> findAll(Sort sort) {

        return baseRepository.findAll(sort);
    }

    /**
     * 通过id的集合查询
     * @param ids id的集合
     * @return List<T> 通过ids查询集合
     */
    public List<T> findAllById(List<ID> ids) {
        return baseRepository.findAllById(ids);
    }

    /**
     * 查找所有的实体
     * @return 所有实体对象的集合
     */
    public List<T> findAll() {
        return baseRepository.findAll();

    }

    /**
     * 删除单个
     * @param t 实体
     */
    public void delete(T t) {
        baseRepository.delete(t);
    }

    /**
     * 删除集合Id
     * @param ids 实体ids
     */
    public void delete(List<ID> ids) {
        baseRepository.delete(ids);
    }

    /**
     * 删除所有
     */
    public void deleteAll() {
        baseRepository.deleteAll();
    }

    /**
     * 通过查询条件查询数据条数
     * @param searchable 查询条件
     * @return 数据条数
     */
    public long count(Searchable searchable) {
        return baseRepository.count(searchable);
    }






}
