package com.louis.server.service.impl;

import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.core.service.WebCRUDService;
import com.louis.exception.BaseException;
import com.louis.oauth.dto.MenuItemDto;
import com.louis.server.entity.MenuItem;
import com.louis.server.repository.MenuRepository;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


/**
 * @author louis
 * <p>
 * Date: 2019/6/21
 * Description:
 */
@Service
public class MenuService extends WebCRUDService<MenuItem, MenuItemDto,Long> {

    @Autowired
    MenuRepository menuRepository;



    @Override
    public MenuItem dtoToEntity(MenuItemDto dto) {
        MenuItem menuItem = new MenuItem();
        BeanUtils.copyProperties(dto, menuItem);
        return menuItem;
    }

    @Override
    public MenuItemDto entityToDto(MenuItem menuItem) {
        MenuItemDto dto = new MenuItemDto();
        BeanUtils.copyProperties(menuItem, dto);
        return dto;
    }


    public void changeItemStatus(long menuId) {
        MenuItem menuItem = findById(menuId);
        List<MenuItem> menuItemList = menuRepository.findByParentId(menuItem.getId());
        int status = menuItem.getStatus();
        if (status == MenuItem.DISABLE) {
            menuItem.setStatus(0);
            //todo 可以优化成批量修改
            menuItemList.forEach(x -> {
                x.setStatus(0);
                save(x);
            });
        } else {
            menuItem.setStatus(1);
            //todo 可以优化成批量修改
            menuItemList.forEach(x -> {
                x.setStatus(1);
                save(x);
            });
        }
    }

    @Override
    public void deleteById(Long aLong) {
        MenuItem parentId = findById(aLong);
        List<MenuItem> childMenus = menuRepository.findByParentId(parentId.getId());
        if (CollectionUtils.isNotEmpty(childMenus)) {
            throw new BaseException("当前目录还有子目录，请检查再删除");
        }
        this.delete(parentId);

    }
}
