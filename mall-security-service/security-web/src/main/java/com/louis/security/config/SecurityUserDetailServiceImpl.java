package com.louis.security.config;

import com.louis.security.core.SecurityUser;
import com.louis.server.entity.SysUser;
import com.louis.server.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * @author John·Louis
 * @date create in 2019/6/16
 */
@Slf4j
@Service
public class SecurityUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    SysUserService sysUserService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserService.findByUserName(username);
        user=Optional.ofNullable(user).orElseThrow(() -> new BadCredentialsException("用户名不存在"));
        if (log.isInfoEnabled()) {
            log.info("load user by user :username:{},userId{},",user.getUsername(),user.getId());
        }
        Collection<GrantedAuthority> grantedAuthorities = sysUserService.loadUserAuthorities(user.getId());
        return new SecurityUser(user.getId(), user.getUsername(), user.getPassword(),
                user.getRealName(), user.getGroupId(), user.getGroupName(), user.getStatus(), grantedAuthorities);



    }
}
