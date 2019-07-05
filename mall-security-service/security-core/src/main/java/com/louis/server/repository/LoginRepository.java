package com.louis.server.repository;

import com.louis.core.repository.BaseRepository;
import com.louis.server.entity.UserLoginLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author John·Louis
 * @date create in 2019/5/19
 */
@Repository
public interface LoginRepository extends BaseRepository<UserLoginLog, Long> {


    @Query(nativeQuery = true, value = "select * from sys_login_info s where s.user_id=?1 and s.last_login<?2 order by s.last_login desc limit 1")
    UserLoginLog findByUserId(Long userId, Date currentTime);

}
