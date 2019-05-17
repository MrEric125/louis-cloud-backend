package com.louis.security.oauth.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Eric
 * @date create in 2019/4/14
 */
@Configuration
@ConfigurationProperties(prefix = "battcn.security.token")
public class TokenProperties {


    private Integer expirationTime;

    /**
     * 发行人
     */
    private String issuer;


    private String signingKey;


    private Integer refreshExpTime;

    public Integer getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Integer expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getSigningKey() {
        return signingKey;
    }

    public void setSigningKey(String signingKey) {
        this.signingKey = signingKey;
    }

    public Integer getRefreshExpTime() {
        return refreshExpTime;
    }

    public void setRefreshExpTime(Integer refreshExpTime) {
        this.refreshExpTime = refreshExpTime;
    }

}
