package com.louis.server.service.impl;

import com.louis.core.service.AbstractWebCRUDService;
import com.louis.oauth.dto.SysMenuDto;
import com.louis.oauth.dto.RoleMenuDto;
import com.louis.server.entity.RoleMenu;
import com.louis.server.entity.SysMenu;
import com.louis.server.entity.SysRole;
import com.louis.server.repository.RoleMenuRepository;
import com.louis.server.service.MenuService;
import com.louis.server.service.RoleMenuService;
import com.louis.server.service.SysRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/21
 * Description:
 */
@Service
public class RoleMenuServiceImpl extends AbstractWebCRUDService<RoleMenu, RoleMenuDto,Long> implements RoleMenuService {

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

    public List<SysMenuDto> queryMenuTree(long roleId) {
        List<RoleMenu> roleMenus = roleMenuRepository.findByRoleId(roleId);
        return null;
    }

    /**
     * 通过menuId 找到相关的role
     * @param menuId
     * @return
     */
    public List<SysRole> relativeRole(long menuId) {
        List<RoleMenu> roleMenuList = roleMenuRepository.findByMenuId(menuId);
        return roleMenuList.stream().map(x -> sysRoleService.findById(x.getRoleId())).collect(Collectors.toList());
    }

    /**
     * 通过role 找到相关的menu
     * @param roleId
     * @return
     */
    public List<SysMenu> relativeMenu(long roleId) {
       return roleMenuRepository.findByRoleId(roleId)
                .stream()
                .map(x -> menuService.findById(x.getMenuId()))
                .collect(Collectors.toList());


    }
}
