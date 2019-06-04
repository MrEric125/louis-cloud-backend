package com.louis.zuul;

import com.louis.common.web.web.anontation.SpringCloudClient;
import com.louis.core.repository.SimpleBaseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eric
 * @date create in 2019/5/19
 */
@EnableZuulProxy
@RestController
@SpringCloudClient
@EnableJpaRepositories(repositoryBaseClass = SimpleBaseRepository.class)
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

    @GetMapping("/test1")
    public String test1() {

        return "test1";
    }
}
