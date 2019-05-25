package com.louis.order.web.rpc;


import com.google.common.collect.Lists;
import com.louis.common.api.util.PageUtil;
import com.louis.common.api.wrapper.PageWrapMapper;
import com.louis.common.api.wrapper.PageWrapper;
import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.web.web.BaseController;
import com.louis.core.search.Searchable;
import com.louis.order.api.dto.OmsCartDto;
import com.louis.order.api.dto.OmsRequest;
import com.louis.order.api.feign.OmsCartFeignClientApi;
import com.louis.order.entity.OmsCart;
import com.louis.order.service.OmsCartService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;


import org.springframework.http.MediaType;
import org.springframework.util.Assert;
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
    public PageWrapper<List<OmsCartDto>> queryOmsCartDetail(long userId, int currentPage, int pageSize) {

        Searchable searchable = Searchable.newSearchable();
        searchable.setPage(currentPage, pageSize);
        Page<OmsCart> cartByUserId = cartService.findCartByUserId(userId, searchable);
        log.info("find cart by UserId:{}", userId);
        List<OmsCartDto> omsCartDtos = convertEntitysToDtos(cartByUserId.getContent());

        return PageWrapMapper.wrap(omsCartDtos, new PageUtil(cartByUserId.getTotalPages(), cartByUserId.getSize()));
    }

    @Override
    public Wrapper addProductToCart(OmsRequest omsRequest) {
/*
        log.info("oms add cart productId:{}", omsRequest.getProductId());
        OmsCart omsCart = OmsCart
                .builder()
                .productId(omsRequest.getProductId())
                .quantity(omsRequest.getNum())
                .userId(omsRequest.getUserId())
                .build();
        OmsCart save = cartService.save(omsCart);
        return handleResult(save);*/
        return null;
    }

    @Override
    public Wrapper modifyCart(OmsRequest omsRequest) {
        return null;
    }

    @Override
    public Wrapper deleteCart(OmsRequest omsRequest) {
        log.info("delete cart cartId:{}", omsRequest.getCartId());
        cartService.findById(omsRequest.getCartId()).markDeleted();
        return WrapMapper.ok();
    }

    @Override
    public Wrapper inverseSelection(OmsRequest omsRequest) {
        OmsCart omsCart = cartService.findByIdAndProductId(omsRequest.getCartId(), omsRequest.getProductId());
        Assert.notNull(omsCart,"沒有找到对应商品");
        if (omsCart.isChecked()) {
            omsCart.setChecked(false);
        } else {
            omsCart.setChecked(true);
        }
        return WrapMapper.ok();
    }

    public List<OmsCartDto> convertEntitysToDtos(List<OmsCart> carts) {
        List<OmsCartDto> cartDtos = Lists.newArrayList();
        carts.forEach(x->{
            OmsCartDto dto = new OmsCartDto();
            BeanUtils.copyProperties(x, dto);
            cartDtos.add(dto);
        });
        return cartDtos;
    }

}
