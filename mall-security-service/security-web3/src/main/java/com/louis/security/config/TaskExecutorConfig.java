package com.louis.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author John·Louis
 * @date create in 2019/6/29
 * description:
 */
@Configuration
@EnableAsync
public class TaskExecutorConfig implements AsyncConfigurer {
}
