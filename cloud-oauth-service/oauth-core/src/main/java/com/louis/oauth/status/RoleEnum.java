package com.louis.oauth.status;

/**
 * @author John·Louis
 * @date create in 2019/4/15
 */
public enum RoleEnum {

    ADMIN("ADMIN"),USER("USER");

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
