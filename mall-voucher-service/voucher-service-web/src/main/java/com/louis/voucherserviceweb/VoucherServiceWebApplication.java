package com.louis.voucherserviceweb;

import com.louis.common.web.web.anontation.SpringCloudClient;
import org.springframework.boot.SpringApplication;

@SpringCloudClient
public class VoucherServiceWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoucherServiceWebApplication.class, args);
    }

}
