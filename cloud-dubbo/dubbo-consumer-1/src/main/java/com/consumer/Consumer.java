package com.consumer;

import com.dubbo.demo.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Eric
 * @date create in 2019/5/3
 */
public class Consumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
//        context.start();
        DemoService demoService =  context.getBean(DemoService.class);
        String world = demoService.sayHello("world");

        System.out.println("===================");
        System.out.println(world);


    }
}
