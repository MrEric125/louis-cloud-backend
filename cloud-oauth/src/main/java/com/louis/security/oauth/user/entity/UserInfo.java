package com.louis.security.oauth.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Eric
 * @date create in 2019/4/14
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    private String userName;

    private String password;
}
