package com.louis.voucherserviceweb;

import com.louis.common.web.web.anontation.SpringCloudClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringCloudClient
@EnableSwagger2
@EnableJpaAuditing()
public class VoucherServiceWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoucherServiceWebApplication.class, args);
    }

}
