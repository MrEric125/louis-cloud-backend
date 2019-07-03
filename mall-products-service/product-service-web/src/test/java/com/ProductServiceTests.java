package com;

import com.louis.productserviceweb.aop.PersonAspect;
import com.louis.proxy.ConferenceServiceImpl;
import com.louis.product.service.PmsProductService;
import com.louis.productserviceweb.aop.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = AppConfig.class)
public class ProductServiceTests {


    @Autowired
    AppConfig appConfig;





    @Test
    public void contextLoads() {

    }

}
