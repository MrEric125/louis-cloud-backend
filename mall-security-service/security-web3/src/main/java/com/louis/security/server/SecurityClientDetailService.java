package com.louis.security.server;

import com.louis.security.properties.OAuth2ClientProperties;
import com.louis.security.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author louis
 * <p>
 * Date: 2019/6/19
 * Description:
 */
@Slf4j
@Service
public class SecurityClientDetailService implements ClientDetailsService {

    private ClientDetailsService clientDetailsService;

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * Init.
     */
    @PostConstruct
    public void init() {
        InMemoryClientDetailsServiceBuilder builder = new InMemoryClientDetailsServiceBuilder();
        OAuth2ClientProperties[] clients = securityProperties.getOauth2().getClients();
        if (ArrayUtils.isNotEmpty(clients)) {
            for (OAuth2ClientProperties client : clients) {
                builder.withClient(client.getClientId())
                        .secret(client.getClientSecret())
                        .authorizedGrantTypes("refresh_token", "password", "client_credentials","authorization_code")
                        .accessTokenValiditySeconds(client.getAccessTokenValidateSeconds())
                        .refreshTokenValiditySeconds(client.getRefreshTokenValiditySeconds())
                        .redirectUris("https://www.baidu.com")
                        .scopes(client.getScope());
            }
        } else {
            builder.withClient("adminClient")
                    .secret("adminClient")
                    .authorizedGrantTypes("refresh_token", "password", "client_credentials", "authorization_code")
                    .accessTokenValiditySeconds(30000)
                    .refreshTokenValiditySeconds(30000)
                    .redirectUris("https://www.baidu.com")
                    .scopes("webclient");
        }
        try {
            clientDetailsService = builder.build();

        } catch (Exception e) {
            log.error("init={}", e.getMessage(), e);
        }
    }



    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        return clientDetailsService.loadClientByClientId(clientId);
    }

}
