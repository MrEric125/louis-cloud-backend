package com.louis.es;

import com.louis.common.api.wrapper.Wrapper;
import com.louis.core.search.Searchable;
import com.louis.core.service.CRUDService;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.sort.ScoreSortBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/10
 * Description:
 */
@Service
public class BaseESService<D extends BaseDocument ,ID extends Serializable> {

    @Autowired
    BaseESRepository<D,ID> baseESRepository;

    //查询当天产生的实体，用户定时任务，导入到es
    public void autoAdd(List<D> documents) {
        baseESRepository.saveAll(documents);
    }

    public Page<D> searchSimple(String keyword, Searchable searchable) {
        if (searchable.getPage()==null) {
            searchable.setPage(0, 10);
        }
        Pageable page = searchable.getPage();
        return baseESRepository.findByNameOrSubTitleOrKeywords(keyword, keyword, keyword, page);

    }

    public Page<D> search(String keyword,Searchable searchable) {
        if (searchable.getPage()==null) {
            searchable.setPage(0, 10);
        }
        Sort sort = searchable.getSort() == null ? new Sort(Sort.Order.asc(keyword)) : searchable.getSort();
        Pageable page = searchable.getPage();
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withPageable(page);
        SortBuilder sortBuilder = new ScoreSortBuilder();
        sortBuilder.order();
        queryBuilder.withSort(sortBuilder);
        QueryBuilder query = queryBuilder.build().getQuery();
        return baseESRepository.search(query, page);

    }








}
