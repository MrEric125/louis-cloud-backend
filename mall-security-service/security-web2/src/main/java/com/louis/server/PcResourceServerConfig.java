
package com.louis.server;

import com.louis.security.PcAuthenticationSuccessHandler;
import com.louis.security.authentication.FormAuthenticationConfig;
import com.louis.security.authorize.AuthorizeConfigManager;
import com.louis.security.server.PcSecurityExpressionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 资源服务器配置
 *
 * @author John·Louis
 */
@Configuration
@EnableResourceServer
public class PcResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private PcSecurityExpressionHandler pcSecurityExpressionHandler;

	@Autowired
	private AccessDeniedHandler pcAccessDeniedHandler;

	@Autowired
	protected PcAuthenticationSuccessHandler pcAuthenticationSuccessHandler;

	@Autowired
	protected AuthenticationFailureHandler pcAuthenticationFailureHandler;

	//	@Autowired
//	private OpenIdAuthenticationSecurityConfig openIdAuthenticationSecurityConfig;

//	@Autowired
//	private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
//
//	@Autowired
//	private ValidateCodeSecurityConfig validateCodeSecurityConfig;

	@Autowired
	private SpringSocialConfigurer pcSocialSecurityConfig;

	@Autowired
	private AuthorizeConfigManager authorizeConfigManager;

	@Autowired
	private FormAuthenticationConfig formAuthenticationConfig;


	@Resource
	private DataSource dataSource;



	/**
	 * Configure.
	 *
	 * @param http the http
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		formAuthenticationConfig.configure(http);
		http.headers().frameOptions().disable();
		http.
				apply(pcSocialSecurityConfig)
//				.and()
//				.apply(validateCodeSecurityConfig)
//				.and()
//				.apply(smsCodeAuthenticationSecurityConfig)
//				.and()
//				.apply(openIdAuthenticationSecurityConfig)

				.and()
				.exceptionHandling().accessDeniedHandler(pcAccessDeniedHandler)
				.and()
				.csrf().disable();

		authorizeConfigManager.config(http.authorizeRequests());
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.expressionHandler(pcSecurityExpressionHandler);
	}
}