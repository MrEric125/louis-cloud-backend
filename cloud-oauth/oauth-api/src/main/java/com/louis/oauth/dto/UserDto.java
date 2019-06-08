package com.louis.oauth.dto;

import com.louis.common.api.dto.BaseDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Eric
 * @date create in 2019/5/19
 */
@Data
@NoArgsConstructor
public class UserDto extends BaseDto<Long> {

    private String username;

    private String realName;

    private Date registryTime;


    private String email;

    private String phone;

    private String idDeleted;






}
