package com.louis.oauth.dto;

import com.louis.common.api.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/21
 * Description:
 */
@Setter
@Getter
public class UserRoleDto extends BaseDto {
    private long userId;

    private long roleId;

}
