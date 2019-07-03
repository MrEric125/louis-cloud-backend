package com.louis.productserviceweb;

/**
 * @author louis
 * <p>
 * Date: 2019/7/2
 * Description:
 */
public class UserServiceImpl implements UserService {

    @Override
    public void save() {
        System.out.println("save success");
    }

    @Override
    public int select() {
        System.out.println("select success");

        return 0;
    }
}
