package com.louis.oauth.dto;

import com.louis.common.api.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

/**
 * @author John·Louis
 * @date create in 2019/6/16
 */
@Setter
@Getter
public class PermissionDto extends BaseDto<Long> {

    private long roleId;

    private long permissionId;


}
