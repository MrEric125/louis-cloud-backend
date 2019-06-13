package com.louis.es.framework;

import com.louis.es.BaseDocument;
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
}
