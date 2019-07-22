package com.louis.hystrix;

import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.eventnotifier.HystrixEventNotifier;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;
import com.netflix.hystrix.strategy.metrics.HystrixMetricsPublisher;
import com.netflix.hystrix.strategy.properties.HystrixPropertiesStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author John·Louis
 * @date create in 2019/5/21
 */
@Configuration
public class ThreadLocalConfiguration {

    @Autowired(required = false)
    private HystrixConcurrencyStrategy existingConcurrencyStrategy;

    public void init() {
        HystrixPlugins hystrixPlugins = HystrixPlugins.getInstance();
        HystrixEventNotifier eventNotifier = hystrixPlugins.getEventNotifier();
        HystrixMetricsPublisher publisher = hystrixPlugins.getMetricsPublisher();

        HystrixPropertiesStrategy strategy = hystrixPlugins.getPropertiesStrategy();
        HystrixCommandExecutionHook commandExecutionHook = hystrixPlugins.getCommandExecutionHook();
        HystrixPlugins.reset();
        HystrixPlugins.getInstance().registerConcurrencyStrategy(new ThreadLocalAwareStrategy(existingConcurrencyStrategy));
        HystrixPlugins.getInstance().registerEventNotifier(eventNotifier);
        HystrixPlugins.getInstance().registerMetricsPublisher(publisher);
        HystrixPlugins.getInstance().registerPropertiesStrategy(strategy);
        HystrixPlugins.getInstance().registerCommandExecutionHook(commandExecutionHook);
    }

}
