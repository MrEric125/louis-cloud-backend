package com.louis.order.web.controller;

import com.louis.common.api.response.wrapper.Wrapper;
import com.louis.common.web.web.BaseController;
import com.louis.order.api.feign.OmsCartFeignClientApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eric
 * @date create in 2019/5/12
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OmsCartController extends BaseController {


    @Autowired
    OmsCartFeignClientApi omsCartFeignClientApi;


    @PostMapping("addProduct/{productId}/{count}")
    public Wrapper addProduct(@PathVariable Long productId,@PathVariable Integer count) {


    }
}
