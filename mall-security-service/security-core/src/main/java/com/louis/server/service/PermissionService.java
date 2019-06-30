package com.louis.server.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author John·Louis
 * @date create in 2019/6/24
 * description:
 */
public interface PermissionService {

    boolean hasPermission(Authentication authentication, HttpServletRequest request);

}
