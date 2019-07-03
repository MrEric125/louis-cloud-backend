package com.louis.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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


//    @RequestMapping("/error")
//    @ResponseBody
//    public String error(HttpServletRequest request, HttpServletResponse response) {
//        System.out.println("error Page");
//        return "error";
//    }

//    BigInteger bigInteger;
//
//    @GetMapping
//    public String indexPage() {
//        BigInteger one = BigInteger.ONE;
//        bigInteger.negate();
//        return "index";
//    }
//
//    @GetMapping("/login.html")
//    public String loginPage() {
//        return "login";
//
//    }


}
