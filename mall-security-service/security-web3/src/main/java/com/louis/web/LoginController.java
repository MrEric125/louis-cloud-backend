package com.louis.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author John·Louis
 * @date create in 2019/6/29
 * description:
 */
@Controller
@RequestMapping("/")
public class LoginController {

    BigInteger bigInteger;

    @GetMapping
    public String indexPage() {
        BigInteger one = BigInteger.ONE;
        bigInteger.negate();
        return "index";
    }

    @GetMapping("/login.html")
    public String loginPage() {
        return "login";

    }


}
