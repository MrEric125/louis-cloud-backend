package com.louis.resource.web;

import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author John·Louis
 * @date create in 2019/11/10
 * description:
 */
@RestController
@RequestMapping("/insert")
public class InsertController {


    @RequestMapping("/insert")
    public Wrapper insertSomeThing() {
        return WrapMapper.wrap("this is insert something just admin has authority");
    }
}
