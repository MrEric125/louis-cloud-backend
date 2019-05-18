package com.louis.security.oauth.user.entity;

import com.louis.core.entity.BaseEntity;
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
public class UserRole extends BaseEntity<Long> {

    private static final long serialVersionUID = -4161710021962553754L;

    private Long userId;

    private String roleName;

    private String description;

    public UserRole(String roleName) {
        this.roleName = roleName;
    }

    public String authority() {
        return this.getRoleName();
    }

}
