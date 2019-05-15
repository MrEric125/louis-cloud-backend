package com.louis.cloudgoods;

import com.louis.common.api.response.wrapper.Wrapper;
import com.louis.order.api.feign.OmsCartFeignClientApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients
@SpringBootApplication
@RestController
public class CloudGoodsApplication {


    public static void main(String[] args) {
        SpringApplication.run(CloudGoodsApplication.class, args);
    }

    @Autowired
    OmsCartFeignClientApi omsCartFeignClientApi;


    @RequestMapping("all")
    public Wrapper getOrderAll() {

        return omsCartFeignClientApi.findAll();
    }



}
