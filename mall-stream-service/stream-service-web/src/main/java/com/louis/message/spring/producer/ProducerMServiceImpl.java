package com.louis.message.spring.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author louis
 * <p>
 * Date: 2019/7/24
 * Description:
 */

@Slf4j
@Service
public class ProducerMServiceImpl implements MessageProducer {

    @Autowired
    private KafkaTemplate<String ,Object> kafkaTemplate;



    private String topic;



    @Override
    public void send(String topic,Object message) {
        /*ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("发送消息失败：{}", ex.getMessage());

            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                log.info("=======================");
                log.info("发送结果:{}", result.toString());
                log.info("=======================");

            }
        });
*/
        ListenableFuture<SendResult<String, Object>> send = kafkaTemplate.send(topic, message);

        send.completable();



    }
}
