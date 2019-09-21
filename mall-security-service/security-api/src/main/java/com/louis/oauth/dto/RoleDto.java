package com.louis.oauth.dto;

import com.louis.common.api.dto.BaseDto;
import lombok.*;

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
