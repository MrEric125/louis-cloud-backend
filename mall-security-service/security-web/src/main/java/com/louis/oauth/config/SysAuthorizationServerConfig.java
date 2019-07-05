package com.louis.oauth.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

import static com.louis.core.constant.SecurityConstan.CLIENT_CREDENTIALS;
import static com.louis.core.constant.SecurityConstan.PASSWORD;
import static com.louis.core.constant.SecurityConstan.REFRESH_TOKEN;

/**
 * @author John·Louis
 * @date create in 2019/6/15
 */
@Slf4j
@Configuration
@EnableAuthorizationServer
public class SysAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {





    @Autowired
    private DataSource dataSource;

    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    /**
     * 使用的是我们自己实现的clientDetailsService
     * @return
     */
    public ClientDetailsService clientDetailsService() {
        return new SecurityClientDetailsService();
    }


    /**
     * (重点）授权模式 但是在授权之前是要认证的(也就是登录)的时候才会出现，我们给授权完之后有一个回调，
     * 默认系统的回调是首页
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        log.info(">>>>>>>>>  security auto config");
//        clients.withClientDetails(restClientDetailsService);
//                clients.inMemory()
//                .withClient("admin")
//                .secret("{noop}admin")
//                .authorizedGrantTypes(REFRESH_TOKEN,PASSWORD,CLIENT_CREDENTIALS)
//                .scopes("webclient", "mobileclient");
        clients.withClientDetails(clientDetailsService());
    }


}
