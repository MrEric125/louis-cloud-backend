package com.louis.config;



import com.louis.filter.LoginProcessingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


/**
 * @author Eric
 * @date create in 2019/4/14
 *
 * 为应用程序定义用户id 密码，和角色的资源服务器
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String TOKEN_HEADER_PARAM = "Authorization";
    private static final String FORM_BASED_LOGIN_ENTRY_POINT = "/api/auth/login";
    private static final String TOKEN_BASED_AUTH_ENTRY_POINT = "/api/**";
    private static final String MANAGE_TOKEN_BASED_AUTH_ENTRY_POINT = "/manage/**";
    private static final String TOKEN_REFRESH_ENTRY_POINT = "/api/auth/refresh_token";
    private static final String OAUTH = "/oauth/**";


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    private LoginProcessingFilter buildLoginProcessingFilter() throws Exception {
        LoginProcessingFilter filter = new LoginProcessingFilter(FORM_BASED_LOGIN_ENTRY_POINT, successHandler, failureHandler);
        filter.setAuthenticationManager(super.authenticationManager());
        return filter;
    }

    @Autowired
    private AuthenticationSuccessHandler successHandler;
    @Autowired
    private AuthenticationFailureHandler failureHandler;
    /**
     * Configure.
     *
     * @param http the http
     *
     * @throws Exception the exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.headers().frameOptions().disable()
//                .and()
//                .formLogin()
//                .loginPage("/login.html")
//                .loginProcessingUrl("/login")
//                .and()
//                .logout().logoutUrl("/logout")
//                .and()
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/api/**", "/applications/**", "/api/applications/**", "/login.html", "/**/*.css", "/img/**", "/third-party/**")
//                .permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .addFilterBefore(buildLoginProcessingFilter(), UsernamePasswordAuthenticationFilter.class);

        http
                .csrf().disable() // 因为使用的是JWT，因此这里可以关闭csrf了
//                .exceptionHandling()
//                .authenticationEntryPoint(this.authenticationEntryPoint)
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .antMatchers(FORM_BASED_LOGIN_ENTRY_POINT).permitAll() // Login end-point
//                .antMatchers(TOKEN_REFRESH_ENTRY_POINT).permitAll() // Token refresh end-point
//                .and()
                .authorizeRequests()
                .antMatchers(OAUTH).permitAll()
                .antMatchers(TOKEN_BASED_AUTH_ENTRY_POINT).authenticated() // Protected API End-points
                .antMatchers(MANAGE_TOKEN_BASED_AUTH_ENTRY_POINT).permitAll()
                .and();



//                .addFilterBefore(buildTokenAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class);
        //
    }



}
