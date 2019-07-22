package com.louis.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/6
 * Description:
 */
@RestController
public class ProducerController {

    @Autowired
    private SendService sendService;

    @RequestMapping("/send/msg")
    public void send(@PathVariable("msg") String message) {

        sendService.sendMsg(message);

    }
}
