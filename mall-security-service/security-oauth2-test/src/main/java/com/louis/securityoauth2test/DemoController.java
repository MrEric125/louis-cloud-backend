package com.louis.securityoauth2test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eric
 * @date create in 2019/6/14
 */
@RestController
public class DemoController {


    @RequestMapping("api/get")
    public String getSomething() {
        return "ttttttttttt";
    }



        @RequestMapping("/")
        public String root() {
            return "redirect:/index";
        }

        @RequestMapping("/index")
        public String index() {
            return "index";
        }

        @RequestMapping("/user/index")
        public String userIndex() {
            return "user/index";
        }


}
