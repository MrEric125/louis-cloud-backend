package com.louis.comment.web.exceptionHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.louis.common.api.dto.IdName;
import com.louis.common.api.dto.LoginAuthDto;
import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.api.wrapper.WrapperMassage;
import com.louis.core.constant.GlobalConstant;
import com.louis.core.utils.ThreadLocalMap;
import com.louis.exception.BusinessException;
import com.louis.exception.ErrorCodeEnum;
import com.louis.stream.dto.ExceptionLogDto;
import com.louis.stream.feign.ExceptionLogFeignApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * @author John·Louis
 * @date create in 2019/7/4
 * description:
 * 框架中，用了某些限制，如果我们访问的时候是*.json 形式那么就会返回json格式，不过不是那么全局异常就会以xml形式返回
 * 这个异常处理类不能放在base中，否则后期对于不同异常处理就会出现高耦合
 * 具体实现在各个web模块中的 #GlobalExceptionHandler
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private HttpServletRequest request;

    private HttpServletResponse response;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.profiles.active}")
    private String profile;

    @ModelAttribute
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ExceptionLogFeignApi exceptionLog;

//    @Value("${spring.profiles.active}")
//    String profile;
//    @Value("${spring.application.name}")
//    String applicationName;

    @Autowired
    private TaskExecutor taskExecutor;

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Wrapper illegalArgumentException(IllegalArgumentException e) {
        request.setAttribute("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);


        log.error("参数非法异常={}", e.getMessage(), e);
        return WrapMapper.wrap(ErrorCodeEnum.GL99990100.code(), e.getMessage());
    }

    /**
     * 业务异常.
     *
     * @param e the e
     *
     * @return the wrapper
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Wrapper businessException(BusinessException e) {
        log.error("业务异常={}", e.getMessage(), e);
        return WrapMapper.wrap(e.getCode() == 0 ? WrapperMassage.ERROR_CODE : e.getCode(), e.getMessage());
    }

   /* *//**
     * 无权限访问.
     *
     * @param e the e
     *
     * @return the wrapper
     *//*
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public Wrapper unAuthorizedException(AccessDeniedException e) {
        log.error("业务异常={}", e.getMessage(), e);
        return WrapMapper.wrap(ErrorCodeEnum.GL99990401.code(), ErrorCodeEnum.GL99990401.msg());
    }*/


    /**
     * 全局异常.
     *
     * @param e the e
     * @return the wrapper
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Wrapper exception(Exception e)  {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        log.error("全局异常信息 ex={}", e.getMessage(), e);
        LoginAuthDto loginAuthDto = (LoginAuthDto) ThreadLocalMap.get(GlobalConstant.Sys.TOKEN_AUTH_DTO);
        IdName<Long> user = new IdName<>(loginAuthDto.getUserId(), loginAuthDto.getLoginName());

        ExceptionLogDto exceptionLogDto = ExceptionLogDto.exceptionLogDtoInstance(e, profile, applicationName, user);
        //异步调用stream中接口记录日志
        CompletableFuture.supplyAsync(() -> exceptionLog.loadExceptionLog(exceptionLogDto), taskExecutor);
        return WrapMapper.error(e.getMessage());
    }


}
