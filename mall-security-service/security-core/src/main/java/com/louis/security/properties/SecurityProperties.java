package com.louis.security.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/13
 * Description:
 */
@Configuration
@ConfigurationProperties(prefix ="louis.security" )
public class SecurityProperties {


    /**
     * 浏览器环境配置
     */
    private BrowserProperties browser = new BrowserProperties();
    /**
     * 验证码配置
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();
    /**
     * 社交登录配置
     */
    private SocialProperties social = new SocialProperties();
    /**
     * OAuth2认证服务器配置
     */
    private OAuth2Properties oauth2 = new OAuth2Properties();

    /**
     * Gets browser.
     *
     * @return the browser
     */
    public BrowserProperties getBrowser() {
        return browser;
    }

    /**
     * Sets browser.
     *
     * @param browser the browser
     */
    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public ValidateCodeProperties getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }

    /**
     * Gets social.
     *
     * @return the social
     */
    public SocialProperties getSocial() {
        return social;
    }

    /**
     * Sets social.
     *
     * @param social the social
     */
    public void setSocial(SocialProperties social) {
        this.social = social;
    }

    /**
     * Gets oauth 2.
     *
     * @return the oauth 2
     */
    public OAuth2Properties getOauth2() {
        return oauth2;
    }

    /**
     * Sets oauth 2.
     *
     * @param oauth2 the oauth 2
     */
    public void setOauth2(OAuth2Properties oauth2) {
        this.oauth2 = oauth2;
    }





}
