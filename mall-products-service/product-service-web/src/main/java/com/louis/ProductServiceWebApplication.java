package com.louis;

import com.louis.common.web.web.anontation.SpringCloudClient;
import com.louis.core.repository.SimpleBaseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;


@SpringCloudClient
@RestController
@EnableJpaRepositories(repositoryBaseClass = SimpleBaseRepository.class)
public class                     ProductServiceWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceWebApplication.class, args);
    }

}
