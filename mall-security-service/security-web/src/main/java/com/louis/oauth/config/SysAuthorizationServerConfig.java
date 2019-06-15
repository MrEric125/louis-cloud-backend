package com.louis.oauth.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import static com.louis.core.constant.SecurityConstan.CLIENT_CREDENTIALS;
import static com.louis.core.constant.SecurityConstan.PASSWORD;
import static com.louis.core.constant.SecurityConstan.REFRESH_TOKEN;

/**
 * @author Eric
 * @date create in 2019/6/15
 */
@Slf4j
@Configuration
@EnableAuthorizationServer
public class SysAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {


//    @Autowired
//    RestClientDetailsServiceImpl restClientDetailsService;



    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        log.info(">>>>>>>>>  security auto config");
//        clients.withClientDetails(restClientDetailsService);
                clients.inMemory()
                .withClient("admin")
                .secret("{noop}admin")
                .authorizedGrantTypes(REFRESH_TOKEN,PASSWORD,CLIENT_CREDENTIALS)
                .scopes("webclient", "mobileclient");
    }


}
