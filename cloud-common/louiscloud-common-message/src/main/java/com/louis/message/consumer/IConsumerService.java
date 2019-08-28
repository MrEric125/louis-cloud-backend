package com.louis.message.consumer;

import com.louis.message.Message;

import java.util.List;

/**
 * @author louis
 * <p>
 * Date: 2019/8/9
 * Description:
 */
public interface IConsumerService {


    void consumerMessage(List<Message> messages, String topic, String systemCode);

    void consumerToDb(List<Message> messages, String topic, String sysCode);



}
