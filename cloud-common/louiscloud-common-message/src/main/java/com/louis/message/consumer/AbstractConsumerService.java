package com.louis.message.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.louis.message.Message;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@Service
public abstract class AbstractConsumerService<T> implements IConsumerService {

    @Autowired
    ObjectMapper objectMapper;

    private Class<T> getGenericClass() {
        return null;
    }

    private T convertJson(String json) {
        try {

            return objectMapper.readValue(json, getGenericClass());
        } catch (IOException e) {
            log.error("json转换异常：json:{},class{}", json, getGenericClass().getSimpleName());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json转换成相关的泛型对象
     * @param json
     * @return
     * @throws IOException
     */
    public List<T> convertJson(List<String> json)  {

        return json.stream().map(this::convertJson).collect(Collectors.toList());

    }



}
