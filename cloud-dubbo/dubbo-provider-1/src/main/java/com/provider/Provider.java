package com.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author Eric
 * @date create in 2019/5/3
 *
 *
 * 这只是目前入门的一个例子，非常简单，但是定义的接口必须是同一个接口，
 * 其中provider实现了这个接口，那么consumer直接就可以调用这个实现
 */
public class Provider {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");

        context.start();
        System.in.read();
    }
}
