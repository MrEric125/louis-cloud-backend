package com.louis.common.web.web;

import com.louis.common.web.web.bind.annotation.method.SearchableMethodArgumentResolver;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Validator;
import java.util.List;

/**
 * @author John·Louis
 * @date create in 2019/5/11
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        argumentResolvers.add(currentUserMethodArgumentResolver());
        argumentResolvers.add(searchableMethodArgumentResolver());
    }

//        private CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver() {
//        return new CurrentUserMethodArgumentResolver();
//    }
    private SearchableMethodArgumentResolver searchableMethodArgumentResolver() {
        return new SearchableMethodArgumentResolver();
    }
    @Bean
    public FormattingConversionService conversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        addFormatters(conversionService);
        return conversionService;
    }
//
    @Bean
    public MethodInvokingFactoryBean methodInvokingFactoryBean() {
        MethodInvokingFactoryBean m = new MethodInvokingFactoryBean();
        m.setStaticMethod("com.louis.common.api.search.utils.SearchableConvertUtils.setConversionService");
        m.setArguments(conversionService());
        return m;
    }


    /**
     * 防止@EnableMvc把默认的静态资源路径覆盖了，手动设置的方式
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
      /*  // 解决静态资源无法访问
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");*/
        // 解决swagger无法访问
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        // 解决swagger的js文件无法访问
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }

    @Bean
    public ResourceBundleMessageSource resourceBundleMessageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("classpath:messages","classpath:ValidationMessages");
        messageSource.setUseCodeAsDefaultMessage(false);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(60);
        return messageSource;
    }

    @Bean
    public Validator validator(){
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setProviderClass(org.hibernate.validator.HibernateValidator.class);
        validator.setValidationMessageSource(resourceBundleMessageSource());
        return validator;
    }

}

