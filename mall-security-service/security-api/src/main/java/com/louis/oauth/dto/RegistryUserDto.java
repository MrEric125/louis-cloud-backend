package com.louis.oauth.dto;

import com.louis.common.api.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

/**
 * @author John·Louis
 * @date create in 2019/6/8
 * <p>
 * description:
 */
@Setter
@Getter
public class RegistryUserDto extends BaseDto {

    private String userName;

    private String email;

    private String password;

    private String phone;

    private String realName;




}
