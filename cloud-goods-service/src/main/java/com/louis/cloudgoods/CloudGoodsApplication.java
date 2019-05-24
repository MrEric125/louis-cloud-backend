package com.louis.cloudgoods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients
@SpringBootApplication
@RestController
public class CloudGoodsApplication {


    public static void main(String[] args) {
        SpringApplication.run(CloudGoodsApplication.class, args);
    }







}
