package com.louis.order.web.rpc;


import com.louis.common.api.response.wrapper.WrapMapper;
import com.louis.common.api.response.wrapper.Wrapper;
import com.louis.common.web.web.BaseController;
import com.louis.order.api.feign.OmsCartFeignClientApi;
import com.louis.order.api.service.OmsCartService;
import com.louis.order.web.dto.OmsCartDto;
import com.louis.order.web.entity.OmsCart;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author Eric
 * @date create in 2019/5/11
 */
@RestController
@Api(value = "OmsCartFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class OmsCartFeignClient extends BaseController implements OmsCartFeignClientApi {

    @Autowired
    OmsCartService cartService;


    @Override

    public Wrapper updateList(List<OmsCartDto> eList) {

        return null;
    }

    @Override
    public Wrapper update(OmsCartDto e) {
        return null;
    }

    @Override
    public Wrapper add(OmsCartDto e) {
        return null;
    }

    @Override
    public Wrapper deleteById(Long aLong) {
        return null;
    }

    @Override
    public Wrapper findOne(Long aLong) {
        return null;
    }

    @Override
    public Wrapper findAll() {
        return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE,"this is find All FeignClient");

    }
}
