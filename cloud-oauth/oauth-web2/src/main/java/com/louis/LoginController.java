package com.louis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author John·Louis
 * @date create in 2019/6/8
 * <p>
 * description:
 */
@RestController
public class LoginController {


    @RequestMapping("/login")
    public String login() {

        return "loggggggin";

    }

    @RequestMapping("/home")
    public String home() {
        return "hooooooome";
    }
}
