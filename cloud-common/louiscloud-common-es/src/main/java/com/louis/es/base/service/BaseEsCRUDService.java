package com.louis.es.base.service;

import com.louis.common.api.search.Searchable;
import com.louis.es.base.entity.BaseDocument;
import com.louis.es.base.repository.BaseESRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.sort.ScoreSortBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @author louis
 * <p>
 * Date: 2019/6/10
 * Description:
 */
@Service
public interface BaseEsCRUDService<E extends BaseDocument, ID extends Serializable> {

    Page<E> searchSimple(String keyword, Searchable searchable);

    Page<E> search(String keyword, Searchable searchable);

    void add(E e);

    void delete(E e);

    E edit(E e);











}
