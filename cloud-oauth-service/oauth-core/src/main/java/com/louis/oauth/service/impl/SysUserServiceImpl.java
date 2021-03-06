package com.louis.oauth.service.impl;

import com.louis.common.api.dto.ClientMessageDto;
import com.louis.common.api.dto.LoginAuthDto;
import com.louis.core.service.AbstractWebCRUDService;
import com.louis.core.utils.ClientMessageUtil;
import com.louis.oauth.SecurityUser;
import com.louis.oauth.dto.UserDto;
import com.louis.oauth.entity.SysUser;
import com.louis.oauth.entity.UserRole;
import com.louis.oauth.repository.SysUserRepository;
import com.louis.oauth.service.SysUserService;
import com.louis.oauth.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author John·Louis
 * @date create in 2019/4/15
 */
@Service
@Slf4j
public class SysUserServiceImpl extends AbstractWebCRUDService<SysUser, UserDto, Long> implements SysUserService {

//    @Autowired
//    private PasswordService passwordService;

    @Autowired
    private SysUserRepository sysUserRepository;

//    @Autowired
//    private  RedisOperate<SysUser> redisOperate;

    @Autowired
    private UserRoleService userRoleService;

//    @Autowired
//    private SysRoleServiceImpl sysRoleService;

//    @Autowired
//    private UserTokenService userTokenService;

//    @Autowired
//    private TaskExecutor taskExecutor;

//    @Autowired
//    private LoginLogService loginLogService;

    @Autowired
    RedisTemplate<Object ,Object> redisTemplate;



    public SysUser findByUserName(String userName) {

        log.info(" find user by user name ; username:{}", userName);
//        SysUser user =  getUserFromRedisCache(RedisConstant.SYS_USER + userName);
        SysUser user = null;
        if (user == null) {
            user = sysUserRepository.findByUsername(userName);
            if (user!=null) {
//                putUserToRedisCache(user);
            }
        }
        return user;
    }

//    @Override
//    public void modifyPsw(ModifyPswDto modifyPswDto) {
//        String loginName = modifyPswDto.getLoginName();
//        SysUser sysUser = findByUserName(loginName);
//        String salt = sysUser.getSalt();
//        String newPassword = passwordService.modifyPsw(modifyPswDto, salt);
//        sysUser.setPassword(newPassword);
//        save(sysUser);
//    }


    @Override
    public SysUser save(SysUser user) {
        if (user.getRegistryDate()==null) {
            user.setRegistryDate(new Date());
        }
        if (user.getIdentityNumber()==null) {
            user.setIdentityNumber(user.getUsername());
        }
//        user.randomSalt();
//        user.setPassword(passwordService.encryptPassword(user.getUsername(), user.getPassword(), user.getSalt()));
        return super.save(user);
    }

//    public void putUserToRedisCache(SysUser user) {
//        try {
//            if( user == null ) return;
//            String key = RedisConstant.SYS_USER+user.getIdToString();
//            redisOperate.set(key, user, 12);
//            redisTemplate.opsForValue().set(RedisConstant.SYS_USER+user.getUsername(), key, 12);
//            redisTemplate.opsForValue().set(RedisConstant.SYS_USER+user.getEmail(), key, 12);
//            redisTemplate.opsForValue().set(RedisConstant.SYS_USER+user.getPhone(), key, 12);
//        }catch(Exception e) {
//            log.error("save user to redis error:{}", e.getMessage());
//        }
//    }

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

//
//    @Transactional
//    @Override
//    public SysUser registryUser(RegistryUserDto dto, String defaultEmail, String defaultPassword, String defaultPhone) {
//        Preconditions.checkArgument(!StringUtils.isEmpty(dto.getUserName()), "用户名不能为空");
//        dto.setEmail(dto.getEmail() == null ? dto.getUserName() + defaultEmail : dto.getEmail());
//        dto.setPassword(dto.getPassword() == null ? defaultPassword : dto.getEmail());
//        dto.setPhone(dto.getPhone() == null ? defaultPhone : dto.getEmail());
//        dto.setRealName(dto.getRealName() == null ? dto.getUserName() : dto.getRealName());
//
//        SysUser byUserName = findByUserName(dto.getUserName());
//        if (byUserName != null) {
//            throw new UserException("用户名已存在，请更换名字");
//        }
//
//        SysUser user = new SysUser();
//
//        user.setUsername(dto.getUserName());
//        user.setEmail(dto.getEmail());
//        user.setPhone(dto.getPhone());
//        user.setRealName(dto.getRealName());
//        user.randomSalt();
//        String password = passwordService.encryptPassword(dto.getUserName(), dto.getPassword(), user.getSalt());
//        user.setPassword(password);
//        save(user);
//        //默认的角色
//        SysRole defaultRole = sysRoleService.findByRoleName(SysRole.DEFAULT_ROLE);
//        UserRole userRole = UserRole
//                .builder()
//                .roleId(defaultRole.getId())
//                .roleName(defaultRole.getRoleName())
//                .userId(user.getId())
//                .description("defaultRole")
//                .build();
//        userRoleService.save(userRole);
//        return user;
//    }

    /**
     * 处理登录信息
     * @param token
     * @param principal
     * @param request
     */
    public void handlerLoginData(OAuth2AccessToken token, SecurityUser principal, HttpServletRequest request) {
        log.info("handle login data ;  token:{}", token);
        ClientMessageDto messageDto = ClientMessageUtil.findClientMessage(request);

        Long userId = principal.getUserId();
        LoginAuthDto loginAuthDto = new LoginAuthDto(userId, principal.getLoginName(), principal.getNickName(), principal.getGroupId(), principal.getGroupName());
        // 记录token日志

//        userTokenService.saveUserToken(token,loginAuthDto);
        // 记录操作日志
//        taskExecutor.execute(() -> loginLogService.saveLoginLog(messageDto,loginAuthDto));
    }

    public Collection<GrantedAuthority> loadUserAuthorities(long userId) {

        List<UserRole> roles= userRoleService.findByUserId(userId);


        return roles.stream()
                .map(authority -> new SimpleGrantedAuthority(
                        authority.authority()
                )).collect(Collectors.toList());
    }


    @Override
    public UserDto entityToDto(SysUser sysUser) {
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(sysUser, dto);
        return dto;
    }

    @Override
    public SysUser dtoToEntity(UserDto dto) {
        SysUser user = new SysUser();
        BeanUtils.copyProperties(dto, user);
        return user;
    }
}
