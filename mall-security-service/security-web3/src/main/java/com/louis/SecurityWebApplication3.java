package com.louis;

import com.louis.common.web.web.anontation.SpringCloudClient;
import com.louis.core.repository.SimpleBaseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * Spring security oauth2 集成第三方登录
 * https://funtl.com/zh/spring-security-oauth2/%E5%AF%B9%E8%AE%A4%E8%AF%81%E6%9C%8D%E5%8A%A1%E5%99%A8%E7%9A%84%E4%BF%AE%E6%94%B9.html#%E5%88%9D%E5%A7%8B%E5%8C%96-rbac-%E7%9B%B8%E5%85%B3%E8%A1%A8
 */
@SpringCloudClient
@RestController
@EnableJpaRepositories(repositoryBaseClass = SimpleBaseRepository.class)
public class SecurityWebApplication3 {

    @RequestMapping(value = { "/user" }, produces = "application/json")
    public Map<String, Object> user(OAuth2Authentication user) {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("user", user.getUserAuthentication().getPrincipal());
        userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
        return userInfo;
    }

    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("org/security/message_zh");
        return messageSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(SecurityWebApplication3.class, args);
    }

}
