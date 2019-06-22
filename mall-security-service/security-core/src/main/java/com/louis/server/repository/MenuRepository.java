package com.louis.server.repository;

import com.louis.core.repository.BaseRepository;
import com.louis.server.entity.MenuItem;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author louis
 * <p>
 * Date: 2019/6/21
 * Description:
 */
@Repository
public interface MenuRepository extends BaseRepository<MenuItem, Long> {

    List<MenuItem> findByParentId(long parentId);




}
