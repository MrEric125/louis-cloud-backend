package com.louis.oauth.status;

/**
 * <p>User:
 * <p>Date: 13-3-11 下午3:19
 * <p>Version: 1.0
 *  用户状态
 */
public enum UserStatus {

    normal(1), blocked(0);

    private final int info;

    private UserStatus(int info) {
        this.info = info;
    }

    public int getInfo() {
        return info;
    }


}
