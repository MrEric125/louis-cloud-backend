package com.louis.server.service;

import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.louis.common.api.dto.LoginAuthDto;
import com.louis.core.service.ICRUDService;
import com.louis.oauth.dto.TokenDto;
import com.louis.server.entity.UserToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import javax.servlet.http.HttpServletRequest;

/**
 * @author John·Louis
 * @date create in 2019/6/29
 * description:
 */
public interface UserTokenService extends ICRUDService<UserToken, Long> {


    void saveUserToken(OAuth2AccessToken token, LoginAuthDto loginAuthDto);

    String refreshToken(String accessToken, String refreshToken, HttpServletRequest request) throws HttpProcessException;

    void updateUserToken(TokenDto tokenDto, LoginAuthDto loginAuthDto);

    TokenDto getByAccessToken(String accessToken);

    int batchUpdateTokenOffLine();

}
