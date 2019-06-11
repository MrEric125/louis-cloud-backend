package com.louis.common.web.web.utils;

import com.google.common.net.HttpHeaders;
import com.louis.exception.BusinessException;
import com.louis.exception.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author louis
 * <p>
 * Date: 2019/6/11
 * Description:
 */
@Slf4j
public class RequestUtil {


    /**
     * get auth header
     * @param request request
     * @return auth header
     */
    public static String getAuthHeader(HttpServletRequest request) {
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.isEmpty(header)) {
            throw new BusinessException(ErrorCodeEnum.UAC10011040);
        }
        return header;

    }
}
