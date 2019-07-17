package com.louis.es.base.service.impl;

import com.louis.common.api.search.Searchable;
import com.louis.es.base.entity.BaseDocument;
import com.louis.es.base.repository.BaseESRepository;
import com.louis.es.base.service.BaseEsCRUDService;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

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
    public Page<D> searchSimple(String keyword, Searchable searchable) {
        return null;
    }

    @Override
    public Page<D> search(String keyword, Searchable searchable) {
        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder();
        NativeSearchQuery searchQuery = searchQueryBuilder.withFilter(queryBuilder).build();
        return baseESRepository.search(searchQuery);
    }

    @Override
    public void add(D d) {
        baseESRepository.save(d);

    }

    @Override
    public void delete(D d) {
         baseESRepository.delete(d);
    }

    @Override
    public D edit(D d) {
        return baseESRepository.save(d);
    }


}
