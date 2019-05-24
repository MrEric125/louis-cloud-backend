package com.louis.security;

import com.louis.core.repository.SimpleBaseRepository;
import com.louis.security.oauth.config.TokenProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAuthorizationServer
@EnableSwagger2
@EnableDiscoveryClient
@EnableJpaRepositories(repositoryBaseClass = SimpleBaseRepository.class)
@EnableConfigurationProperties(TokenProperties.class)
public class CloudOauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudOauthApplication.class, args);
    }

}
