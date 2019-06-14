/**
 * @author John·Louis
 * @date create in 2019/6/9
 * <p>
 * description: spring security filter
 * {@link org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter}
 * {@link org.springframework.security.web.context.SecurityContextPersistenceFilter}
 * {@link org.springframework.security.web.header.HeaderWriterFilter}
 * {@link org.springframework.web.filter.CorsFilter}
 * {@link org.springframework.security.web.authentication.logout.LogoutFilter}
 * {@link org.springframework.security.web.savedrequest.RequestCacheAwareFilter}
 * {@link org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter}
 * {@link org.springframework.security.web.authentication.www.BasicAuthenticationFilter}
 * {@link org.springframework.security.web.authentication.AnonymousAuthenticationFilter}
 * {@link org.springframework.security.web.session.SessionManagementFilter}
 * {@link org.springframework.security.web.access.ExceptionTranslationFilter}
 * {@link org.springframework.security.web.access.intercept.FilterSecurityInterceptor}
 * 处理登录流程的过滤器，可以自定义登录路径在初始化这个过滤器的时候
 * {@link com.louis.security.filter.LoginProcessingFilter}
 * {@link com.louis.security.filter.TokenAuthenticationProcessingFilter}
 * {@link org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter}
 *
 */
package com.louis.security.filter;