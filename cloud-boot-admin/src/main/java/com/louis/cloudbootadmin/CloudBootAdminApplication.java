package com.louis.cloudbootadmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableAdminServer
@SpringCloudApplication
@EnableHystrix

public class CloudBootAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudBootAdminApplication.class, args);
    }

}
