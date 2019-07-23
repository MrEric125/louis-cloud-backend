package com.louis.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author louis
 * <p>
 * Date: 2019/7/23
 * Description:
 */
@EnableBinding(MySource.class)
public class MessageService2 {

    @Autowired
    private MySource mySource;

    public void sendMsg(String msg) {
        mySource.messageChannel().send(MessageBuilder.withPayload(msg).build());

    }
}
