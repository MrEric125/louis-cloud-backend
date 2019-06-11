package com.louis.zuul.filter;

import com.louis.common.web.web.utils.RequestUtil;
import com.louis.core.utils.PublicUtil;
import com.louis.exception.BusinessException;
import com.louis.zuul.interceptor.CoreHeaderInterceptor;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author louis
 * <p>
 * Date: 2019/6/11
 * Description:
 */
@Component
@Slf4j
public class AuthHeaderFilter extends ZuulFilter {

    private static final String BEARER_TOKEN_TYPE = "TOKEN_ ";
    private static final String OPTIONS = "OPTIONS";
    private static final String AUTH_PATH = "/auth";
    private static final String LOGOUT_URI = "/oauth/token";
    private static final String ALIPAY_CALL_URI = "/pay/alipayCallback";
    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws BusinessException {
        if (log.isInfoEnabled()) {
            log.info("AuthHeaderFilter>>>>>> 开始验证");
        }
        doFilter(RequestContext.getCurrentContext());
        return null;
    }

    private void doFilter(RequestContext requestContext) {
        HttpServletRequest request = requestContext.getRequest();
        String requestURI = request.getRequestURI();
        if (OPTIONS.equalsIgnoreCase(request.getMethod()) || !requestURI.contains(AUTH_PATH) || !requestURI.contains(LOGOUT_URI) || !requestURI.contains(ALIPAY_CALL_URI)) {
            return;
        }
        String authHeader = RequestUtil.getAuthHeader(request);


        if (authHeader.startsWith(BEARER_TOKEN_TYPE)) {
            requestContext.addZuulRequestHeader(HttpHeaders.AUTHORIZATION, authHeader);

            log.info("authHeader={} ", authHeader);
            // 传递给后续微服务，这一步很重要 否则教研token 失败
            requestContext.addZuulRequestHeader(CoreHeaderInterceptor.HEADER_LABEL, authHeader);
        }

    }
}
