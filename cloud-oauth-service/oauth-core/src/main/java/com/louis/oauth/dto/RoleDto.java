package com.louis.oauth.dto;

import com.louis.common.api.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author John·Louis
 * @date create in 2019/5/19
 */
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto extends BaseDto<Long> {

    private String roleName;

    private String roleDescription;




}
