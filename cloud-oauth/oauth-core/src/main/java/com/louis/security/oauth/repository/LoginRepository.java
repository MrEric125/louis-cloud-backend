package com.louis.security.oauth.repository;

import com.louis.core.repository.BaseRepository;
import com.louis.security.oauth.entity.UserLogin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author Eric
 * @date create in 2019/5/19
 */
@Repository
public interface LoginRepository extends BaseRepository<UserLogin, Long> {


    @Query(nativeQuery = true, value = "select * from sys_login_info s where s.user_id=?1 and s.last_login<?2")
    UserLogin findByUserId(Long userId, Date currentTime);

}
