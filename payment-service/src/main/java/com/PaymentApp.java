package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/8
 * Description:
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentApp {


    public static void main(String[] args) {
        SpringApplication.run(PaymentApp.class, args);
    }
}
