package com.louis.security.oauth.user.service;

import com.louis.common.api.service.CRUDService;
import com.louis.security.oauth.user.entity.SysUserInfo;
import com.louis.security.oauth.user.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Eric
 * @date create in 2019/4/15
 */
@Service
public class SysUserService extends CRUDService<SysUserInfo, Long> {


    @Autowired
    private SysUserRepository sysUserRepository;

    public SysUserInfo findByUserName(String userName) {
        return sysUserRepository.findByUserName(userName);
    }




}
