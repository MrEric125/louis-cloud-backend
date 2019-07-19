package com.louis.es.base.service.impl;

import com.louis.es.base.entity.BaseDocument;
import com.louis.es.base.repository.BaseESRepository;
import com.louis.es.base.service.BaseEsCRUDService;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import java.io.Serializable;
import java.util.Optional;

/**
 * @author louis
 * <p>
 * Date: 2019/7/17
 * Description:
 */

public class BaseEsCRUDServiceImpl<D extends BaseDocument,ID extends Serializable> implements BaseEsCRUDService<D,ID> {

    @Autowired
    BaseESRepository<D,ID> baseESRepository;


    @Override
    public Page<D> searchSimple(String keyword) {
        return null;
    }

    @Override
    public Page<D> search(String keyword) {
        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder();
        NativeSearchQuery searchQuery = searchQueryBuilder.withFilter(queryBuilder).build();

        return baseESRepository.search(searchQuery);
    }

    @Override
    public Page<D> searchPageable(String keyword, Pageable pageable) {
        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        System.out.println(queryBuilder);
        NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder();
        NativeSearchQuery searchQuery = searchQueryBuilder.withFilter(queryBuilder).build();
        return baseESRepository.search(queryBuilder, pageable);

    }

    @Override
    public D add(D d) {
        return baseESRepository.save(d);

    }

    @Override
    public void delete(D d) {
         baseESRepository.delete(d);
    }

    @Override
    public D edit(D d) {
        return baseESRepository.save(d);
    }

    public Optional<D> findById(ID id) {
        return baseESRepository.findById(id);
    }


}
