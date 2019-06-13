package com.louis.zuul;

import com.louis.common.web.web.anontation.SpringCloudClient;
import com.louis.core.repository.SimpleBaseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Eric
 * @date create in 2019/5/19
 */
@EnableZuulProxy
@RestController
@SpringCloudClient
@EnableOAuth2Sso
@EnableJpaRepositories(repositoryBaseClass = SimpleBaseRepository.class)
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

    @GetMapping("/test1")
    public String test1() {

        return "test1";
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
//     a9390319-07e3-4939-a5d3-82116f21fee6


}
