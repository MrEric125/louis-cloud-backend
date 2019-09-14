package com.louis.server.service.impl;

import com.louis.common.api.dto.LoginAuthDto;
import com.louis.core.service.AbstractCRUDService;
import com.louis.common.api.dto.IdName;
import com.louis.common.api.dto.ClientMessageDto;
import com.louis.server.entity.UserLoginLog;
import com.louis.server.repository.LoginRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author John·Louis
 * @date create in 2019/5/19
 */
@Service
@Slf4j
public class LoginLogService extends AbstractCRUDService<UserLoginLog, Long>  {

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

    /**
     * 记录登录日志的
     * @param messageDto
     * @param authDto
     */
    public void saveLoginLog(ClientMessageDto messageDto, LoginAuthDto authDto) {

        UserLoginLog loginLog = new UserLoginLog();
        BeanUtils.copyProperties(messageDto, loginLog);
        loginLog.setLastLoginTime(new Date());
        loginLog.setUsername(authDto.getUserName());
        loginLog.setUserId(authDto.getUserId());
        loginRepository.save(loginLog);
    }

    private UserLoginLog findByUserId(Long userId) {
        return loginRepository.findByUserId(userId, new Date());
    }
    
}
