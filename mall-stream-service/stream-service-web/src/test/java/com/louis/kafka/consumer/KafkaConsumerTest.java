package com.louis.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author louis
 * <p>
 * Date: 2019/7/23
 * Description:
 */
public class KafkaConsumerTest {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "false");
        props.put("auto.commit.interval.ms", "3000");
        props.put("session.timeout.ms", "30000");
        props.put("heartbeat.interval.ms", "3000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("louis_topic", "bar"));
        boolean flag = true;
        while (flag) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(10));

            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("topic= %s, offset = %d, key = %s, value = %s\n", record.topic(), record.offset(), record.key(), record.value());

            }
            flag = false;
        }
        consumer.close();

        ConcurrentHashMap concurrentHashMa = new ConcurrentHashMap();


    }
}
