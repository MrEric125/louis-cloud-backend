package com.louis.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Eric
 * @date create in 2019/6/16
 */
public class PasswordEncoderTests {


    public static void main(String[] args) {
        String admin = new BCryptPasswordEncoder().encode("admin");
        System.out.println(admin);
    }
}
