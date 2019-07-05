package com.louis.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/6
 * Description:
 */
@EnableBinding(Source.class)
public class SendService {

    @Autowired
    private Source source;

    public void sendMsg(String msg) {
        source.output().send(MessageBuilder.withPayload(msg).build());

    }
}
