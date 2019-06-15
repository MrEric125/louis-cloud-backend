package com.louis.oauth.dto;

import com.louis.common.api.dto.BaseDto;
import com.louis.common.api.dto.LoginAuthDto;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Eric
 * @date create in 2019/6/15
 */
@Setter
@Getter
public class TokenDto extends BaseDto<Long> {


    private String accessToken;

    private String refreshToken;

    private LoginAuthDto loginAuthDto;

    private int status;





}
