package com.louis.order;

import net.bull.javamelody.MonitoringFilter;
import net.bull.javamelody.SessionListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @author John·Louis
 * @date create in 2019/6/2
 * <p>
 * description: 用於服務器監控用的
 */
@Configuration
public class MelodyConfig {

    @Bean
    public ServletListenerRegistrationBean<SessionListener> servletListenerRegistrationBean() {
        ServletListenerRegistrationBean<SessionListener> slrBean = new ServletListenerRegistrationBean<SessionListener>();
        slrBean.setListener(new SessionListener());
        return slrBean;
    }

    @Bean
    @Order(Integer.MAX_VALUE - 1)
    public FilterRegistrationBean<MonitoringFilter> monitoringFilter() {
        FilterRegistrationBean<MonitoringFilter> registration = new FilterRegistrationBean<MonitoringFilter>();
        registration.setFilter(new MonitoringFilter());
        registration.addUrlPatterns("/*");
        registration.setName("monitoring");
        return registration;
    }


}
