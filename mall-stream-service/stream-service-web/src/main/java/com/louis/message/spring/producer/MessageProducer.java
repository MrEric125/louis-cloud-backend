package com.louis.message.spring.producer;

/**
 * @author louis
 * <p>
 * Date: 2019/7/24
 * Description:
 */
public interface MessageProducer {


    void send(String topic,Object message);



}
