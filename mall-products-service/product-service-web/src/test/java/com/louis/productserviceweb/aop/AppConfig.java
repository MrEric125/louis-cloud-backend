package com.louis.productserviceweb.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author louis
 * <p>
 * Date: 2019/7/2
 * Description:
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
}
