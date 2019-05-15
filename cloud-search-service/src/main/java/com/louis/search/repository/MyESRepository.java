package com.louis.search.repository;

import com.louis.search.entity.ESEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.support.AbstractElasticsearchRepository;


/**
 * @author 80003996
 * <p>
 * Date: 2019/5/14
 * Description:
 */
public class MyESRepository extends AbstractElasticsearchRepository<ESEntity,Long> {


    @Override
    protected String stringIdRepresentation(Long aLong) {
        return String.valueOf(aLong);
    }

}
