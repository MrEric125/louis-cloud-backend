package com.louis.common.web.web.exeception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author louis
 * <p>
 * Date: 2019/7/4
 * Description:
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ObjectMapper mapper;


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Wrapper exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws IOException {
        log.error("异常全局处理==》：{}", e.getMessage());
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.BAD_REQUEST.value());

        if (e instanceof BindException) {
            BindException exception = (BindException) e;
            List<ObjectError> allErrors = exception.getAllErrors();
            String message = allErrors.get(0).getDefaultMessage();

        }
//        mapper.writeValue(response.getWriter(), WrapMapper.error(e.getMessage()));
        return WrapMapper.error(e.getMessage());
    }




}
