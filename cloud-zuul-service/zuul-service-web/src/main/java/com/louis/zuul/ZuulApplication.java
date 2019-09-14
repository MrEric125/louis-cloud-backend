package com.louis.zuul;

import com.louis.common.web.web.anontation.SpringCloudClient;
import com.louis.core.repository.SimpleBaseRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author John·Louis
 * @date create in 2019/5/19
 */
@EnableZuulServer
@EnableZuulProxy
@RestController
@SpringCloudClient
@EnableOAuth2Sso
@EnableJpaRepositories(repositoryBaseClass = SimpleBaseRepository.class)
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

    @GetMapping("/test1")
    public String test1() {

        return "test1";
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
//     a9390319-07e3-4939-a5d3-82116f21fee6

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
    @SuppressWarnings("unchecked")
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
