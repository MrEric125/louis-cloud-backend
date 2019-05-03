package com.louis.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eric
 * @date create in 2019/5/3
 */

@RestController
public class UserController {

    @Reference(version = "1.0.0")
    private UserService userService;



    @RequestMapping("/user/{id}")
    public String getUSer(@PathVariable("id") String id) {

        return userService.getUser(id);
    }

}
