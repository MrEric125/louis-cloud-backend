package com.louis.cloudoauth.entity;

import com.louis.core.entity.BaseEntity;
import lombok.Data;

/**
 * @author louis
 * <p>
 * Date: 2019/5/16
 * Description:
 */

@Data
public class SysUser extends BaseEntity<Long> {

    private String username;

    private String password;


}
