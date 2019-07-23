package com.louis.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author John·Louis
 * <p>
 * Date: 2019/6/6
 * Description:
 */
@RestController
@Slf4j
public class ProducerController {

    @Autowired
    private SendService sendService;

    @Autowired
    private MessageService2 messageService2;

    @RequestMapping("/send/{msg}")
    public String send(@PathVariable("msg") String message) {
        sendService.sendMsg(message);
        return "发送消息成功";

    }

    @RequestMapping("/send2/{msg}")
    public void send2(@PathVariable("msg") String message) {

        messageService2.sendMsg(message);

    }

    @PostMapping("/doPost")
    public String doPost(@RequestParam("userName")String userName,@RequestParam("password") String password) {
        log.info("userName:{},password:{}", userName, password);
        return userName + password;


    }

}
