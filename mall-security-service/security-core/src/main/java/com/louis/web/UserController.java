package com.louis.web;

import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.web.web.WebCRUDController;
import com.louis.oauth.dto.UserDto;
import com.louis.oauth.dto.UserRoleDto;
import com.louis.server.entity.SysUser;
import com.louis.server.service.UserRoleService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author louis
 * <p>
 * Date: 2019/6/21
 * Description:
 */
@Slf4j
@Api("用户相关操作")
@RequestMapping(value = "/user",produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class UserController extends WebCRUDController<SysUser, UserDto,Long> {

    @Autowired
    private UserRoleService userRoleService;

    @PostMapping("/blindRole")
    public Wrapper blindRole(@RequestBody UserRoleDto dto) {
        log.info("绑定用户到角色");
        userRoleService.blindRole(dto);
        return WrapMapper.ok();
    }

}
