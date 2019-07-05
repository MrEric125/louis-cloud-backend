package com.louis.server.service.impl;

import com.google.common.base.Preconditions;
import com.louis.common.api.dto.LoginAuthDto;
import com.louis.exception.ErrorCodeEnum;
import com.louis.oauth.dto.ModifyPswDto;
import com.louis.server.entity.SysUser;
import com.louis.exception.UserException;
import com.louis.server.service.PasswordService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author John·Louis
 * @date create in 2019/5/19
 */
@Service
@Slf4j
public class PasswordServiceImpl implements PasswordService {


    public void validate(SysUser user, String password) {
        String username = user.getUsername();
        if (!matches(user, password)) {
            log.error(username,"passwordError","password error! password: {}", password);
            throw new UserException("user.password.not.match", null);
        }
    }

    @Override
    public String modifyPsw(ModifyPswDto modifyPswDto,String salt) {
        String loginName = modifyPswDto.getLoginName();
        String oldPassword = modifyPswDto.getOldPassword();
        String newPassword = modifyPswDto.getNewPassword();
        String confirmPwd = modifyPswDto.getConfirmPwd();
        Preconditions.checkArgument(!StringUtils.isEmpty(loginName), ErrorCodeEnum.UAC10011007.msg());
        Preconditions.checkArgument(!StringUtils.isEmpty(oldPassword), "原始密码不能为空");
        Preconditions.checkArgument(!StringUtils.isEmpty(newPassword), "新密码不能为空");
        Preconditions.checkArgument(!StringUtils.isEmpty(confirmPwd), ErrorCodeEnum.UAC10011009.msg());
        Preconditions.checkArgument(newPassword.equals(confirmPwd), "两次密码不一致, 请重新输入！");
        return encryptPassword(loginName, newPassword, salt);


    }

    /**
     * 验证输入密码和用户密码是否一致
     * @param user
     * @param newPassword
     * @return
     */
    public boolean matches(SysUser user, String newPassword) {
        return user.getPassword().equals(encryptPassword(user.getUsername(), newPassword, user.getSalt()));
    }


    /**
     * 加密密码
     * @param username
     * @param password
     * @param salt
     * @return
     */
    public String  encryptPassword(String username, String password, String salt) {
        String encode = new BCryptPasswordEncoder().encode(password);
//        String hash = Md5Utils.hash(username + password + salt);
        return encode;
    }


}
