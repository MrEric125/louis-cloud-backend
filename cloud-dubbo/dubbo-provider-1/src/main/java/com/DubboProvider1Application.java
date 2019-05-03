package com;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
@EnableDubboConfiguration
public class DubboProvider1Application {


//    private static CountDownLatch latch = new CountDownLatch(1);
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DubboProvider1Application.class, args);
    }

}
