package com.louis.security.login;

import com.alibaba.fastjson.JSON;
import com.louis.server.entity.SysUser;
import com.louis.oauth.model.UserContext;
import com.louis.server.entity.UserRole;
import com.louis.server.service.PasswordService;
import com.louis.server.service.SysUserService;
import com.louis.server.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Eric
 * @date create in 2019/4/14
 *
 * 登录验证
 */
@Slf4j
@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {

    private final BCryptPasswordEncoder encoder;
    private final SysUserService userService;
    private final UserRoleService roleService;

    private final PasswordService passwordService;


    public LoginAuthenticationProvider(BCryptPasswordEncoder encoder,
                                       SysUserService userService,
                                       UserRoleService roleService,
                                       PasswordService passwordService) {
        this.encoder = encoder;
        this.userService = userService;
        this.roleService = roleService;
        this.passwordService = passwordService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Assert.notNull(authentication, "No authentication data provided");
        log.debug("[authentication info] - [{}]", JSON.toJSONString(authentication));
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        SysUser user = userService.findByUserName(username);
        if(user == null) throw new UsernameNotFoundException("User not found: " + username);
        boolean matches = passwordService.matches(user, password);
        if (!matches) {
            throw new BadCredentialsException("Authentication Failed. Username or Password not valid.");
        }
        List<UserRole> roles = roleService.findByUserId(user.getId());
        if (roles == null || roles.size() <= 0) throw new InsufficientAuthenticationException("User has no roles assigned");

        List<GrantedAuthority> authorities = roles.stream()
                .map(authority -> new SimpleGrantedAuthority(
                        authority.authority()
                ))
                .collect(Collectors.toList());

        UserContext userContext = UserContext.create(user.getUsername(), authorities);
        userContext.setUserId(user.getId());

        return new UsernamePasswordAuthenticationToken(userContext, null, userContext.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}
