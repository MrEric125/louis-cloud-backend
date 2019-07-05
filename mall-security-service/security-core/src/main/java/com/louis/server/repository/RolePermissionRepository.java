package com.louis.server.repository;

import com.louis.core.repository.BaseRepository;
import com.louis.server.entity.RolePermission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/18
 * Description:
 */
@Repository
public interface RolePermissionRepository extends BaseRepository<RolePermission, Long> {

    List<RolePermission> findByRoleId(long roleId);

    List<RolePermission> findByPermissionId(long permissionId);


}
