package com.louis.security;

import com.louis.security.oauth.entity.SysUser;
import com.louis.security.oauth.service.SysUserService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * The class Uac user details service.
 *
 * @author paascloud.net @gmail.com
 */
@Component
public class UacUserDetailsServiceImpl implements UserDetailsService {

	@Resource
	private SysUserService userService;

	/**
	 * Load user by username user details.
	 *
	 * @param username the username
	 *
	 * @return the user details
	 */
	@Override
	public UserDetails loadUserByUsername(String username) {
		Collection<GrantedAuthority> grantedAuthorities;
		SysUser user = userService.findByUserName(username);
		if (user == null) {
			throw new BadCredentialsException("用户名不存在或者密码错误");
		}
		user = userService.findUserInfoByUserId(user.getId());
		grantedAuthorities = userService.loadUserAuthorities(user.getId());
		return new SecurityUser(user.getId(), user.getUsername(), user.getPassword(),
				user.getRealName(),null,null, user.getStatus(), grantedAuthorities);
	}
}