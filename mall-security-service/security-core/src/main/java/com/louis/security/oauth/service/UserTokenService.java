package com.louis.security.oauth.service;

import com.louis.common.api.dto.LoginAuthDto;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author louis
 * <p>
 * Date: 2019/6/13
 * Description:
 */
@Service
public class UserTokenService {

    public void saveUserToken(String token, String refreshToken, LoginAuthDto loginAuthDto, HttpServletRequest request) {

    }

    public String refreshToken(String accessToken, String refreshToken, HttpServletRequest request) {
        return null;
    }

    public Map<Object, Object> createToken(String userName, String password) {
        return null;
    }
}
