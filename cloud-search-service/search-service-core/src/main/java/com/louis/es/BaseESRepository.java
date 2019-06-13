package com.louis.es;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @author louis
 * <p>
 * Date: 2019/6/10
 * Description:
 */
@NoRepositoryBean
public interface BaseESRepository<D extends BaseDocument, ID extends Serializable> extends ElasticsearchRepository<D,ID> {


    Page<D> findByNameOrSubTitleOrKeywords(String name, String subTitle, String keywords, Pageable pageable);
}
