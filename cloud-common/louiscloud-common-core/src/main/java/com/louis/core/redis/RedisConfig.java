package com.louis.core.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author Eric
 * @date create in 2019/5/28
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate redisTemplate() {
        return new RedisTemplate();
    }
}
