package com.louis.web;

import com.louis.common.api.dto.IdName;
import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.web.web.BaseController;
import com.louis.oauth.dto.ModifyPswDto;
import com.louis.oauth.dto.RegistryUserDto;
import com.louis.server.entity.SysUser;
import com.louis.server.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author louis
 * <p>
 * Date: 2019/7/5
 * Description:
 */
@RequestMapping(value = "/auth",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AuthRestController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 注册用户，不进行用户名验证，在之前输入的时候，异步验证
     * 管理员可以生成一个初始用户，（只有用户名和初始密码的）
     * @param dto
     * @return
     */
    @RequestMapping(value = "/registryUser",method = RequestMethod.POST)
    public Wrapper registryUser(@RequestBody RegistryUserDto dto) {
        SysUser user = sysUserService.registryUser(dto);
        return WrapMapper.wrap(200, "保存用户成功", new IdName<>(user.getId(), user.getUsername()));
    }

    @PostMapping("/resetPwd")
    public Wrapper resetPassword(@RequestBody ModifyPswDto dto) {
        sysUserService.modifyPsw(dto);
        return WrapMapper.ok("修改密码成功");
    }







}
