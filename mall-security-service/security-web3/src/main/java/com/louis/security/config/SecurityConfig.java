package com.louis.security.config;

import com.louis.security.FailureHandler;
import com.louis.security.SuccessHandler;
import com.louis.security.server.SecurityUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    FailureHandler failureHandler;

    @Autowired
    SuccessHandler successHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new SecurityUserDetailService();
    }

    /**
     * 认证管理器，
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    /**
     *
     * 构建认证的一个过程，1.认证信息，（账号，密码，当前用户权限）
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());


    }

//    @Override
    /**
     * http安全相关  说直白点就是哪些资源对哪些角色开放
     * 1.需要拦截什么资源
     * 2.什么资源有什么角色权限
     * 3.定义认证方式，HttpBasic,FormLogin(*)
     * 4.定义登录页面，定义登录请求地址，定义错误处理方式
     * isAnonymous()只能匿名用户访问
     * permitAll() 允许所有人访问
     */
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "**")
                .hasRole("ADMIN").anyRequest().authenticated().and().httpBasic();
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                //需要新增一个login页面,前面就得放行login.html
                .formLogin()
//                .loginPage("login.html").failureUrl("/error")
                .successHandler(successHandler)
                .failureHandler(failureHandler)
                .and()
                .httpBasic();
        //自定义权限不足的页面
//        access-denind-handler
//        super.configure(http);
//
//    }
    }
}