package com.louis.web;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.web.web.WebCRUDController;
import com.louis.oauth.dto.UserDto;
import com.louis.oauth.dto.UserRoleDto;
import com.louis.server.entity.SysUser;
import com.louis.server.entity.UserRole;
import com.louis.server.service.SysUserService;
import com.louis.server.service.UserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @author John·Louis
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

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation("用户绑定角色")
    @PostMapping("/blindRole")
    public Wrapper blindRole(@RequestBody UserRoleDto dto) {
        log.info("绑定用户到角色");
        userRoleService.blindRole(dto);
        return WrapMapper.success();
    }

    @ApiOperation("获取用户信息")
    @RequestMapping("/info")
    public Wrapper info(Authentication user) {
        log.info("获取用户信息");
//        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        Map<String, Object> returnMap = Maps.newHashMap();
        returnMap.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        returnMap.put("introduction","i am user");
        returnMap.put("name", "admin");
        returnMap.put("roles", Lists.newArrayList("ADMIN"));
        Map<String, Map<String, Object>> infoMap = ImmutableMap.of("info", returnMap);
        return WrapMapper.wrap(infoMap);
    }

    /**
     * 查询绑定到当前角色的用户人
     * @param roleId
     * @return
     */
    @GetMapping("/getByRoleId/{roleId}")
    public Wrapper getRelativeUserByRole(@PathVariable("roleId") long roleId) {
        List<UserRole> userRoleList = userRoleService.findByRoleId(roleId);
        List<UserDto> userDtoList =userRoleList
                .stream()
                .map(x -> {
            SysUser sysUser = sysUserService.findById(x.getUserId());
            return sysUserService.entityToDto(sysUser);
        }).collect(Collectors.toList());
        return WrapMapper.success(userDtoList);
    }

}
