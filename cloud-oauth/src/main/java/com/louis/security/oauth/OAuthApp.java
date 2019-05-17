package com.louis.security.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author Eric
 * @date create in 2019/4/14
 */
@SpringBootApplication
@EnableAuthorizationServer
public class OAuthApp  {

    public static void main(String[] args) {
        SpringApplication.run(OAuthApp.class, args);
    }


}
