package com.louis.security.oauth.dto;

import com.louis.core.dto.BaseDto;
import lombok.Builder;
import lombok.Data;

/**
 * @author Eric
 * @date create in 2019/5/19
 */
@Data
@Builder
public class RoleDto extends BaseDto<Long> {

    private String roleName;

    private String roleDescription;




}
