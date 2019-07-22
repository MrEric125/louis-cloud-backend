package com.louis.security.login;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.louis.common.api.dto.IdName;
import com.louis.common.api.wrapper.WrapMapper;
import com.louis.oauth.model.UserContext;
import com.louis.security.core.SecurityUser;
import com.louis.security.token.AccessToken;
import com.louis.security.token.Token;
import com.louis.security.token.TokenFactory;
import com.louis.common.web.web.utils.IpUtils;
import com.louis.server.service.impl.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author John·Louis
 * @date create in 2019/4/14
 */
@Component
public class AwareAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final ObjectMapper mapper;
    private final TokenFactory tokenFactory;

    @Autowired
    private LoginLogService loginService;

    @Autowired
    public AwareAuthenticationSuccessHandler(final ObjectMapper mapper, final TokenFactory tokenFactory) {
        this.mapper = mapper;
        this.tokenFactory = tokenFactory;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();

        UserContext userContext = UserContext.create(securityUser.getUsername(), (List<GrantedAuthority>) securityUser.getAuthorities());
        AccessToken accessToken = tokenFactory.createAccessToken(userContext);
        Token refreshToken = tokenFactory.createRefreshToken(userContext);
        String ipAddr = IpUtils.getIpAddr(request);
        loginService.saveLoginMessage(new IdName<>(userContext.getUserId(), userContext.getUsername()), ipAddr);


        JSONObject tokenMap = new JSONObject();
        tokenMap.put("claims", accessToken.getClaims());
        tokenMap.put("token", accessToken.getToken());
        tokenMap.put("refreshToken", refreshToken.getToken());

        userContext.setAuthToken(accessToken.getToken());

        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        mapper.writeValue(response.getWriter(), WrapMapper.success(tokenMap));

        clearAuthenticationAttributes(request);
    }

    /**
     * Removes temporary authentication-related data which may have been stored
     * in the session during the authentication process..
     */
    protected final void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session == null) {
            return;
        }

        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

}
