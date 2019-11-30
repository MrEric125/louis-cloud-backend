package com.louis.oauth;

import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.web.web.anontation.SpringCloudClient;
import com.louis.core.repository.SimpleBaseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author John·Louis
 * @date create in 2019/11/9
 * description:
 */
@SpringCloudClient
@RestController
@EnableResourceServer
@EnableJpaRepositories(repositoryBaseClass = SimpleBaseRepository.class)
public class OauthApp {
    @RequestMapping(value = { "/user" }, produces = "application/json")
    public Map<String, Object> user(OAuth2Authentication user) {
        Map<String, Object> userInfo = new HashMap<>();
        if (user != null) {
            userInfo.put("active", "true");
            userInfo.put("user", user.getUserAuthentication().getPrincipal());
            userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
        }
        return userInfo;
    }
    @RequestMapping("/")
    public Wrapper home(OAuth2Authentication user) {
//        Map<String, Object> userInfo = new HashMap<>();
//        userInfo.put("user", user.getUserAuthentication().getPrincipal());
//        userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
        return WrapMapper.wrap("this is home page");


    }

    public static void main(String[] args) {
        SpringApplication.run(OauthApp.class, args);
    }


}
