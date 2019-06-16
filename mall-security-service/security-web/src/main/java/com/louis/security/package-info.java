/**
 *
 * @author louis
 * <p>
 * Date: 2019/6/14
 * Description:
 * 这里是关于spring security 相关重点接口的一些理解
 */
/** 认证接口，实现这个接口自定义认证逻辑
 * {@link org.springframework.security.authentication.AuthenticationProvider}
 * 用户访问控制的，它决定了用户是否可以访问某个资源，实现这个节都自定义我们的授权逻辑
 * {@link org.springframework.security.access.AccessDecisionManager}
 * 用户加载特定用户的，它只有一个接口通过指定的用户名去查询用户。
 * {@link org.springframework.security.core.userdetails.UserDetailsService}
 * 用户信息，可以让我们的登录用户实现这个类
 * {@link org.springframework.security.core.userdetails.UserDetails}
 */
package com.louis.security;