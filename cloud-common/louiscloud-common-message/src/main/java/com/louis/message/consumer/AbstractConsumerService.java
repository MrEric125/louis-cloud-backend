package com.louis.message.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.louis.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author louis
 * <p>
 * Date: 2019/8/9
 * Description:
 */

@Service
public abstract class AbstractConsumerService<T> implements IConsumerService {

    @Autowired
    ObjectMapper objectMapper;

    private Class<T> getGenericClass() {
        return null;

    }

    private T convertJson(String json) throws IOException {
        return objectMapper.readValue(json, getGenericClass());
    }

    /**
     * 将json转换成相关的泛型对象
     * @param json
     * @return
     * @throws IOException
     */
    public List<T> convertJson(List<String> json) throws IOException {

        List<T> list = new ArrayList<>();
        for (String s : json) {
            T convertJson = convertJson(s);
            list.add(convertJson);
        }
        return list;

    }



}
