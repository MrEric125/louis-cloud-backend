package com.louis.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author louis
 * <p>
 * Date: 2019/7/23
 * Description:
 */
public interface MySource {

    @Output("louis_output")
    MessageChannel messageChannel();
}
