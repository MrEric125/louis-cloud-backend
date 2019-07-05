package com.louis.server.service;

import com.louis.core.service.IWebService;
import com.louis.oauth.dto.SysMenuDto;
import com.louis.server.entity.SysMenu;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/7/5
 * Description:
 */
public interface MenuService extends IWebService<SysMenu, SysMenuDto,Long> {

    void changeItemStatus(long menuId);
}
