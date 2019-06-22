package com.louis.search.service;

import com.louis.es.BaseESService;
import com.louis.search.ProductESRepository;
import com.louis.es.entity.ProductDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author louis
 * <p>
 * Date: 2019/6/10
 * Description:
 */
@Service
public class ProductESServiceImpl extends BaseESService<ProductDocument,Long> {

    @Autowired
    ProductESRepository productESRepository;


    public void add(ProductDocument productDocument) {
        ProductDocument save = productESRepository.save(productDocument);
    }





}
