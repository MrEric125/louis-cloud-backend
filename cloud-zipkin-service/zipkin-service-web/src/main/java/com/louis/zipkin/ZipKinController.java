package com.louis.zipkin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author louis
 * <p>
 * Date: 2019/9/29
 * Description:
 */
@RestController
@RequestMapping("/zipkin")
public class ZipKinController {

    @RequestMapping("/zipkin")
    public String zipKin() {
        return "zipkin";
    }


}
