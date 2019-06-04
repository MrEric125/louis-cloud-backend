package com.louis;

import com.louis.common.web.web.anontation.SpringCloudClient;
import com.louis.core.repository.SimpleBaseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Eric
 * @date create in 2019/5/18
 */
@EnableJpaRepositories(repositoryBaseClass = SimpleBaseRepository.class)
@SpringCloudClient
public class CommentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommentApplication.class, args);

    }
}
