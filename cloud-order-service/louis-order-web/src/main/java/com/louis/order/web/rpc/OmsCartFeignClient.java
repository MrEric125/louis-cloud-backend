package com.louis.order.web.rpc;


import com.louis.common.api.response.wrapper.Wrapper;
import com.louis.common.feign.BaseFeignClient;
import com.louis.common.web.web.BaseController;
import com.louis.order.api.service.OmsCartService;
import com.louis.order.web.entity.OmsCart;
import com.louis.order.web.vo.ProductDto;
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
public class OmsCartFeignClient extends BaseController implements com.louis.common.feign.BaseFeignClient<OmsCart, ProductDto, Long> {

    @Autowired
    OmsCartService cartService;


    /**
     * 更新购物车中的产品
     * @param eList 对象集合
     * @return
     */
    @Override
    public Wrapper updateList(List<ProductDto> eList) {
        return null;
    }

    @Override
    public Wrapper update(ProductDto e) {
        return null;
    }

    @Override
    public Wrapper add(ProductDto e) {
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
        List<OmsCart> all = cartService.findAll();
        return handleResult(all);
    }

}
