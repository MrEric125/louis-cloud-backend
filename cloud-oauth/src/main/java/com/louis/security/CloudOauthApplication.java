package com.louis.security;

import com.louis.common.api.repository.SimpleBaseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
@EnableJpaRepositories(repositoryBaseClass = SimpleBaseRepository.class)
public class CloudOauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudOauthApplication.class, args);
    }

}
