package com.louis.common.web.web.utils;

import com.google.common.net.HttpHeaders;
import com.louis.exception.BusinessException;
import com.louis.exception.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.codec.Base64;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

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

    public static String getLocationByIp(String addressIP) {
        return null;
    }

    public static String[] extractAndDecodeHeader(String header) throws IOException {

        byte[] base64Token = header.substring(6).getBytes(StandardCharsets.UTF_8);
        byte[] decoded;
        try {
            decoded = Base64.decode(base64Token);
        } catch (IllegalArgumentException e) {
            throw new BadCredentialsException("Failed to decode basic authentication token");
        }

        String token = new String(decoded, StandardCharsets.UTF_8);

        int delim = token.indexOf(":");

        if (delim == -1) {
            throw new BadCredentialsException("Invalid basic authentication token");
        }
        return new String[]{token.substring(0, delim), token.substring(delim + 1)};
    }
}
