package com.louis.searchserviceweb;

import com.louis.common.web.web.anontation.SpringCloudClient;
import com.louis.core.repository.SimpleBaseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringCloudClient
@EnableSwagger2
@EnableJpaRepositories(repositoryBaseClass = SimpleBaseRepository.class)
public class SearchServiceWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchServiceWebApplication.class, args);
    }

}
