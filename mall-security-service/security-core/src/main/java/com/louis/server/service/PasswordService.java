package com.louis.server.service;

import com.louis.common.api.dto.LoginAuthDto;
import com.louis.oauth.dto.ModifyPswDto;
import com.louis.server.entity.SysUser;

/**
 * @author John·Louis
 * @date create in 2019/6/29
 * description:
 */
public interface PasswordService  {

    /**
     * 生成新的密码
     * @param modifyPswDto
     * @param loginAuthDto
     * @return
     */
     String  modifyPsw(ModifyPswDto modifyPswDto,String salt);

     boolean matches(SysUser user, String newPassword);

     void validate(SysUser user, String password);

    String  encryptPassword(String username, String password, String salt);


}
