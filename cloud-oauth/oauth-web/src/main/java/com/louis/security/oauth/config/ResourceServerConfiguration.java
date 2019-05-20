package com.louis.security.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author Eric
 * @date create in 2019/5/20
 * 限制只有已经通过验证的用户才能访问
 */
@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {


    @Override
    public void configure(HttpSecurity http) throws Exception {

//        这里设置的是所有的已经验证的路径是可以访问的

        http
                .authorizeRequests()
//
//                .antMatchers(HttpMethod.GET,"").hasRole("ADMIN")
                .anyRequest()
                .authenticated();
    }
}
