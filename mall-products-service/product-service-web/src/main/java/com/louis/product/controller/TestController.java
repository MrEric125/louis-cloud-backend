package com.louis.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/6
 * Description:
 */
@RestController
public class TestController {

    @RequestMapping("/user")
    public String getString() {

        return "this is the test";
    }
}
