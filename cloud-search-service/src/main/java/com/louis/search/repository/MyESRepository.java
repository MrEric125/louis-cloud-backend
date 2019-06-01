package com.louis.search.repository;

import com.louis.search.entity.ESEntity;
import org.springframework.data.elasticsearch.repository.support.AbstractElasticsearchRepository;
import org.springframework.stereotype.Repository;


/**
 * @author John·Louis
 * <p>
 * Date: 2019/5/14
 * Description:
 */
@Repository
public class MyESRepository extends AbstractElasticsearchRepository<ESEntity,Long> {


    @Override
    protected String stringIdRepresentation(Long aLong) {
        return String.valueOf(aLong);
    }

}
