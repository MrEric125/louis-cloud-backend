package com.louis;

import com.google.common.collect.Lists;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.junit.Assert;
import org.junit.Test;
import rx.Observable;
import rx.Observer;
import rx.functions.Action1;

import java.util.List;
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;

/**
 * @author louis
 * <p>
 * Date: 2019/6/27
 * Description:
 */
public class HystrixHelloWorld extends HystrixCommand<String > {

    private String name;

    public HystrixHelloWorld(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        return "Hello " + name + "!";
    }

    public static class UnitTest{

        @Test
        public void testSynchronous() {
            assertEquals("Hello World!",new HystrixHelloWorld("World").execute());
            assertEquals("Hello Box!",new HystrixHelloWorld("World").execute());

        }

        @Test
        public void testAsynchronous1() throws Exception {
            assertEquals("Hello World!", new HystrixHelloWorld("World").queue().get());
            assertEquals("Hello Bob!", new HystrixHelloWorld("Bob").queue().get());
        }

        @Test
        public void testAsynchronous2() throws Exception {

            Future<String> fWorld = new HystrixHelloWorld("World").queue();
            Future<String> fBob = new HystrixHelloWorld("Bob").queue();

            assertEquals("Hello World!", fWorld.get());
            assertEquals("Hello Bob!", fBob.get());
        }

        @Test
        public void testObservable() throws Exception {

            Observable<String> fWorld = new HystrixHelloWorld("World").observe();
            Observable<String> fBob = new HystrixHelloWorld("Bob").observe();

            // blocking
            assertEquals("Hello World!", fWorld.toBlocking().single());
            assertEquals("Hello Bob!", fBob.toBlocking().single());

            // non-blocking
            // - this is a verbose anonymous inner-class approach and doesn't do assertions
            fWorld.subscribe(new Observer<String>() {

                @Override
                public void onCompleted() {
                    // nothing needed here
                }

                @Override
                public void onError(Throwable e) {
                    e.printStackTrace();
                }

                @Override
                public void onNext(String v) {
                    System.out.println("=========================");
                    System.out.println("onNext: " + v);
                }

            });

            // non-blocking
            // - also verbose anonymous inner-class
            // - ignore errors and onCompleted signal
            fBob.subscribe(v -> {
                System.out.println("=========================");

                System.out.println("onCall: " + v);
            });
        }
    }

    public void tetttt() {
        Executor executor = Executors.newSingleThreadExecutor();

        CompletionService service = new ExecutorCompletionService(executor);
        List<String> strings = Lists.newArrayList();

        for (String string : strings) {
            Future submit = service.submit(() -> "zhangsan");
        }

    }
}
