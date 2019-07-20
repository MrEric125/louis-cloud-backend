package com.louis.common.web.web.utils;

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
        String remoteAddr = request.getRemoteAddr();
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
                if (ipAddress.equals("127.0.0.1")||ipAddress.equals("0:0:0:0:0:0:0:1")) {
                    // 根据网卡取本机配置的IP
                    InetAddress inetAddress ;
                    try {
                        inetAddress = InetAddress.getLocalHost();
                        ipAddress = inetAddress.getHostAddress();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (ipAddress!=null&& ipAddress.length()>15) {
                if (ipAddress.indexOf(",")>0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
                }
            }
        } catch (Exception e) {
           log.error("get ip address error: {}",e.getMessage());
            e.printStackTrace();

        }
        return ipAddress;
    }
}
