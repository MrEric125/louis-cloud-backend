package com.louis.product.controller;

import com.louis.common.web.web.CRUDController;

import com.louis.product.entity.PmsProduct;
import com.louis.product.service.PmsProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author Eric
 * @date create in 2019/5/26
 * description:
 */
@Controller
@Api("pms 商品管理")
public class PmsProductController extends CRUDController<PmsProduct,Long> {

    @Autowired
    PmsProductService productService;





}
