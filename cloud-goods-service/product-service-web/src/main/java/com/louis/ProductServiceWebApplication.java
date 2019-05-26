package com.louis;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients
@SpringCloudApplication
@RestController
public class ProductServiceWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceWebApplication.class, args);
    }

}
