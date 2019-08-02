package com.louis.juc;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;

/**
 * @author louis
 * <p>
 * Date: 2019/7/25
 * Description:
 * http://ifeve.com/abstractqueuedsynchronizer-use/
 */
public class AQS {

    private static final int count=5000;

    public volatile Integer value1 = 1;

    volatile String  value2 = "zhangsan";

    protected volatile int value3 = 3;

    private volatile int value4 = 4;

    static int x = 0, y = 0, a = 0, b = 0;

    public static void main(String[] args) throws Exception {
        AbstractQueuedSynchronizer sqls = null;


    }




    @Test
    public void test1() {
        AtomicInteger integer = new AtomicInteger();
        int i = integer.addAndGet(3);
        System.out.println(i);
        boolean b = integer.compareAndSet(3, 10);
        System.out.println(b);
        AtomicIntegerArray integerArray = new AtomicIntegerArray(4);
        System.out.println(integerArray);
    }

    <T> AtomicReferenceFieldUpdater<AQS, T > getUpdater(String fieldName,Class<T> clazz) {
        return AtomicReferenceFieldUpdater.newUpdater(AQS.class,clazz , fieldName);
    }
    void doSomething() {
        AQS aqs = new AQS();
        Integer value11 = getUpdater("value1", Integer.class).getAndSet(aqs, 10);
        String andSet = getUpdater("value2", String.class).getAndSet(aqs, "wangwu");
        System.out.println(value11);
        System.out.println(aqs.value1);
        System.out.println(andSet);
        System.out.println(aqs.value2);
    }


    @Test
    public void test2() {
        doSomething();
    }





}
