package com.louis.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.common.HttpHeader;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.louis.common.api.dto.LoginAuthDto;
import com.louis.core.constant.SecurityConstan;
import com.louis.core.service.CRUDService;
import com.louis.core.utils.PublicUtil;
import com.louis.oauth.dto.TokenDto;
import com.louis.security.properties.OAuth2ClientProperties;
import com.louis.security.properties.SecurityProperties;
import com.louis.server.entity.SysUser;
import com.louis.server.entity.enumentity.TokenStatus;
import com.louis.server.entity.UserToken;
import com.louis.server.repository.UserTokenRepository;
import com.louis.server.service.SysUserService;
import com.louis.server.service.UserTokenService;
import org.apache.http.Header;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author louis
 * <p>
 * Date: 2019/6/13
 * Description:
 *
 * token 处理相关
 */


@Service
public class UserTokenServiceImpl extends CRUDService<UserToken,Long> implements UserTokenService {

//    @Value("${louis.auth.refresh-token-url}")
//    private String refreshTokenUrl;

    @Autowired
    UserTokenRepository userTokenRepository;

    @Autowired
    SysUserService sysUserService;

    @Autowired
    private SecurityProperties securityProperties;


    /**
     * 保存用户token
     * @param token
     * @param loginAuthDto
     */
    public void saveUserToken(OAuth2AccessToken token,  LoginAuthDto loginAuthDto) {
        OAuth2ClientProperties[] clients = securityProperties.getOauth2().getClients();
        int accessTokenValidateSeconds = clients[0].getAccessTokenValidateSeconds();
        int refreshTokenValiditySeconds = clients[0].getRefreshTokenValiditySeconds();
        UserToken userToken = UserToken.builder()
                .accessToken(token.getValue())
                .accessTokenValidity(accessTokenValidateSeconds)
                .refreshTokenValidity(refreshTokenValiditySeconds)
                .loginTime(new Date())
                .userName(loginAuthDto.getUserName())
                .status(TokenStatus.ON_LINE.getStatus())
                .build();
        save(userToken);
        //todo 存redis



    }

    /**
     * 刷新token
     * @param accessToken
     * @param refreshToken
     * @param request
     * @return
     * @throws HttpProcessException
     */
    public String refreshToken(String accessToken, String refreshToken, HttpServletRequest request) throws HttpProcessException {
        String token;
        Map<String, Object> map = new HashMap<>(2);
        map.put(SecurityConstan.GRANT_TYPE, SecurityConstan.REFRESH_TOKEN);
        map.put(SecurityConstan.REFRESH_TOKEN, refreshToken);

        //插件式配置请求参数（网址、请求参数、编码、client）
        Header[] headers = HttpHeader.custom().contentType(HttpHeader.Headers.APP_FORM_URLENCODED).authorization(request.getHeader(HttpHeaders.AUTHORIZATION)).build();
        HttpConfig config = HttpConfig.custom().headers(headers).url(null).map(map);
        token = HttpClientUtil.post(config);
        JSONObject jsonObj = JSON.parseObject(token);
        String accessTokenNew = (String) jsonObj.get(SecurityConstan.ACCESS_TOKEN);
        String refreshTokenNew = (String) jsonObj.get(SecurityConstan.REFRESH_TOKEN);
        String username = (String) jsonObj.get("username");
        // 更新本次token数据
        TokenDto tokenDto = this.getByAccessToken(accessToken);
        tokenDto.setStatus(TokenStatus.ON_REFRESH.getStatus());
        SysUser uacUser = sysUserService.findByUserName(username);

        LoginAuthDto loginAuthDto = new LoginAuthDto(uacUser.getId(), uacUser.getUsername(), uacUser.getRealName(), uacUser.getGroupId(), uacUser.getGroupName());
        this.updateUserToken(tokenDto, loginAuthDto);
        // 创建刷新token
        this.saveUserToken(null,  loginAuthDto);
        return token;
    }


    /**
     * 更新token
     * @param tokenDto
     * @param loginAuthDto
     */
    public void updateUserToken(TokenDto tokenDto, LoginAuthDto loginAuthDto) {
        UserToken token = new ModelMapper().map(tokenDto, UserToken.class);
//        token.setUpdateInfo(loginAuthDto);
        userTokenRepository.save(token);
        OAuth2ClientProperties[] clients = securityProperties.getOauth2().getClients();
        int accessTokenValidateSeconds = clients[0].getAccessTokenValidateSeconds();
//        updateRedisUserToken(uacUserToken.getAccessToken(), accessTokenValidateSeconds, tokenDto);
    }

    /**
     * 获取accessToken
     * @param accessToken
     * @return
     */
    public TokenDto getByAccessToken(String accessToken) {

            UserToken userToken = userTokenRepository.findByAccessToken(accessToken);
            TokenDto  userTokenDto = new ModelMapper().map(userToken, TokenDto.class);

        return userTokenDto;
    }

    /**
     * 批量离线token
     * @return
     */
    public int batchUpdateTokenOffLine() {
//        List<Long> idList = userTokenRepository.ListoffLine();
        List<Long> idList = Lists.newArrayList();
        if (PublicUtil.isEmpty(idList)) {
            return 1;
        }
        Map<String, Object> map = Maps.newHashMap();
        map.put("status", 20);
        map.put("tokenIdList", idList);
        return 1;
//        return userTokenRepository.batchUpdateTokenOffLine(map);
    }


}
