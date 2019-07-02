package com.louis.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 * @author Eric
 * @date create in 2019/4/14
 */
@ConfigurationProperties( prefix = "louis.token")
public class TokenProperties {


    private Integer expirationTime=10;

    /**
     * 发行人
     */
    private String issuer="issuer";


    private String signingKey="singingKey";


    private Integer refreshExpTime=10;

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
