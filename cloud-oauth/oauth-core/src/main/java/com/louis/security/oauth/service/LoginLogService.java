package com.louis.security.oauth.service;

import com.louis.core.service.CRUDService;
import com.louis.common.api.dto.IdName;
import com.louis.security.oauth.entity.UserLoginLog;
import com.louis.security.oauth.repository.LoginRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Eric
 * @date create in 2019/5/19
 */
@Service
@Slf4j
public class LoginLogService extends CRUDService<UserLoginLog, Long> {

    @Autowired
    private  LoginRepository loginRepository;

    /**
     * 当登录的时候记录，如果最近一次的登录时间是此次登录时间1小时之内就不记录登录信息
     * @param user
     */
    public void saveLoginMessage(IdName<Long> user,String ipAddr) {

        long gap = 60 * 60 * 1000L;
        UserLoginLog userLogin = findByUserId(user.getId());

        if (userLogin == null || new Date().getTime() - userLogin.getLastLoginTime().getTime() > gap) {
            UserLoginLog login = new UserLoginLog();
            login.setLastLoginTime(new Date());
            login.setUserId(user.getId());
            login.setUsername(user.getName());
            login.setIp(ipAddr);
            log.info("记录登录信息成功，username:{}", user.getName());
            save(login);
        }

    }

    public void saveLoginLog(UserLoginLog loginLog) {
        loginRepository.save(loginLog);
    }

    private UserLoginLog findByUserId(Long userId) {
        return loginRepository.findByUserId(userId, new Date());
    }
    
}
