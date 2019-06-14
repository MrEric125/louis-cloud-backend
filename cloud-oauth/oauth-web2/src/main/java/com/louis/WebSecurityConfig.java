package com.louis;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * @author Eric
 * @date create in 2019/4/14
 *
 * 为应用程序定义用户id 密码，和角色的资源服务器
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    /**
     * Configure.
     *
     * @param http the http
     *
     * @throws Exception the exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .and()
                .logout().logoutUrl("/logout")
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/**", "/applications/**", "/api/applications/**", "/login.html", "/**/*.css", "/img/**", "/third-party/**")
                .permitAll()
                .anyRequest().authenticated();
    }



}
