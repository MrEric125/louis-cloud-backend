package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Eric
 * @date create in 2019/5/5
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaProviderApp {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProviderApp.class, args);
    }
}
