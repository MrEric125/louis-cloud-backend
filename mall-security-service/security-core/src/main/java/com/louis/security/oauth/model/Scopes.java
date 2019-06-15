package com.louis.security.oauth.model;

/**
 * @author Eric
 * @date create in 2019/4/14
 */
public enum  Scopes {
    REFRESH_TOKEN;

    public String authority() {
        return "ROLE_" + this.name();
    }

}
