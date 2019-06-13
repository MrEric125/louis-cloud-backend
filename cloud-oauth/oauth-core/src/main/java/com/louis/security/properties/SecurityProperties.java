package com.louis.security.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author louis
 * <p>
 * Date: 2019/6/13
 * Description:
 */
@Setter
@Getter
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




}
