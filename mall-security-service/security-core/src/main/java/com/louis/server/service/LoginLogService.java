package com.louis.server.service;

import com.louis.common.api.dto.IdName;
import com.louis.core.service.ICRUDService;
import com.louis.server.entity.UserLoginLog;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/7/5
 * Description: the interface of login log
 */
public interface LoginLogService extends ICRUDService<UserLoginLog, Long> {

    void saveLoginMessage(IdName<Long> user, String ipAddr);

}
