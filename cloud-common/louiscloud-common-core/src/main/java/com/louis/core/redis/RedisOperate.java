package com.louis.core.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Eric
 * @date create in 2019/5/19
 */
@Service
public class RedisOperate {


    @Autowired
    RedisTemplate redisTemplate;

    public void get() {

    }


}
