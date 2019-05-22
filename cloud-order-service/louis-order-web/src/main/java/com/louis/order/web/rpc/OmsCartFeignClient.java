package com.louis.order.web.rpc;


import com.louis.common.web.web.BaseController;
import com.louis.order.api.feign.OmsCartFeignClientApi;
import com.louis.order.service.OmsCartService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;



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



}
