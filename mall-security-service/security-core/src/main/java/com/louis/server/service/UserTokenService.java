package com.louis.server.service;

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
import com.louis.oauth.dto.ClientMessageDto;
import com.louis.oauth.dto.TokenDto;
import com.louis.security.properties.OAuth2ClientProperties;
import com.louis.security.properties.SecurityProperties;
import com.louis.server.entity.SysUser;
import com.louis.server.entity.TokenStatus;
import com.louis.server.entity.UserToken;
import com.louis.server.repository.UserTokenRepository;
import org.apache.http.Header;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
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
public class UserTokenService extends CRUDService<UserToken,Long> {

//    @Value("${louis.auth.refresh-token-url}")
//    private String refreshTokenUrl;

    @Autowired
    UserTokenRepository userTokenRepository;

    @Autowired
    SysUserService sysUserService;

    @Autowired
    RedisTemplate<String, TokenDto> redisTemplate;


    @Autowired
    private SecurityProperties securityProperties;

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
        this.updateUacUserToken(tokenDto, loginAuthDto);
        // 创建刷新token
        this.saveUserToken(null,  loginAuthDto);
        return token;
    }



    public void updateUacUserToken(TokenDto tokenDto, LoginAuthDto loginAuthDto) {
        UserToken token = new ModelMapper().map(tokenDto, UserToken.class);
//        token.setUpdateInfo(loginAuthDto);
        userTokenRepository.save(token);
        OAuth2ClientProperties[] clients = securityProperties.getOauth2().getClients();
        int accessTokenValidateSeconds = clients[0].getAccessTokenValidateSeconds();
//        updateRedisUserToken(uacUserToken.getAccessToken(), accessTokenValidateSeconds, tokenDto);
    }
    public TokenDto getByAccessToken(String accessToken) {
        TokenDto userTokenDto = (TokenDto) redisTemplate.opsForValue().get(accessToken);
        if (userTokenDto == null) {
            UserToken userToken = new UserToken();
            userToken.setAccessToken(accessToken);
            userToken = userTokenRepository.findByAccessToken(accessToken);
            userTokenDto = new ModelMapper().map(userToken, TokenDto.class);

        }
        return userTokenDto;
    }

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
