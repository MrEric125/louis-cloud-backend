package com.louis.core.utils;

import com.louis.common.api.dto.ClientMessageDto;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/20
 * Description:
 */
@Service
@Slf4j
public class ClientMessageUtil {


    /**
     * 获取客户端相关信息
     * @param request
     * @return
     */
    public static ClientMessageDto findClientMessage(HttpServletRequest request) {
        log.info("search client message");
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        //获取客户端操作系统
        String os = userAgent.getOperatingSystem().getName();
        //获取客户端浏览器
        String browser = userAgent.getBrowser().getName();
        String ipAddr = IpUtils.getIpAddr(request);
        // 根据IP获取位置信息
        String remoteLocation = RequestUtil.getLocationByIp(ipAddr);
        String requestURI = request.getRequestURI();
        ClientMessageDto messageDto = ClientMessageDto.builder().os(os)
                .browser(browser)
                .ip(ipAddr)
                .remoteLocation(remoteLocation)
                .requestURI(requestURI)
                .build();
        return messageDto;
    }
}
