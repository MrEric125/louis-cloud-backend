package com.louis.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author Eric
 * @date create in 2019/5/21
 *
 * zuul 前置过滤器，用于授权验证
 */
@Component
@Slf4j
public class PreFilter extends ZuulFilter {


    private static final int FILTER_ORDER = 1;
    private static final boolean SHOULD_FILTER = true;

    @Autowired
    FilterUtils filterUtils;


    /**
     * 告诉zuul 这是一个前置过滤器
     * @return
     */
    @Override
    public String filterType() {
        return FilterUtils.PRE_FILTER_TYPE;
    }

    /**
     * 指示不同类型的过滤器的执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    private String generateCorrelationId() {
        return UUID.randomUUID().toString();
    }
    private boolean isCorrelationIdPresent() {
        return StringUtils.isNoneEmpty(filterUtils.getCorrelationId());
    }

    @Override
    public Object run() throws ZuulException {
        if (isCorrelationIdPresent()) {
            log.debug("tmx-correlation-id found in tracking filter: {}. ", filterUtils.getCorrelationId());
        }
        else{
            filterUtils.setCorrelationId(generateCorrelationId());
            log.debug("tmx-correlation-id generated in tracking filter: {}.", filterUtils.getCorrelationId());
        }

        RequestContext ctx = RequestContext.getCurrentContext();
        log.debug("Processing incoming request for {}.",  ctx.getRequest().getRequestURI());
        return null;
    }
}
