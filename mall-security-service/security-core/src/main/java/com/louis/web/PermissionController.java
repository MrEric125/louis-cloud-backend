package com.louis.web;

import com.louis.common.web.web.WebCRUDController;
import com.louis.oauth.dto.PermissionDto;
import com.louis.server.entity.SysPermission;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author louis
 * <p>
 * Date: 2019/6/21
 * Description:
 */
@Api("权限相关操作")
@RequestMapping(value = "/permission", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class PermissionController extends WebCRUDController<SysPermission, PermissionDto, Long> {



}
