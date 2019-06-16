package com.louis.server.repository;

import com.louis.core.repository.BaseRepository;
import com.louis.server.entity.UserToken;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * @author Eric
 * @date create in 2019/6/15
 */
@Repository
public interface UserTokenRepository extends BaseRepository<UserToken, Long> {





    UserToken findByAccessToken(String accessToken);


//    @Query(nativeQuery = true,name = "select id from sys_user_token where `status`=20")
//    List<Long> ListoffLine();

//    @Up
//    int batchUpdateTokenOffLine(Map<String, Object> map);

}
