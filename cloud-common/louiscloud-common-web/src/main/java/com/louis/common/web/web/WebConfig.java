package com.louis.common.web.web;

import com.louis.common.web.web.bind.annotation.method.SearchableMethodArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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
//        m.setStaticMethod("com.louis.core.search.utils.SearchableConvertUtils.setConversionService");
//        m.setArguments(conversionService());
//        return m;
//    }


    /**
     * 防止@EnableMvc把默认的静态资源路径覆盖了，手动设置的方式
     *
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 解决静态资源无法访问
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        // 解决swagger无法访问
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        // 解决swagger的js文件无法访问
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }
}

