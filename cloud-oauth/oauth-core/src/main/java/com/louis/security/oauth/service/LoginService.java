package com.louis.security.oauth.service;

import com.louis.common.api.service.CRUDService;
import com.louis.security.oauth.dto.IdName;
import com.louis.security.oauth.entity.UserLogin;
import com.louis.security.oauth.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Eric
 * @date create in 2019/5/19
 */
@Service
public class LoginService extends CRUDService<UserLogin, Long> {

    @Autowired
    private  LoginRepository loginRepository;

    /**
     * 当登录的时候记录，如果最近一次的登录时间是此次登录时间1小时之内就不记录登录信息
     * @param user
     */
    public void SaveloginMessage(IdName<Long> user,String ipAddr) {

        if (findByUserId(user.getId())==null) {
            UserLogin login = new UserLogin();
            login.setLastLoginTime(new Date());
            login.setUserId(user.getId());
            login.setUsername(user.getName());
            login.setIp(ipAddr);
            save(login);
        }

    }

    private UserLogin findByUserId(Long userId) {
        return loginRepository.findByUserId(userId, new Date());
    }
    
}
