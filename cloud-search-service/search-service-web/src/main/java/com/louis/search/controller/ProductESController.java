package com.louis.search.controller;

import com.louis.es.base.controller.BaseESController;
import com.louis.es.entity.ProductDocument;
import com.louis.es.service.ProductESService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eric
 * @date create in 2019/6/11
 */
@Api("产品es")
@RestController
public class ProductESController extends BaseESController<ProductDocument, Long> {


    @Autowired
    private ProductESService productESService;





}
