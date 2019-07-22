package com.louis.productserviceweb;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/7/2
 * Description:
 */
public class JdkProxyFactory implements InvocationHandler {

    private Object object;

    public JdkProxyFactory(Object object) {
        this.object = object;
    }

    public Object getProxyObject() {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk proxy Factory");
        return method.invoke(object, args);
    }
}
