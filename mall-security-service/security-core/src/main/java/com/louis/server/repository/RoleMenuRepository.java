package com.louis.server.repository;

import com.louis.core.repository.BaseRepository;
import com.louis.server.entity.RoleMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/21
 * Description:
 */
@Repository
public interface RoleMenuRepository extends BaseRepository<RoleMenu, Long> {

    List<RoleMenu> findByRoleId(long roleId);

    List<RoleMenu> findByMenuId(long menuId);



}
