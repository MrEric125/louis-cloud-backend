package com.louis.security.oauth.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Eric
 * @date create in 2019/4/15
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserRole {
    private String roleName;

    public String authority() {
        return this.getRoleName();
    }

}
