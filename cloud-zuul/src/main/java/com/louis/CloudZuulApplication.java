package com.louis;


import com.spring4all.swagger.EnableSwagger2Doc;
import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableSwagger2Doc
//@EnableZuulServer
public class CloudZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudZuulApplication.class, args);
    }

//    @Bean
//    Logger.Level feignLoggerLevel() {
//        return Logger.Level.;
//    }

}
