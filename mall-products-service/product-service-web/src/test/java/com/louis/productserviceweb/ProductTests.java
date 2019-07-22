package com.louis.productserviceweb;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


/**
 * @author John·Louis
 * <p>
 * Date: 2019/7/2
 * Description:
 */
public class ProductTests {

    public static final int THREADCOUNT = 500;

    @Test
    public void test001() {
        ExecutorService service = Executors.newFixedThreadPool(200);
        Semaphore semaphore = new Semaphore(20);

        for (int i = 0; i < THREADCOUNT; i++) {
            final int threadNum = i;
            service.execute(()->{
                try {
                    semaphore.acquire();
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            });
        }
        service.shutdown();
        System.out.println("finish");
    }

    public static void test(int threadNum) throws InterruptedException {
        Thread.sleep(1000);// 模拟请求的耗时操作
        System.out.println("threadNum:" + threadNum);
        Thread.sleep(1000);// 模拟请求的耗时操作
    }
}
