package com.louis.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author John·Louis
 * @date create in 2019/6/26
 * description:
 */
@RestController
public class ApiTestController {

    @GetMapping("/test111111")
    public String test1111() {
        return "test1";
    }

    @GetMapping("/api/test1222")
    public String test2222() {
        return "test2";
    }
}
