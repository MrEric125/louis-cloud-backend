package com.louis.service;

import com.exception.NotFoundEntityException;
import com.louis.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/6
 * Description:
 *
 * 类中方法的顺序从上到下分别是增删改查
 */
@Service
public class BaseService <T,ID>{

    @Autowired
    BaseRepository<T, ID> baseRepository;


    /**
     * 报错信息
     * @param t 实体
     */
    public void save(T t) {
        baseRepository.save(t);
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
     * 排序条件查询
     * @param sort 排序条件
     * @return List<T>
     */
    public List<T> findAll(Sort sort) {

        return baseRepository.findAll(sort);
    }

    /**
     * 通过id的集合查询
     * @param ids id的集合
     * @return List<T>
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
     * 删除所有
     */
    public void deleteAll() {
        baseRepository.deleteAll();
    }




}
