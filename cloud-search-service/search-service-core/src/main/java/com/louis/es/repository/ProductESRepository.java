package com.louis.es.repository;

import com.louis.es.base.repository.BaseESRepository;
import com.louis.es.entity.ProductDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.stereotype.Repository;

/**
 * @author louis
 * <p>
 * Date: 2019/6/10
 * Description:
 */
@Repository
public interface ProductESRepository extends BaseESRepository<ProductDocument, Long> {

//    @Query("{'bool':{}}")
//    Page<ProductDocument> findByPriceAndAndSellerName(String priceName, String sellerName, Pageable pageable);







}
