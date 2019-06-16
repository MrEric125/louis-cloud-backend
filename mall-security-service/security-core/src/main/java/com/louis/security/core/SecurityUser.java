

package com.louis.security.core;

import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * The class Security user. extends from  spring security
 *
 * @author John·Louis
 */


public class SecurityUser implements UserDetails {
	private static final long serialVersionUID = 4872628781561412463L;


	private Collection<GrantedAuthority> authorities;

	private Long userId;

	private String nickName;

	private String loginName;

	private String loginPwd;

	private int status;

	private Long groupId;

	private String groupName;

	public SecurityUser(Long userId, String loginName, String loginPwd, String nickName, Long groupId, String groupName) {
		this.setUserId(userId);
		this.setLoginName(loginName);
		this.setLoginPwd(loginPwd);
		this.setNickName(nickName);
//		this.setGroupId(groupId);
//		this.setGroupName(groupName);
	}

	public SecurityUser(Long userId, String loginName, String loginPwd, String nickName, Long groupId, String groupName, int status, Collection<GrantedAuthority> grantedAuthorities) {
		this.setUserId(userId);
		this.setLoginName(loginName);
		this.setLoginPwd(loginPwd);
		this.setNickName(nickName);
//		this.setGroupId(groupId);
//		this.setGroupName(groupName);
		this.setStatus(status);
		this.authorities = grantedAuthorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.getLoginPwd();
	}

	@Override
	public String getUsername() {
		return this.getLoginName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return 1 == this.status;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
