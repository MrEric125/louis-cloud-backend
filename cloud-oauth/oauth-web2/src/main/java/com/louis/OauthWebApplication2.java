package com.louis;

import com.louis.common.web.web.anontation.SpringCloudClient;
import com.louis.core.repository.SimpleBaseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author John·Louis
 * @date create in 2019/6/8
 * <p>
 * description:
 */
@EnableSwagger2
@SpringCloudClient
@EnableJpaRepositories(repositoryBaseClass = SimpleBaseRepository.class)
public class OauthWebApplication2 {


    public static void main(String[] args) {
        SpringApplication.run(OauthWebApplication2.class, args);

    }
}
