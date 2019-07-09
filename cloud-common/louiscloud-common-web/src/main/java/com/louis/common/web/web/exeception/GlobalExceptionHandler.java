package com.louis.common.web.web.exeception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.api.wrapper.WrapperMassage;
import com.louis.exception.BusinessException;
import com.louis.exception.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author John·Louis
 * @date create in 2019/7/4
 * description:
 * 框架中，用了某些限制，如果我们访问的时候是*.json 形式那么就会返回json格式，不过不是那么全局异常就会以xml形式返回
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    HttpServletRequest request;

    HttpServletResponse response;



    @ModelAttribute
    public void init(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Autowired
    ObjectMapper objectMapper;

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

    /**
     * 无权限访问.
     *
     * @param e the e
     *
     * @return the wrapper
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public Wrapper unAuthorizedException(AccessDeniedException e) {
        log.error("业务异常={}", e.getMessage(), e);
        return WrapMapper.wrap(ErrorCodeEnum.GL99990401.code(), ErrorCodeEnum.GL99990401.msg());
    }


    /**
     * 全局异常.
     *
     * @param e the e
     * @return the wrapper
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Wrapper exception(Exception e) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        log.info("保存全局异常信息 ex={}", e.getMessage(), e);
//        taskExecutor.execute(() -> {
//            GlobalExceptionLogDto globalExceptionLogDto = new GlobalExceptionLogDto().getGlobalExceptionLogDto(e, profile, applicationName);
//            mdcExceptionLogFeignApi.saveAndSendExceptionLog(globalExceptionLogDto);
//        });
//        return WrapMapper.error();

//        response.getWriter().write(objectMapper.writeValueAsString(WrapMapper.error(e.getMessage())));

        return WrapMapper.error(e.getMessage());
    }


}
