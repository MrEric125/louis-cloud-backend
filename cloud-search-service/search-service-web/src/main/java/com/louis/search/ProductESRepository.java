package com.louis.search;

import com.louis.es.BaseESRepository;
import com.louis.search.entity.ProductDocument;
import org.springframework.stereotype.Component;

/**
 * @author louis
 * <p>
 * Date: 2019/6/10
 * Description:
 */
@Component
public interface ProductESRepository extends BaseESRepository<ProductDocument, Long> {




}
