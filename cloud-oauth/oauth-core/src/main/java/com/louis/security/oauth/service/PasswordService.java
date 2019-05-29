package com.louis.security.oauth.service;

import com.louis.core.utils.Md5Utils;
import com.louis.security.oauth.entity.SysUser;
import org.springframework.stereotype.Service;

/**
 * @author Eric
 * @date create in 2019/5/19
 */
@Service
public class PasswordService {

    /*public void validate(SysUser user, String password) {

        String username = user.getUsername();

        if (!matches(user, password)) {
            UserLogUtils.log(username,"passwordError","password error! password: {}", password);
            throw new UserPasswordNotMatchException();
        }
    }*/

    public boolean matches(SysUser user, String newPassword) {
        return user.getPassword().equals(encryptPassword(user.getUsername(), newPassword, user.getSalt()));
    }



    String encryptPassword(String username, String password, String salt) {
        return Md5Utils.hash(username + password + salt);
    }
}
