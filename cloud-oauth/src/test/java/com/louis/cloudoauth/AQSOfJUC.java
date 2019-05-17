package com.louis.cloudoauth;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author Eric
 * @date create in 2019/5/16
 */
@Slf4j
public class AQSOfJUC {



    private static int threadTotal = 200;


    private static int clientTotal = 5000;

    private static int count = 0;

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    private static AtomicLong l = new AtomicLong(0L);

    /**
     * 实现原理通过热点数据，与以上的区别
     */
    private static LongAdder longAdder = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Semaphore semaphore = new Semaphore(threadTotal);

        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();

            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count: {}", count);
        log.info("count: {}", atomicInteger.get());
        log.info("count long {}",l.get());
        log.info("count long {}",longAdder);


    }
    private static void add() {
        count++;
        atomicInteger.incrementAndGet();
        l.incrementAndGet();
        longAdder.increment();

    }
}
