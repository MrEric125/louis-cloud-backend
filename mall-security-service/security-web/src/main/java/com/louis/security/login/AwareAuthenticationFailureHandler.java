package com.louis.security.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.louis.common.api.wrapper.WrapMapper;
import com.louis.exception.ErrorCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author John·Louis
 * @date create in 2019/4/14
 * 自定义认证失败 handler
 */
@Component
public class AwareAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private final ObjectMapper mapper;

    @Autowired
    public AwareAuthenticationFailureHandler(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException e) throws IOException, ServletException {

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        mapper.writeValue(response.getWriter(), WrapMapper.error(ErrorCodeEnum.GL99990401.code(), ErrorCodeEnum.GL99990401.msg()));
    }

}
