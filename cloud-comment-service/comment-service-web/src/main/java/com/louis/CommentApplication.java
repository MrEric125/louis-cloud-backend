package com.louis;

import com.louis.common.api.repository.EnableQueryCache;
import com.louis.common.api.repository.SimpleBaseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Eric
 * @date create in 2019/5/18
 */
@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = SimpleBaseRepository.class)
@EnableSwagger2
@EnableDiscoveryClient
@EnableHystrix
@EnableQueryCache
public class CommentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommentApplication.class, args);

    }
}
