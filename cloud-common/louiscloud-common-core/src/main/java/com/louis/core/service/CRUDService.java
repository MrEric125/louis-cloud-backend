package com.louis.core.service;

import com.louis.common.api.search.Searchable;
import com.louis.core.entity.BaseEntity;
import com.louis.core.repository.BaseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * @author louis
 * <p>
 * Date: 2019/5/6
 * Description:
 *
 * 类中方法的顺序从上到下分别是增删改查
 */
@Transactional
@Slf4j
public abstract class CRUDService <T extends BaseEntity,ID extends Serializable> implements ICRUDService<T,ID>{


    protected BaseRepository<T, ID> baseRepository;

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
     *
     */
    public T findById(ID id)  {
        return baseRepository.findOne(id);

    }

    public T saveAndFlush(T t) {
        return baseRepository.saveAndFlush(t);
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

    public List<T> findAllList(Searchable searchable) {
        return baseRepository.findAllList(searchable);
    }

    public T findOne(Searchable searchable) {
        return baseRepository.findOne(searchable);
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

    public void delete(ID id) {
        baseRepository.delete(id);
    }

    /**
     * 通过id删除
     * @param id id
     */
    public void deleteById(ID id) {
        baseRepository.deleteById(id);

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
