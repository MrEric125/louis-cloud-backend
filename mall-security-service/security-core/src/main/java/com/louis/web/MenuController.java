package com.louis.web;

import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.web.web.WebCRUDController;
import com.louis.oauth.dto.SysMenuDto;
import com.louis.server.entity.SysMenu;
import com.louis.server.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author John·Louis
 *
 * Date: 2019/6/21
 * Description:
 */
@Slf4j
@Api("目录相关操作")
@RestController
@RequestMapping(value = "/menu", produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuController extends WebCRUDController<SysMenu, SysMenuDto, Long> {



    @Autowired
    public MenuService getMenuService() {
        return (MenuService) abstractWebCRUDService;
    }


    @ApiOperation("修改目录的状态")
    @PostMapping("/changeStatus/{menuId}")
    public Wrapper changeStatus(@PathVariable("menuId") long menuId) {
        log.info("change menu item status");
        getMenuService().changeItemStatus(menuId);
        return WrapMapper.success("修改成功");

    }

    @ApiOperation("删除某个目录")
    @DeleteMapping("deleteMenu/{menuId}")
    public Wrapper deleteMenu(@PathVariable("menuId") long menuId) {
        log.info("delete menu item menuId:{}", menuId);
        getMenuService().deleteById(menuId);
        return WrapMapper.success("删除成功");

    }




}
