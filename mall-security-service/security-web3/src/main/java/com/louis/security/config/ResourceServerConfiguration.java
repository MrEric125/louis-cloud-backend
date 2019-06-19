package com.louis.security.config;

import com.louis.security.authentication.FormAuthenticationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author Eric
 * @date create in 2019/6/16
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Autowired
    private FormAuthenticationConfig formConfig;




    @Override
    public void configure(HttpSecurity http) throws Exception {
        formConfig.configure(http);
        http.csrf().disable();


    }
}
