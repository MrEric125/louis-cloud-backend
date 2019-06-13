package com.louis.strean;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author louis
 * <p>
 * Date: 2019/6/6
 * Description:
 */
@EnableBinding(Sink.class)
public class ReceiveService {


    @StreamListener(Sink.INPUT)
    public void receive(Object payload) {

        System.out.println(payload);

    }

}
