package com.louis.web;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.web.web.WebCRUDController;
import com.louis.core.search.SearchOperator;
import com.louis.core.search.Searchable;
import com.louis.oauth.dto.RoleDto;
import com.louis.oauth.dto.RolePermissionDto;
import com.louis.server.entity.*;
import com.louis.server.service.SysRoleService;
import com.louis.server.service.UserRoleService;
import com.louis.server.service.impl.RolePermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author louis
 * <p>
 * Date: 2019/6/21
 * Description:
 */
@Slf4j
@Api("角色相关操作")
@RestController
@RequestMapping(value = "/role",produces = MediaType.APPLICATION_JSON_VALUE)
public class RoleController extends WebCRUDController<SysRole, RoleDto,Long> {


    @Autowired
    UserRoleService userRoleService;

    @Autowired
    RolePermissionService rolePermissionService;

    @Autowired
    SysRoleService sysRoleService;

    @ApiOperation("查找和角色相关的权限和用户")
    @GetMapping("/relationRole")
    public Wrapper findRelationRole(long roleId) {
        List<UserRole> userRoles = userRoleService.findByRoleId(roleId);
        List<RolePermission> rolePermissions = rolePermissionService.findByRoleId(roleId);
        Map map = ImmutableMap.of("userRoles", userRoles, "rolePermission", rolePermissions);
        return handleResult(map);
    }




    @ApiOperation("角色绑定权限")
    @PostMapping("/blindPermission")
    public Wrapper blindPermission(@RequestBody RolePermissionDto permissionDto) {
        log.info("blind role with permission :{}",permissionDto);
        rolePermissionService.blindPermission(permissionDto);
        return WrapMapper.ok();
    }

    /**
     * 通过用户id找到所有相关角色
     * @param userId
     * @return
     */
    @GetMapping("/getByUserId/{userId}")
    public Wrapper getByUserId(@PathVariable("userId") long userId) {
        List<UserRole> userRoleList = userRoleService.findByRoleId(userId);
        List<RoleDto> roleDtoList = userRoleList.stream()
                .map(x -> sysRoleService.findById(x.getRoleId()))
                .map(x -> sysRoleService.entityToDto(x)).collect(Collectors.toList());
        return WrapMapper.ok(roleDtoList);

    }


    @DeleteMapping(value = "/delete")
    @Override
    public Wrapper delete(Long aLong) {
        List<UserRole> userRoles = userRoleService.findByRoleId(aLong);
        Searchable searchable = Searchable.newSearchable();
        searchable.addSearchFilter("roleId", SearchOperator.eq, aLong);
        List<RolePermission> rolePermissions = rolePermissionService.findAllList(searchable);
        userRoleService.delete(userRoles.stream().map(UserRole::getId).collect(Collectors.toList()));
        userRoleService.delete(rolePermissions.stream().map(RolePermission::getId).collect(Collectors.toList()));
        return WrapMapper.ok("删除成功");

    }


}
