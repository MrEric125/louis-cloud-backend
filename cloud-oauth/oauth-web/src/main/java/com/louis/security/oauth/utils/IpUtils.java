package com.louis.security.oauth.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Eric
 * @date create in 2019/5/19
 */
@Slf4j
public class IpUtils {


    public static String getIpAddr(HttpServletRequest request) {

        String ipAddress = null;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (StringUtils.isEmpty(ipAddress) || StringUtils.equals("unknown", ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (StringUtils.isEmpty(ipAddress) || StringUtils.equals("unknown", ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (ipAddress.equals("127.0.0.1")) {
                    // 根据网卡取本机配置的IP
                    InetAddress inet = InetAddress.getLocalHost();
                    ipAddress = inet.getHostAddress();
                }
            }

        } catch (Exception e) {
           log.error("get ip address error: {}",e.getMessage());
            e.printStackTrace();

        }
        return ipAddress;
    }
}
