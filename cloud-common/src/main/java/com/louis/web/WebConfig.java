package com.louis.web;

import com.louis.web.bind.annotation.method.SearchableMethodArgumentResolver;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @author Eric
 * @date create in 2019/5/11
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {


    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        argumentResolvers.add(currentUserMethodArgumentResolver());
        argumentResolvers.add(searchableMethodArgumentResolver());
    }
//    private CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver() {
//        return new CurrentUserMethodArgumentResolver();
//    }
    private SearchableMethodArgumentResolver searchableMethodArgumentResolver() {
        return new SearchableMethodArgumentResolver();
    }
//    @Bean
//    public FormattingConversionService conversionService() {
//        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
//        addFormatters(conversionService);
//        return conversionService;
//    }
//
//    @Bean
//    public MethodInvokingFactoryBean methodInvokingFactoryBean() {
//        MethodInvokingFactoryBean m = new MethodInvokingFactoryBean();
//        m.setStaticMethod("com.louis.search.utils.SearchableConvertUtils.setConversionService");
//        m.setArguments(conversionService());
//        return m;
//    }

}
