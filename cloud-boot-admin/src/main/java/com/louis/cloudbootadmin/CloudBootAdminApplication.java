package com.louis.cloudbootadmin;

import com.louis.common.web.web.anontation.SpringCloudClient;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringCloudClient
public class CloudBootAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudBootAdminApplication.class, args);
    }

}
