package com.louis.product.controller;

import com.louis.common.web.web.WebCRUDController;
import com.louis.product.api.dto.ProductCategoryDto;
import com.louis.product.entity.ProductCategory;
import com.louis.product.service.PmsProductCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author John·Louis
 * @date create in 2019/6/1
 * <p>
 * description:
 */
@Slf4j
@RestController
@RequestMapping(value = "/product/category", produces = "application/json")
public class ProductCategoryController extends WebCRUDController<ProductCategory, ProductCategoryDto, Long> {

    @Autowired
    private PmsProductCategoryService productCategoryService;

}
