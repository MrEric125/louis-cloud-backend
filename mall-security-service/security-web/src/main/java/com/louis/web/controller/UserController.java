package com.louis.web.controller;

import com.google.common.collect.Maps;
import com.louis.common.api.dto.IdName;
import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.exception.InvalidTokenException;
import com.louis.oauth.dto.RegistryUserDto;
import com.louis.security.extractor.TokenExtractor;
import com.louis.common.ResponseCode;
import com.louis.properties.TokenProperties;
import com.louis.security.config.WebSecurityConfig;
import com.louis.server.entity.SysUser;
import com.louis.oauth.model.UserContext;
import com.louis.server.entity.UserRole;
import com.louis.server.service.PasswordService;
import com.louis.server.service.SysRoleService;
import com.louis.server.service.SysUserService;
import com.louis.server.service.UserRoleService;
import com.louis.security.token.RawAccessToken;
import com.louis.security.token.RefreshToken;
import com.louis.security.token.Token;
import com.louis.security.token.TokenFactory;
import com.louis.verifier.TokenVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Eric
 * @date create in 2019/4/14
 */
@RestController("web-userController" )
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    private final TokenProperties tokenProperties;

    private final TokenVerifier tokenVerifier;

    private final TokenFactory tokenFactory;

    private final TokenExtractor tokenExtractor;

    private final SysUserService userService;

    private final UserRoleService userRoleService;


    @Autowired
    public UserController(TokenProperties tokenProperties, TokenVerifier tokenVerifier, TokenFactory tokenFactory, TokenExtractor tokenExtractor, SysUserService userService, UserRoleService userRoleService) {
        this.tokenProperties = tokenProperties;
        this.tokenVerifier = tokenVerifier;
        this.tokenFactory = tokenFactory;
        this.tokenExtractor = tokenExtractor;
        this.userService = userService;
        this.userRoleService = userRoleService;
    }


    @GetMapping("/test1")
    public String test1() {
        return "test1";
    }


    @GetMapping("/api/auth/refresh_token")
    public Token tokenRefresh(HttpServletRequest request) {
        String tokenPayload = tokenExtractor.extract(request.getHeader(WebSecurityConfig.TOKEN_HEADER_PARAM));
//        String tokenPayload = tokenExtractor.extract("");
        RawAccessToken rawToken = new RawAccessToken(tokenPayload);
        RefreshToken refreshToken = RefreshToken.create(rawToken, tokenProperties.getSigningKey()).orElseThrow(() -> new InvalidTokenException("Token验证失败"));

        String jti = refreshToken.getJti();
        if (!tokenVerifier.verify(jti)) {
            throw new InvalidTokenException("Token验证失败");
        }

        String subject = refreshToken.getSubject();
        SysUser user = Optional.ofNullable(userService.findByUserName(subject)).orElseThrow(() -> new UsernameNotFoundException("用户未找到: " + subject));
        List<UserRole> roles = Optional.ofNullable(userRoleService.findByUserId(user.getId())).orElseThrow(() -> new InsufficientAuthenticationException("用户没有分配角色"));
        List<GrantedAuthority> authorities = roles.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.authority()))
                .collect(Collectors.toList());

        UserContext userContext = UserContext.create(user.getUsername(), authorities);
        return tokenFactory.createAccessToken(userContext);
    }




    /**
     * 通过用户名查找用户，可以再注册用户的时候用
     * @param userName
     * @return
     */
    @GetMapping("byName/{userName}")
    public ResponseCode findByUserName(@PathVariable("userName") String userName) {
        SysUser sysUser = userService.findByUserName(userName);
        return Optional
                .ofNullable(sysUser)
                .map(sysUser1 -> new ResponseCode("success", new IdName<>(sysUser.getId(), sysUser.getUsername())))
                .orElse(new ResponseCode("success", "您查找的用戶爲空"));
    }



    @GetMapping(value = "/manage/user",produces = "application/json")
    public ResponseCode user(Authentication user) {
        Map<String, Object> userInfo = Maps.newHashMap();
        userInfo.put("user", user.getPrincipal());
        userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getAuthorities()));
        return new ResponseCode("200", userInfo);

    }
}
