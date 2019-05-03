package com.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.demo.DemoService;
import org.springframework.stereotype.Component;

/**
 * @author Eric
 * @date create in 2019/5/3
 */

public class DemoServiceImpl implements DemoService {


    @Override
    public String sayHello(String name) {
        return "hello" + name;
    }
}
