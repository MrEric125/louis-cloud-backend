package com.louis.order.web.rpc;


import com.louis.common.api.response.wrapper.Wrapper;
import com.louis.common.web.web.CRUDController;
import com.louis.order.api.service.OmsCartService;
import com.louis.order.web.entity.OmsCart;
import com.louis.order.web.vo.CartProductVo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author Eric
 * @date create in 2019/5/11
 */
@RestController
@Api(value = "OmsCartFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class OmsCartFeignClient extends CRUDController<OmsCart, Long> {


    @Autowired
    private OmsCartService omsCartService;

    public Wrapper updateCartList(@RequestBody List<CartProductVo> cartProductVoList) {
        log.info("updateCartList - 更新购物车. cartProductVoList={}", cartProductVoList);
//        int result = omsCartService.updateCartList(cartProductVoList);
        return null;
//        return handleResult(result);
    }


}
