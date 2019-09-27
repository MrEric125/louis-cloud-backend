package com.louis.order.web.controller;

import com.louis.product.api.feign.PmsProductClientApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author louis
 * <p>
 * Date: 2019/9/27
 * Description:
 */
@RestController
@RequestMapping("/data")
public class DataGenerateController {

    @Autowired
    PmsProductClientApi pmsProductClient;



}
