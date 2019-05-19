package com.louis.security.oauth.service;

import com.louis.common.api.service.CRUDService;
import com.louis.security.oauth.entity.SysUser;
import com.louis.security.oauth.repository.SysUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Eric
 * @date create in 2019/4/15
 */
@Service
@Slf4j
public class SysUserService extends CRUDService<SysUser, Long> {

    private final PasswordService passwordService;

    private final SysUserRepository sysUserRepository;

    @Autowired
    public SysUserService(PasswordService passwordService, SysUserRepository sysUserRepository) {
        this.passwordService = passwordService;
        this.sysUserRepository = sysUserRepository;
    }

    public SysUser findByUserName(String userName) {
        return sysUserRepository.findByUsername(userName);

    }

    @Override
    public SysUser save(SysUser user) {
        if (user.getRegistryDate()==null) {
            user.setRegistryDate(new Date());
        }
        user.randomSalt();
        user.setPassword(passwordService.encryptPassword(user.getUsername(), user.getPassword(), user.getSalt()));

        return super.save(user);

    }
}
