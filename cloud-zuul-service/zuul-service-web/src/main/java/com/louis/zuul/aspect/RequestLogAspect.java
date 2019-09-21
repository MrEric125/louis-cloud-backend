package com.louis.zuul.aspect;

import com.louis.common.api.dto.ClientMessageDto;
import com.louis.core.utils.ClientMessageUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author John·Louis
 * @date create in 2019/7/20
 * description:
 * 记录相关信息到日志文件，后期分析访问使用
 * 记录信息包括，访问地址，访问时间，客户ip，客户浏览器，有账号就显示账号，
 */
@Configuration
@Aspect
@Slf4j
public class RequestLogAspect {

    private ThreadLocal<Long> startTime = new ThreadLocal<>();


    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping) " +
            "|| @annotation(org.springframework.web.bind.annotation.PostMapping) " +
            "|| @annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before() {
        startTime.set(System.currentTimeMillis());
    }

    @After("pointCut()")
    public void after() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        ClientMessageDto clientMessage = ClientMessageUtil.findClientMessage(request);
        int status = response.getStatus();
        log.error("========================");
        log.error("log message:{},{}", request.getRequestURI(), request.getMethod());
        log.error("========================");



    }



}
