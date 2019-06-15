package com.louis.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;


/**
 * @author Eric
 * @date create in 2019/5/20
 * 资源服务器配置
 */
@Configuration
@EnableResourceServer
public class SysResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Autowired
    private OAuth2WebSecurityExpressionHandler oAuth2WebSecurityExpressionHandler;


    /**
     * 与资源安全配置相关
     * @param resources
     * @throws Exception
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        super.configure(resources);
        resources.expressionHandler(oAuth2WebSecurityExpressionHandler);
    }

    /**
     * 与http 安全配置相关的资源配置
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
//        这里设置的是所有的已经验证的路径是可以访问的
        http.authorizeRequests()
//                .antMatchers(HttpMethod.GET,"").hasRole("ADMIN")
                .anyRequest()
                .authenticated();
    }
}
