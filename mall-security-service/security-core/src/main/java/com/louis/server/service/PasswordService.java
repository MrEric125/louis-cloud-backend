package com.louis.server.service;

import com.louis.core.utils.Md5Utils;
import com.louis.server.entity.SysUser;
import com.louis.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Eric
 * @date create in 2019/5/19
 */
@Service
@Slf4j
public class PasswordService {






    public void validate(SysUser user, String password) {

        String username = user.getUsername();
        if (!matches(user, password)) {
            log.error(username,"passwordError","password error! password: {}", password);
            throw new UserException("user.password.not.match", null);
        }
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
    String  encryptPassword(String username, String password, String salt) {
        String encode = new BCryptPasswordEncoder().encode(password);
//        String hash = Md5Utils.hash(username + password + salt);
        return encode;
    }

}
