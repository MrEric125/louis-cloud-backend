package com.louis.server.service;

import com.louis.core.service.ICRUDService;
import com.louis.server.entity.SysPermission;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author John·Louis
 * @date create in 2019/6/24
 * description:
 */
public interface PermissionService extends ICRUDService<SysPermission, Long> {


    boolean hasPermission(Authentication authentication, HttpServletRequest request);

}
