package com.louis.kafka.producer;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author louis
 * <p>
 * Date: 2019/7/23
 * Description:
 */
public class KafkaProducerTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 99; i < 110; i++) {
             producer.send(new ProducerRecord<String, String>("louis_topic", Integer.toString(i), "this is kafka value " + i),
                     (recordMetadata, e) -> System.out.println("recordMetadata ===="+recordMetadata.topic()+"  "+recordMetadata.offset()+" "+recordMetadata.partition()));

        }
        producer.close();
    }
}
