package com.louis.message.consumer;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author louis
 * <p>
 * Date: 2019/8/12
 * Description:
 */
@Service
public class DefaultConsumerServiceImpl<T> extends AbstractConsumerService<T>{
    @Override
    public void consumerMessage(List<String> messages, String topic, String systemCode) {
        List<T> ts = convertJson(messages);


    }

    @Override
    public void consumerToDb(List<String> messages, String topic, String sysCode) {


    }
}
