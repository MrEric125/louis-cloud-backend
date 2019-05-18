package com.louis.security.oauth.controller;

import com.google.common.collect.Maps;
import com.louis.security.oauth.common.ResponseCode;
import com.louis.security.oauth.config.TokenProperties;
import com.louis.security.oauth.config.WebSecurityConfig;
import com.louis.security.oauth.exception.InvalidTokenException;
import com.louis.security.oauth.model.UserContext;
import com.louis.security.oauth.oauth.extractor.TokenExtractor;
import com.louis.security.oauth.oauth.token.RawAccessToken;
import com.louis.security.oauth.oauth.token.RefreshToken;
import com.louis.security.oauth.oauth.token.Token;
import com.louis.security.oauth.oauth.token.TokenFactory;
import com.louis.security.oauth.oauth.verifier.TokenVerifier;
import com.louis.security.oauth.entity.SysUserInfo;
import com.louis.security.oauth.entity.UserRole;
import com.louis.security.oauth.service.SysUserService;
import com.louis.security.oauth.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Eric
 * @date create in 2019/4/14
 */
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    TokenProperties tokenProperties;

    @Autowired
    TokenVerifier tokenVerifier;
    @Autowired
    TokenFactory tokenFactory;

    @Autowired
    TokenExtractor tokenExtractor;

    @Autowired
    SysUserService userService;

    @Autowired
    UserRoleService userRoleService;


    @GetMapping("/test1")
    public String test1() {
        return "test1";
    }

    @GetMapping("/api/test2")
    public String test2() {
        return "test2";
    }

    @GetMapping("/manage/test3")
    public String test3() {
        return "test3";
    }

    @GetMapping("/api/auth/refresh_token")
    public Token test4(HttpServletRequest request) {
        String tokenPayload = tokenExtractor.extract(request.getHeader(WebSecurityConfig.TOKEN_HEADER_PARAM));
//        String tokenPayload = tokenExtractor.extract("");
        RawAccessToken rawToken = new RawAccessToken(tokenPayload);
        RefreshToken refreshToken = RefreshToken.create(rawToken, tokenProperties.getSigningKey()).orElseThrow(() -> new InvalidTokenException("Token验证失败"));

        String jti = refreshToken.getJti();
        if (!tokenVerifier.verify(jti)) {
            throw new InvalidTokenException("Token验证失败");
        }

        String subject = refreshToken.getSubject();
        SysUserInfo user = Optional.ofNullable(userService.findByUserName(subject)).orElseThrow(() -> new UsernameNotFoundException("用户未找到: " + subject));
        List<UserRole> roles = Optional.ofNullable(userRoleService.getRoleByUser(user)).orElseThrow(() -> new InsufficientAuthenticationException("用户没有分配角色"));
        List<GrantedAuthority> authorities = roles.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.authority()))
                .collect(Collectors.toList());

        UserContext userContext = UserContext.create(user.getUsername(), authorities);
        return tokenFactory.createAccessToken(userContext);
    }



    @RequestMapping(value = "/message",produces = "application/json")
    public ResponseCode user(OAuth2Authentication user) {
        Map<String, Object> userInfo = Maps.newHashMap();
        userInfo.put("user", user.getUserAuthentication().getPrincipal());
        userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
        return new ResponseCode("200", userInfo);

    }
}
