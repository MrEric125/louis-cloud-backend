package com.louis.kafka.customer;

import org.apache.kafka.common.serialization.Serializer;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author John·Louis
 * @date create in 2019/8/7
 * description:
 */
public class CustomerSerializer implements Serializer<Customer> {
    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

    @Override
    public byte[] serialize(String s, Customer customer) {
        if (customer==null) {
            return null;
        }
        byte[] name, address;
        if (customer.getName() != null) {
            name = customer.getName().getBytes(StandardCharsets.UTF_8);
        } else {
            name = new byte[0];
        }
        if (customer.getAddress() != null) {
            address = customer.getAddress().getBytes(StandardCharsets.UTF_8);
        } else {
            address = new byte[0];
        }
        ByteBuffer buffer = ByteBuffer.allocate(4 + 4 + name.length + address.length);
        buffer.putInt(name.length);
        buffer.put(name);
        buffer.put(address);
        buffer.putInt(address.length);
        return new byte[0];

    }

    @Override
    public void close() {

    }
}
