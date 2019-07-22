package com.louis.server.repository;

import com.louis.core.repository.BaseRepository;
import com.louis.server.entity.SysPermission;
import org.springframework.stereotype.Repository;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/18
 * Description:
 */
@Repository
public interface PermissionRepository extends BaseRepository<SysPermission, Long> {

}
