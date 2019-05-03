package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Eric
 * @date create in 2019/5/3
 */

@SpringBootApplication
@EnableConfigServer
public class BdConfigApp {

    public static void main(String[] args) {
        SpringApplication.run(BdConfigApp.class, args);
    }
}
