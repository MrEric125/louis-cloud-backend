package com.louis.oauth.dto;

import com.louis.common.api.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Set;

/**
 * @author John·Louis
 * @date create in 2019/6/16
 */
@Setter
@Getter
public class ClientDetailsDto extends BaseDto<Long> {
    private String clientId;

    private Set<String> resourceId;

    private boolean secretRequired = Boolean.TRUE;

    private String clientSecret;

    private boolean scoped = Boolean.TRUE;

    private Set<String> scope;

    private Set<String> authorizedGrantType;

    private Set<String> registeredRedirectUri;


    private Integer accessTokenValiditySeconds;

    private Integer refreshTokenValiditySeconds;

    private boolean autoApprove;

    private Map<String, Object> additionalInformation;


}
