package com.louis.security.server;

import com.louis.security.core.SecurityUser;
import com.louis.server.entity.SysUser;
import com.louis.server.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Collection;

/**
 * @author louis
 * <p>
 * Date: 2019/6/19
 * Description: spring security 用戶詳情邏輯
 */
@Component
public class SecurityUserDetailService implements UserDetailsService {
    private static final String ROLE_PREFIX = "ROLE_";


    @Autowired
    SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> grantedAuthorities;
        SysUser user = sysUserService.findByUserName(username);
        if (user == null) {
            throw new BadCredentialsException("用户名不存在或者密码错误");
        }
//        user = sysUserService.findUserInfoByUserId(user.getId());
        grantedAuthorities = sysUserService.loadUserAuthorities(user.getId());
        return new SecurityUser(user.getId(), user.getUsername(), user.getPassword(),
                user.getRealName(), user.getGroupId(), user.getGroupName(), user.getStatus(), grantedAuthorities);

    }
    private String prefixRoleName(String roleName){
        if (!StringUtils.isEmpty(roleName) && !roleName.startsWith(ROLE_PREFIX)){
            return ROLE_PREFIX + roleName;
        }
        return roleName;
    }
}
