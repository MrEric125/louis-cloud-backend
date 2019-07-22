package com.louis.server.repository;

import com.louis.core.repository.BaseRepository;
import com.louis.server.entity.SysMenu;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/21
 * Description:
 */
@Repository
public interface MenuRepository extends BaseRepository<SysMenu, Long> {

    List<SysMenu> findByParentId(long parentId);




}
