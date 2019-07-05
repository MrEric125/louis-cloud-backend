package com.louis.server.service;

import com.louis.core.service.IWebService;
import com.louis.oauth.dto.SysMenuDto;
import com.louis.oauth.dto.RoleMenuDto;
import com.louis.server.entity.RoleMenu;

import java.util.List;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/7/5
 * Description:
 */
public interface RoleMenuService extends IWebService<RoleMenu, RoleMenuDto, Long> {

    List<SysMenuDto> queryMenuTree(long roleId);

}
