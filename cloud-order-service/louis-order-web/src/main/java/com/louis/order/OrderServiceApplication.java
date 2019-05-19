package com.louis.order;

import com.louis.common.api.repository.SimpleBaseRepository;
import com.louis.common.web.web.bind.annotation.method.SearchableMethodArgumentResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@EnableSwagger2
@EnableJpaRepositories(repositoryBaseClass = SimpleBaseRepository.class)
public class OrderServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    public SearchableMethodArgumentResolver searchableMethodArgumentResolver() {
        return new SearchableMethodArgumentResolver();
    }

}
