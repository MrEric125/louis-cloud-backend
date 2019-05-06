package com.louis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/6
 * Description:
 */
@Repository
public interface BaseRepository <T, ID> extends JpaRepository<T, ID> {


}
