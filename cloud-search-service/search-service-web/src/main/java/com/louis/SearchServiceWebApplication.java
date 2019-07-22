package com.louis;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringCloudApplication
@EnableHystrix
@EnableFeignClients
@EnableSwagger2
@EnableElasticsearchRepositories
public class SearchServiceWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchServiceWebApplication.class, args);
    }

}
