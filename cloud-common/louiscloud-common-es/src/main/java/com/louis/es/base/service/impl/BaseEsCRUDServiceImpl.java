package com.louis.es.base.service.impl;

import com.louis.es.base.entity.BaseDocument;
import com.louis.es.base.repository.BaseESRepository;
import com.louis.es.base.service.BaseEsCRUDService;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author louis
 * <p>
 * Date: 2019/7/17
 * Description:
 *
 * 后期根据项目需要，可能会用到agg,filter 再加吧
 */
@Transactional
public class BaseEsCRUDServiceImpl<D extends BaseDocument,ID extends Serializable> implements BaseEsCRUDService<D,ID> {

    @Autowired
    BaseESRepository<D,ID> baseESRepository;


    /**
     * queryString 和DLS各有各的使用场景
     * @param keyword
     * @param pageable
     * @return
     */
    private SearchQuery searchQueryBuilder(String keyword, Pageable pageable) {

//        QueryBuilder queryBuilder = QueryBuilders.multiMatchQuery(keyword, fieldName);

        QueryBuilder queryBuilder = QueryBuilders.queryStringQuery(keyword);

        NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder();
        searchQueryBuilder.withFilter(queryBuilder);
        HighlightBuilder.Field field=new HighlightBuilder.Field(keyword);

        searchQueryBuilder.withHighlightFields(field);

        if (Objects.nonNull(pageable)) {
            searchQueryBuilder.withPageable(pageable);
        }
        return searchQueryBuilder.build();
    }

    @Override
    public Page<D> search(String keyword) {
        return baseESRepository.search(searchQueryBuilder(keyword,null));
    }

    @Override
    public Page<D> searchPageable(String keyword, Pageable pageable) {
        return baseESRepository.search(searchQueryBuilder(keyword, pageable));

    }


    /**
     * 新增数据后期需要用 Logstash
     * @param d
     * @return
     */
    @Deprecated
    @Override
    public D add(D d) {
        return baseESRepository.save(d);

    }

    @Override
    public void delete(D d) {
         baseESRepository.delete(d);
    }

    /**
     * 数据不供编辑了
     * @param d
     * @return
     */
    @Override
    public D edit(D d) {
        return baseESRepository.save(d);
    }

    public Optional<D> findById(ID id) {
        return baseESRepository.findById(id);
    }

    /**
     * 新增数据后期需要用 Logstash
     * @param d
     * @return
     */
    @Deprecated
    @Override
    public void addBatch(List<D> list) {
        baseESRepository.saveAll(list);
    }



}
