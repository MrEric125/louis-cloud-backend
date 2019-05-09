package com.louis.common.repository;

import com.louis.search.Searchable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * @author louis
 * <p>
 * Date: 2019/5/6
 * Description:
 */
@NoRepositoryBean
public interface BaseRepository <T, ID extends Serializable> extends JpaRepository<T, ID> {

    /**
     * 通过条件查询实体数量
     * @param searchable 条件
     * @return 数量
     */
    long count(Searchable searchable);

    /**
     * 通过条件查询分页数据
     * @param searchable 条件
     * @return 实体分页
     */
    Page<T> findAll(Searchable searchable);

    /**
     * 通过批量id删除实体
     * @param ids
     */
    void delete(List<ID> ids);

    boolean exists(ID id);

    T findOne(ID id);




}
