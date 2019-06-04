package com;

import com.louis.common.web.web.anontation.SpringCloudClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringCloudClient
public class CloudHystrixApplication {

    public static void main(String[] args) {


        SpringApplication.run(CloudHystrixApplication.class, args);
    }

    @HystrixCommand(fallbackMethod = "defaultUser")
    @GetMapping("/getUser")
    public String getUser(@RequestParam("userName") String userName) throws Exception {
        if ("spring".equals(userName)) {

            return "this is real user";

        } else {
            throw new Exception();
        }

    }

    public String defaultUser(String userName) {

        return "this is defaultUser";
    }

    /**
     * 这个版本需要加这一段才能有让HystrixDashBoard生效
     *  http://localhost:9877/hystrix 进入主页面
     *  http://localhost:9877/actuator/hystrix.stream 进入监控页面
     * @return Servlet
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}
