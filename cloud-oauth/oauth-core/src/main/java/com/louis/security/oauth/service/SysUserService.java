package com.louis.security.oauth.service;

import com.louis.core.redis.RedisOperate;
import com.louis.core.service.CRUDService;
import com.louis.security.oauth.RedisConstant;
import com.louis.security.oauth.entity.SysUser;
import com.louis.security.oauth.repository.SysUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * @author Eric
 * @date create in 2019/4/15
 */
@Service
@Slf4j
public class SysUserService extends CRUDService<SysUser, Long> {

    private final PasswordService passwordService;

    private final SysUserRepository sysUserRepository;

    private final RedisOperate redisOperate;




    @Autowired
    public SysUserService(PasswordService passwordService,
                          SysUserRepository sysUserRepository,
                          RedisOperate redisOperate) {
        this.passwordService = passwordService;
        this.sysUserRepository = sysUserRepository;
        this.redisOperate = redisOperate;
    }

    public SysUser findByUserName(String userName) {
        SysUser user = (SysUser) redisOperate.get(RedisConstant.SYS_USER + userName);
        if (user == null) {
            user = sysUserRepository.findByUsername(userName);
            if (user!=null) {
                redisOperate.set(RedisConstant.SYS_USER + userName, user, RedisConstant.TOKEN_EXPIRE);
            }
        }

        return user;

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
