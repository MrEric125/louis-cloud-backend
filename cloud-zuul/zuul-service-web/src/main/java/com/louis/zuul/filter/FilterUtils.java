package com.louis.zuul.filter;

import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author Eric
 * @date create in 2019/5/21
 */
@Component
public class FilterUtils {

    public static final String CORRELATION_ID = "tmx-correlation-id";
    public static final String AUTH_TOKEN     = "tmx-auth-token";
    public static final String USER_ID        = "tmx-user-id";
    public static final String ORG_ID         = "tmx-org-id";
    public static final String PRE_FILTER_TYPE = "pre";
    public static final String POST_FILTER_TYPE = "post";
    public static final String ROUTE_FILTER_TYPE = "route";

    private RequestContext context = RequestContext.getCurrentContext();
    /**
     *
     * @return correlation-id
     */
    public String  getCorrelationId() {

        if (StringUtils.isNoneEmpty(context.getRequest().getHeader(CORRELATION_ID))) {
            return context.getRequest().getHeader(CORRELATION_ID);
        }
        return context.getZuulRequestHeaders().get(CORRELATION_ID);
    }

    public void setCorrelationId(String orgId) {
        context.addZuulRequestHeader(ORG_ID, orgId);
    }
    public final String getUserId(){
        
        if (context.getRequest().getHeader(USER_ID) !=null) {
            return context.getRequest().getHeader(USER_ID);
        }
        else{
            return  context.getZuulRequestHeaders().get(USER_ID);
        }
    }

    public void setUserId(String userId){
        
        context.addZuulRequestHeader(USER_ID,  userId);
    }

    public final String getAuthToken(){
        
        return context.getRequest().getHeader(AUTH_TOKEN);
    }

    public String getServiceId(){
       

        //We might not have a service id if we are using a static, non-eureka route.
        if (context.get("serviceId")==null) return "";
        return context.get("serviceId").toString();
    }




}
