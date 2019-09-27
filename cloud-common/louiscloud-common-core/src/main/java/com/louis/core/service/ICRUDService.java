package com.louis.core.service;

import com.louis.common.api.search.Searchable;
import com.louis.core.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author John·Louis
 * @date create in 2019/6/29
 * description:
 * 基本的通用服务service
 */
public interface ICRUDService<T extends BaseEntity, ID extends Serializable> {

    /**
     * 保存实体
     * @param t
     * @return
     */
    T save(T t);

    /**
     * 通过id 查找
     * @param id
     * @return
     */
    T findById(ID id);


    /**
     * 保存，并跟新
     * @param t
     * @return
     */
    T saveAndFlush(T t);

    List<T> saveBatch(List<T> collection);

    /**
     * 通过页码信息查找分页
     * @param pageable
     * @return
     */
    Page<T> findAll(Pageable pageable);

    Page<T> findAll(Searchable searchable);

    List<T> findAllList(Searchable searchable);

    T findOne(Searchable searchable);

    List<T> findAllById(List<ID> ids);

    void delete(T t);

    void delete(ID id);

    void deleteById(ID id);

    void delete(List<ID> ids);

    void deleteAll();

    /**
     * 通过查询条件查询数据条数
     * @param searchable 查询条件
     * @return 数据条数
     */
    long count(Searchable searchable);


}
