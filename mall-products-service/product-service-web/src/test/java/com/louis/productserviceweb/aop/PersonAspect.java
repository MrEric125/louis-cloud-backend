package com.louis.productserviceweb.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/7/2
 * Description:
 */
@Component
@Aspect
public class PersonAspect {


    @Pointcut("execution(* com.louis.*.*(..))")
    public void conference() {}

    /**
     * 开会之前--找个位置坐下
     */
    @Before("conference()")
    public void takeSeats() {
        System.out.println("找位置坐");
    }

    /**
     * 开会之前--手机调成静音
     */
    @Before("conference()")
    public void silenceCellPhones() {
        System.out.println("手机调成静音");
    }

    /**
     * 开会之后--写会议总结报告
     */
    @After("conference()")
    public void summary() {
        System.out.println("写会议总结报告");
    }


}
