package com.louis.security.login;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Eric
 * @date create in 2019/4/14
 */
@Setter
@Getter
public class LoginRequest {
    private String username;
    private String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
