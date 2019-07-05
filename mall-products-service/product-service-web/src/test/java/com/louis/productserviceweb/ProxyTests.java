package com.louis.productserviceweb;

import org.junit.Test;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/7/2
 * Description:
 */
public class ProxyTests {

    @Test
    public void proxyTest() {

        UserService userService = new UserServiceImpl();
        JdkProxyFactory factory = new JdkProxyFactory(userService);
        UserService object = (UserService) factory.getProxyObject();
        object.save();
        System.out.println("======================");
        object.select();
    }
}
