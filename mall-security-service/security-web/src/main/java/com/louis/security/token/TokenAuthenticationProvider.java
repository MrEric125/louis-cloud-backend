package com.louis.security.token;


import com.louis.properties.TokenProperties;
import com.louis.security.oauth.model.UserContext;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Eric
 * @date create in 2019/4/14
 */
@Slf4j
@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {

    private final TokenProperties tokenProperties;

    @Autowired
    public TokenAuthenticationProvider(TokenProperties tokenProperties) {
        this.tokenProperties = tokenProperties;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        RawAccessToken rawAccessToken = (RawAccessToken) authentication.getCredentials();
        long startTime = System.currentTimeMillis();
        Jws<Claims> jwsClaims = rawAccessToken.parseClaims(tokenProperties.getSigningKey());
        log.debug("[验证Token消耗时间] - [{}]", (System.currentTimeMillis() - startTime));
        String subject = jwsClaims.getBody().getSubject();
        @SuppressWarnings("unchecked")
        List<String> scopes = jwsClaims.getBody().get("scopes", List.class);
        List<GrantedAuthority> authorities = scopes.stream().map(SimpleGrantedAuthority::new).collect(toList());
        UserContext context = UserContext.create(subject, authorities);
        return new AuthenticationToken(context, context.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (AuthenticationToken.class.isAssignableFrom(authentication));
    }

}
