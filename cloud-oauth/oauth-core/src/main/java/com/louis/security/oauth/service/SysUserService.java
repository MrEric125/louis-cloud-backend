package com.louis.security.oauth.service;

import com.louis.core.redis.RedisOperate;
import com.louis.core.service.CRUDService;
import com.louis.security.oauth.RedisConstant;
import com.louis.security.oauth.entity.SysUser;
import com.louis.security.oauth.repository.SysUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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

    private final RedisOperate<SysUser> redisOperate;

    @Autowired
    RedisTemplate<Object ,Object> redisTemplate;




    @Autowired
    public SysUserService(PasswordService passwordService,
                          SysUserRepository sysUserRepository,
                          RedisOperate<SysUser> redisOperate) {
        this.passwordService = passwordService;
        this.sysUserRepository = sysUserRepository;
        this.redisOperate = redisOperate;
    }

    public SysUser findByUserName(String userName) {
        SysUser user =  getUserFromRedisCache(RedisConstant.SYS_USER + userName);
        if (user == null) {
            user = sysUserRepository.findByUsername(userName);
            if (user!=null) {
                putUserToRedisCache(user);
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

    public void putUserToRedisCache(SysUser user) {
        try {
            if( user == null ) return;
            String key = RedisConstant.SYS_USER+user.getIdToString();
            redisOperate.set(key, user, 12);
            redisTemplate.opsForValue().set(RedisConstant.SYS_USER+user.getUsername(), key, 12);
            redisTemplate.opsForValue().set(RedisConstant.SYS_USER+user.getEmail(), key, 12);
            redisTemplate.opsForValue().set(RedisConstant.SYS_USER+user.getPhone(), key, 12);
        }catch(Exception e) {
            log.error("save user to redis error:{}", e.getMessage());
        }
    }

    public SysUser getUserFromRedisCache(String key) {
        try {
            Object obj = redisTemplate.opsForValue().get(key);
            if( obj instanceof SysUser)
                return (SysUser)obj;

            //username,phone,email,empid
            if( obj instanceof String) {
                Object obj2 = redisTemplate.opsForValue().get(String.valueOf(obj));
                if( obj2 instanceof SysUser)
                    return (SysUser)obj2;
                if( obj2 == null ) {
                    redisTemplate.delete(String.valueOf(obj));
                }
            }
        }catch(Exception e) {

            log.error("get user from redis error: key :{},{}", key, e.getMessage());
        }
        return null;
    }







}
