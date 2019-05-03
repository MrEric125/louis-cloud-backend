package com.louis.dubboconsumer1;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboConsumer1ApplicationTests {

    @Reference
    private UserService userService;

    @Test
    public void contextLoads() {
        String user = userService.getUser("11");
        System.out.println(user);

    }

}
