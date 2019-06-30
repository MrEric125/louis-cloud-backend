package com.louis.oauth.dto;

import com.louis.common.api.dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author John·Louis
 * @date create in 2019/6/29
 * description:
 */
@Data
@ApiModel("修改密码Dto")
public class ModifyPswDto extends BaseDto {
    /**
     * 登录名
     */
    @ApiModelProperty(value = "登录名")
    private String loginName;

    /**
     * 原始密码
     */
    @ApiModelProperty(value = "原始密码")
    private String oldPassword;

    /**
     * 新密码
     */
    @ApiModelProperty(value = "新密码")
    private String newPassword;

    /**
     * 确认密码
     */
    @ApiModelProperty(value = "确认密码")
    private String confirmPwd;

}
