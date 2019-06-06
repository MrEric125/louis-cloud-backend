package com.louis.streamserviceweb;

import com.louis.common.web.web.anontation.SpringCloudClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringCloudClient
public class StreamServiceWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamServiceWebApplication.class, args);
    }

}
