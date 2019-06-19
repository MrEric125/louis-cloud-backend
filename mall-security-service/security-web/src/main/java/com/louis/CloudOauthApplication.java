package com.louis;

import com.louis.common.web.web.anontation.SpringCloudClient;
import com.louis.core.repository.SimpleBaseRepository;
import com.louis.properties.TokenProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableJpaRepositories(repositoryBaseClass = SimpleBaseRepository.class)
@EnableConfigurationProperties(TokenProperties.class)
@SpringCloudClient
public class CloudOauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudOauthApplication.class, args);
    }

}
