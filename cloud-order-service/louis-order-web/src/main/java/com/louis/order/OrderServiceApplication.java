package com.louis.order;

import com.louis.common.web.web.anontation.SpringCloudClient;
import com.louis.core.repository.SimpleBaseRepository;
import com.louis.common.web.web.bind.annotation.method.SearchableMethodArgumentResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringCloudClient
//告訴cloud这个资源是受保护的资源，需要先到oauth2中获取token
//@EnableResourceServer
@EnableJpaRepositories(repositoryBaseClass = SimpleBaseRepository.class)
public class OrderServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    public SearchableMethodArgumentResolver searchableMethodArgumentResolver() {
        return new SearchableMethodArgumentResolver();
    }

    /*@Bean
    public Filter userContextFilter() {
        UserContextFilter contextFilter = new UserContextFilter();
        return contextFilter;
    }*/

}
