package com.louis.order.web.rpc;


import com.google.common.collect.Lists;
import com.louis.common.api.dto.LoginAuthDto;
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
    public Wrapper addProductToCart(OmsCartDto dto) {

        log.info("oms add cart productId:{}", dto.getProductId());
        OmsCart omsCart = OmsCart
                .builder()
                .productId(dto.getProductId())
                .quantity(dto.getQuantity())
                .userId(dto.getUserId())
                .build();

        LoginAuthDto loginAuthDto = LoginAuthDto.builder().userId(5L).userName("zhangsan").build();
        omsCart.setUpdateInfo(loginAuthDto);

        OmsCart save = cartService.saveAndFlush(omsCart);

        return handleResult(save);
    }


    /**
     * 可能是整个购物车都删掉，也可能是指删除其中部分商品
     * @param omsRequest
     * @return
     */
    @Override
    public Wrapper deleteCart(List<Long> products) {
        log.info("delete cart productds:{}", products);

//        cartService.findById(omsRequest.getCartId()).markDeleted();
        cartService.delByProductIds(products);

        return WrapMapper.ok();
    }

    @Override
    public Wrapper inverseSelection(long cartId,long productId) {
        OmsCart omsCart = cartService.findByIdAndProductId(cartId, productId);

        Assert.notNull(omsCart,"沒有找到对应商品");
        if (omsCart.isChecked()) {
            omsCart.setChecked(false);
        } else {
            omsCart.setChecked(true);
        }
        cartService.save(omsCart);
        return WrapMapper.ok();
    }

    private List<OmsCartDto> convertEntitysToDtos(List<OmsCart> carts) {
        List<OmsCartDto> cartDtos = Lists.newArrayList();
        carts.forEach(x->{
            OmsCartDto dto = new OmsCartDto();
            BeanUtils.copyProperties(x, dto);
            cartDtos.add(dto);
        });
        return cartDtos;
    }

}
