package com.louis.oauth.dto;

import com.louis.common.api.dto.BaseDto;
import lombok.*;

import java.util.Date;

/**
 * @author John·Louis
 * @date create in 2019/5/19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends BaseDto<Long> {

    private String username;

    private String realName;

    private Date registryTime;


    private String email;

    private String phone;

    private String idDeleted;






}
