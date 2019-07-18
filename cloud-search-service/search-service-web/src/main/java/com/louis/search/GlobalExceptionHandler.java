package com.louis.search;

import com.louis.common.api.EntityNotFoundException;
import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author louis
 * <p>
 * Date: 2019/7/18
 * Description:
 *    es中统一的异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Wrapper entityNotFoundException(EntityNotFoundException e) {
        log.error("异常message:{},异常code:{}", e.getMessage(), e.getErrorCode());
        return WrapMapper.error(e.getMessage());

    }
}
