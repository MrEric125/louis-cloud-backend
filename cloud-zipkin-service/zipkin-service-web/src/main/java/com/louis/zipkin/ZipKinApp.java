package com.louis.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * @author louis
 * <p>
 * Date: 2019/9/29
 * Description:
 */
@EnableZipkinServer
@SpringBootApplication
public class ZipKinApp {

    public static void main(String[] args) {
        SpringApplication.run(ZipKinApp.class, args);
    }
}
