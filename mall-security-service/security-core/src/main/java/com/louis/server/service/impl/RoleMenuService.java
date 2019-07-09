package com.louis.server.service.impl;

import com.louis.core.service.WebCRUDService;
import com.louis.oauth.dto.MenuItemDto;
import com.louis.oauth.dto.RoleMenuDto;
import com.louis.server.entity.RoleMenu;
import com.louis.server.repository.RoleMenuRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author louis
 * <p>
 * Date: 2019/6/21
 * Description:
 */
@Service
public class RoleMenuService extends WebCRUDService<RoleMenu, RoleMenuDto,Long> {

    @Autowired
    RoleMenuRepository roleMenuRepository;

    @Autowired
    SysRoleService sysRoleService;

    @Autowired
    MenuService menuService;


    @Override
    public RoleMenu dtoToEntity(RoleMenuDto dto) {
        RoleMenu roleMenu = new RoleMenu();
        BeanUtils.copyProperties(dto, roleMenu);
        return roleMenu;

    }

    @Override
    public RoleMenuDto entityToDto(RoleMenu roleMenu) {
        RoleMenuDto dto = new RoleMenuDto();
        BeanUtils.copyProperties(roleMenu, dto);
        return dto;
    }

    public List<MenuItemDto> queryMenuTree(long roleId) {
        List<RoleMenu> roleMenus = roleMenuRepository.findByRoleId(roleId);
        return null;
    }
}
