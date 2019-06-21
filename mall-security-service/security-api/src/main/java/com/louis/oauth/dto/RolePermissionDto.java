package com.louis.oauth.dto;

import com.louis.common.api.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

/**
 * @author louis
 * <p>
 * Date: 2019/6/21
 * Description:
 */
@Setter
@Getter
public class RolePermissionDto extends BaseDto<Long> {

    private long roleId;

    private long permissionId;
}
