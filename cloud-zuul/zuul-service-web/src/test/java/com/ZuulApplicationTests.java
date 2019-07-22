package com;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @author John·Louis
 * @date create in 2019/5/19
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZuulApplicationTests.class)
public class ZuulApplicationTests {


    @Bean
    public Request getRequest() {
        return new Request(1, 2, 3, Lists.newArrayList("zhangsan"));
    }

    @Bean
    public Response getResponse() {
        return new Response();
    }

    @Test
    public void contextLoads() {

        Request request = getRequest();
        request.setMessage("requestMessage");
        Response response = getResponse();
        BeanUtils.copyProperties(request, response);
        System.out.println(response);

    }
}


@NoArgsConstructor
@AllArgsConstructor
@Data
class Request extends Per1{

    private int id;

    private int warehouse;

    private int barCode;
    private List<String> idList;

}
@Data
@NoArgsConstructor
@AllArgsConstructor
class Response extends Per2{

    private int id;

    private int warehouse;

    private int barCode;

    private List<String> idList;

}
@Setter
@Getter
class Per1{
    private String message;
}
@Setter
@Getter
class Per2{
    private String message;
}
