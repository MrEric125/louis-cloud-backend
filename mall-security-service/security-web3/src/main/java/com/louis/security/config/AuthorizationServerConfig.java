package com.louis.security.config;

import com.louis.security.server.SecurityClientDetailService;
import com.louis.security.server.SecurityUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;


/**
 * @author John·Louis
 * @date create in 2019/6/15
 */

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String PASSWORD = "password";
    public static final String CLIENT_CREDENTIALS = "client_credentials";
    public static final String AUTHORIZATION_CODE = "authorization_code";



    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //    @Primary
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Autowired
//    private TokenStore tokenStore;


    public ClientDetailsService clientDetailsService() {
        return new SecurityClientDetailService();
    }



    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    SecurityUserDetailService userDetailsService;


/**
     * （重点）授权模式，但是前提要钱是要认证(登陆成功)的时候才会授权
     * @param clients
     * @throws Exception
     */


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("client")
                .secret(passwordEncoder.encode("secret"))
                .authorizedGrantTypes("authorization_code")
                .scopes("webclient")
                .redirectUris("https://www.baidu.com");
//        clients.withClientDetails(clientDetailsService());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        super.configure(endpoints);
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
//                .tokenStore(tokenStore);
//        endpoints.tokenStore(tokenStore());
    }

    /*
     * 设置表单
     * @param security
     * @throws Exception
     *
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()");
        security.allowFormAuthenticationForClients();
    }
}
