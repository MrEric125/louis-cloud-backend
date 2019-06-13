package com.louis;

import com.louis.common.web.web.anontation.SpringCloudClient;
import org.springframework.boot.SpringApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringCloudClient
@EnableSwagger2
@EnableElasticsearchRepositories
public class SearchServiceWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchServiceWebApplication.class, args);
    }

}
