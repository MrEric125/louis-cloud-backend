package com.louis.security.config;

import com.google.common.collect.Maps;
import com.louis.security.core.SecurityUser;
import com.louis.server.entity.SysUser;
import com.louis.server.entity.UserRole;
import com.louis.server.service.SysUserService;
import com.louis.server.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author John·Louis
 * @date create in 2019/6/16
 */
@Slf4j
@Service
public class SecurityUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    SysUserService sysUserService;

    @Autowired
    UserRoleService userRoleService;


    /**
     * 存放用户缓存的
     */
    private Map<String, SecurityUser> userDetails = Maps.newHashMap();


    /**
     * 通过用户名查找用户详情
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SecurityUser securityUser = userDetails.get(username);
        if (securityUser == null) {
            SysUser user = sysUserService.findByUserName(username);
            user = Optional.ofNullable(user).orElseThrow(() -> new BadCredentialsException("用户名不存在"));
            if (log.isInfoEnabled()) {
                log.info("load user by user :username:{},userId{},", user.getUsername(), user.getId());
            }
            List<UserRole> userRoles = userRoleService.findByUserId(user.getId());
            List<GrantedAuthority> authorities = userRoles.stream()
                    .map(authority -> new SimpleGrantedAuthority(
                            authority.authority()
                    ))
                    .collect(Collectors.toList());
            securityUser = new SecurityUser(user.getId(), user.getUsername(), user.getPassword(),
                    user.getRealName(), user.getGroupId(), user.getGroupName(), user.getStatus(), authorities);
            userDetails.put(username, securityUser);
        }
        return securityUser;


    }


}
