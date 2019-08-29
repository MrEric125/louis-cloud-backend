package com.louis.server.service.impl;

import com.louis.core.service.AbstractWebCRUDService;
import com.louis.exception.BaseException;
import com.louis.oauth.dto.SysMenuDto;
import com.louis.server.entity.SysMenu;
import com.louis.server.repository.MenuRepository;
import org.apache.commons.collections.CollectionUtils;
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
public class MenuService extends AbstractWebCRUDService<SysMenu, SysMenuDto,Long> {

    @Autowired
    MenuRepository menuRepository;



    @Override
    public SysMenu dtoToEntity(SysMenuDto dto) {
        SysMenu SysMenu = new SysMenu();
        BeanUtils.copyProperties(dto, SysMenu);
        return SysMenu;
    }

    @Override
    public SysMenuDto entityToDto(SysMenu SysMenu) {
        SysMenuDto dto = new SysMenuDto();
        BeanUtils.copyProperties(SysMenu, dto);
        return dto;
    }


    /**
     * 如果当前的status 变了，那么所有的children status 也会相应的变了
     *
     * @param menuId
     */
    public void changeItemStatus(long menuId) {
        SysMenu SysMenu = findById(menuId);
        List<SysMenu> SysMenuList = menuRepository.findByParentId(SysMenu.getId());
        int status = SysMenu.getStatus();
        if (status == SysMenu.DISABLE) {
            SysMenu.setStatus(1);
            //todo 可以优化成批量修改
            SysMenuList.forEach(x -> {
                x.setStatus(1);
                save(x);
            });
        } else {
            SysMenu.setStatus(0);
            //todo 可以优化成批量修改
            SysMenuList.forEach(x -> {
                x.setStatus(0);
                save(x);
            });
        }
    }

    @Override
    public void deleteById(Long aLong) {
        SysMenu parentId = findById(aLong);
        List<SysMenu> childMenus = menuRepository.findByParentId(parentId.getId());
        if (CollectionUtils.isNotEmpty(childMenus)) {
            throw new BaseException("当前目录还有子目录，请检查再删除");
        }
        this.delete(parentId);

    }
}
