package com.louis.httpClient;

import com.google.common.cache.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@Slf4j
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class GuavaCacheTest {


    @Test
    public void contextLoads() {
        Cache<String, String> cache = CacheBuilder.newBuilder().build();
        cache.put("cache", "hello cache");
        log.info("=={}====,",cache.getIfPresent("cache1"));
    }

    @Test
    public void test2() {
        RemovalListener<String, String> listener = notification ->
                log.info("{},{} is remove", notification.getKey(), notification.getValue());
        Cache<String, String> cache = CacheBuilder
                .newBuilder()
                .maximumSize(3)
                .removalListener(listener)
                .recordStats()
                .build();
        cache.put("cache", "hello cache");
        cache.put("cache2", "hello cache1");
        cache.put("cache3", "hello cache2");
        cache.put("cache4", "hello cache3");
        cache.put("cache5", "hello cache4");
        cache.put("cache6", "hello cache5");
        cache.getIfPresent("cache");
        cache.getIfPresent("cache2");
        cache.getIfPresent("cache3");
        cache.getIfPresent("cache4");
        cache.getIfPresent("cache5");
        System.out.println(cache.stats());


    }

}
