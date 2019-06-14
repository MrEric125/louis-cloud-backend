package com.louis.search.controller;

import com.louis.common.api.wrapper.Wrapper;
import com.louis.core.search.Searchable;
import com.louis.es.BaseESController;
import com.louis.search.entity.ProductDocument;
import com.louis.search.service.ProductESServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eric
 * @date create in 2019/6/11
 */
@Api("产品es")
@RestController
public class ProductESController extends BaseESController<ProductDocument, Long> {


    @Autowired
    private ProductESServiceImpl productESService;



    @ApiOperation("简单搜索")
    @GetMapping("search/simple/{keyWord}")
    public Wrapper searchSimple(@PathVariable("keyWord") String keyWord, Searchable searchable) {
        Page<ProductDocument> productDocuments = productESService.searchSimple(keyWord, searchable);
        return handleResult(productDocuments);
    }




}
