package com.louis.zuul.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author louis
 * <p>
 * Date: 2019/6/11
 * Description:
 */
public class CoreHeaderInterceptor extends HandlerInterceptorAdapter {

    /**
     * The constant HEADER_LABEL.
     */
    public static final String HEADER_LABEL = "x-label";
}
