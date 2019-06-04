package com.louis.searchserviceweb;

import com.louis.common.web.web.anontation.SpringCloudClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringCloudClient
@EnableSwagger2
public class SearchServiceWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchServiceWebApplication.class, args);
    }

}
