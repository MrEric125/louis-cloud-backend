package com.louis.web;

import com.google.common.collect.Maps;
import com.louis.common.api.dto.IdName;
import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.web.web.BaseController;
import com.louis.oauth.dto.ModifyPswDto;
import com.louis.oauth.dto.RegistryUserDto;
import com.louis.server.entity.SysRole;
import com.louis.server.entity.SysUser;
import com.louis.server.service.SysUserService;
import com.louis.server.service.UserRoleService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/7/5
 * Description:
 */
@RestController
@RequestMapping(value = "/auth",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AuthRestController extends BaseController {

    @Value("${registry.default.email}")
    private String defaultEmail;

    @Value("${registry.default.phone}")
    private String defaultPhone;

    @Value("${registry.default.password}")
    private String defaultPassword;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private UserRoleService userRoleService;

    /**
     * 注册用户，不进行用户名验证，在之前输入的时候，异步验证
     * 管理员可以生成一个初始用户，（只有用户名和初始密码的）
     * @param dto
     * @return
     */
    @RequestMapping(value = "/registryUser",method = RequestMethod.POST)
    public Wrapper registryUser(@NonNull @RequestBody  RegistryUserDto dto) {

        SysUser user = sysUserService.registryUser(dto, defaultEmail, defaultPassword, defaultPhone);
        return WrapMapper.wrap(200, "保存用户成功", new IdName<>(user.getId(), user.getUsername()));
    }

    /**
     * 修改密码
     * @param dto
     * @return
     */
    @PostMapping("/resetPwd")
    public Wrapper resetPassword(@RequestBody ModifyPswDto dto) {
        sysUserService.modifyPsw(dto);
        return WrapMapper.success("修改密码成功");
    }


    @GetMapping("/info")
    public Wrapper loginInfo(Principal principal) {

        String userName = principal.getName();
        SysUser user = sysUserService.findByUserName(userName);
        List<SysRole> roles = userRoleService.getRoleByUser(user.getId());
        Map<String, String> map = Maps.newHashMap();
        map.put("username", user.getUsername());
        map.put("roles", roles.get(0).getRoleName());
        return WrapMapper.success(map);
    }







}
