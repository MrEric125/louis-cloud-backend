package com.louis.security.config;

import com.google.common.collect.Lists;
import com.louis.security.login.AwareAuthenticationFailureHandler;
import com.louis.security.login.AwareAuthenticationSuccessHandler;
import com.louis.security.login.LoginAuthenticationProvider;
import com.louis.security.filter.LoginProcessingFilter;
import com.louis.security.SkipPathRequestMatcher;
import com.louis.security.filter.TokenAuthenticationProcessingFilter;
import com.louis.oauth.RestAuthenticationEntryPoint;
import com.louis.security.token.TokenAuthenticationProvider;
import com.louis.security.extractor.TokenExtractor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.List;

/**
 * @author Eric
 * @date create in 2019/4/14
 *
 * 为应用程序定义用户id 密码，和角色的资源服务器
 *
 * 若访问的地址没有授权，不会跳转到登录页面
 *
 * todo 三个模块作对比，都有各自的优势
 * security-web：  提示更加友好
 * security-web2:    功能更加完备
 * security-web3:    如果没有登录验证，那么会自动跳转
 */
@Slf4j
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String TOKEN_HEADER_PARAM = "Authorization";
    private static final String FORM_BASED_LOGIN_ENTRY_POINT = "/auth/form";
    private static final String TOKEN_BASED_AUTH_ENTRY_POINT = "/api/**";
    private static final String MANAGE_TOKEN_BASED_AUTH_ENTRY_POINT = "/manage/**";
    private static final String TOKEN_REFRESH_ENTRY_POINT = "/api/auth/refresh_token";
    private static final String OAUTH = "/oauth/**";

    @Autowired
    private RestAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private AwareAuthenticationSuccessHandler successHandler;
    @Autowired
    private AwareAuthenticationFailureHandler failureHandler;
    @Autowired
    private LoginAuthenticationProvider loginAuthenticationProvider;
    @Autowired
    private TokenAuthenticationProvider tokenAuthenticationProvider;
    @Autowired
    private TokenExtractor tokenExtractor;



    private LoginProcessingFilter buildLoginProcessingFilter() throws Exception {
        LoginProcessingFilter filter = new LoginProcessingFilter(FORM_BASED_LOGIN_ENTRY_POINT, successHandler, failureHandler);
        filter.setAuthenticationManager(super.authenticationManager());
        return filter;
    }

    private TokenAuthenticationProcessingFilter buildTokenAuthenticationProcessingFilter() throws Exception {
        List<String> list = Lists.newArrayList(TOKEN_BASED_AUTH_ENTRY_POINT, MANAGE_TOKEN_BASED_AUTH_ENTRY_POINT);
        SkipPathRequestMatcher matcher = new SkipPathRequestMatcher(list);
        TokenAuthenticationProcessingFilter filter = new TokenAuthenticationProcessingFilter(failureHandler, tokenExtractor, matcher);
        filter.setAuthenticationManager(super.authenticationManager());
        return filter;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new SecurityUserDetailServiceImpl();
    }

    /**
     * 认证的一个过程
     * @param auth
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        auth.userDetailsService(userDetailsService());

        auth.authenticationProvider(loginAuthenticationProvider);
        auth.authenticationProvider(tokenAuthenticationProvider);
    }

    /**
     * 项目在启动的时候就选软这个实现，后期登录的时候就可以直接登录{@link FORM_BASED_LOGIN_ENTRY_POINT}
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        http.addFilterBefore(encodingFilter, CsrfFilter.class);

        http
                .csrf().disable() // 因为使用的是JWT，因此这里可以关闭csrf了
                .exceptionHandling()
                .authenticationEntryPoint(this.authenticationEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(FORM_BASED_LOGIN_ENTRY_POINT).permitAll() // Login end-point
                .antMatchers(TOKEN_REFRESH_ENTRY_POINT).permitAll() // Token refresh end-point
                .and()
                .authorizeRequests()
                .antMatchers(OAUTH).permitAll()
                .antMatchers(TOKEN_BASED_AUTH_ENTRY_POINT).authenticated() // Protected API End-points
                .antMatchers(MANAGE_TOKEN_BASED_AUTH_ENTRY_POINT).permitAll()
                .and()
                .addFilterBefore(buildLoginProcessingFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(buildTokenAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class);
        http.formLogin()
                .loginPage(FORM_BASED_LOGIN_ENTRY_POINT)
                .failureUrl("/error")
                .and()
                .httpBasic();

    }

}
