package com.louis.security.oauth.user.entity;

/**
 * @author Eric
 * @date create in 2019/4/15
 */
public enum RoleEnum {

    ADMIN("ADMIN"),MEMBER("MEMBER");

    private String desc;

    RoleEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
