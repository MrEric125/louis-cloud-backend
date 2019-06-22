package com.louis.oauth.dto;

import com.louis.common.api.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Eric
 * @date create in 2019/5/19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto extends BaseDto<Long> {

    private String roleName;

    private String roleDescription;




}
