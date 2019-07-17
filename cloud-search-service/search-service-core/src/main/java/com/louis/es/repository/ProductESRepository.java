package com.louis.es.repository;

import com.louis.es.base.repository.BaseESRepository;
import com.louis.es.entity.ProductDocument;
import org.springframework.stereotype.Repository;

/**
 * @author louis
 * <p>
 * Date: 2019/6/10
 * Description:
 */
@Repository
public interface ProductESRepository extends BaseESRepository<ProductDocument, Long> {




}
