package com.louis.order.api.feign;

import com.louis.common.api.wrapper.PageWrapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.order.api.dto.OmsCartDetailDto;
import com.louis.order.api.dto.OmsCartDto;
import com.louis.order.api.dto.OmsRequest;
import com.louis.order.api.dto.ProductItemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Eric
 * @date create in 2019/5/12
 */
@FeignClient(value = "louis-order-web")
public interface OmsCartFeignClientApi  {

    /**
     * 通过用户id 查询购物车详情
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/cartDetail", method = RequestMethod.GET)
    PageWrapper<List<OmsCartDto>> queryOmsCartDetail(@RequestParam("userId") long userId,
                                                     @RequestParam(value = "currentPage",required = false) int currentPage,
                                                     @RequestParam(value = "pageSize",required = false) int pageSize);


    /**
     * 添加购物车
     * @param omsCartDto
     * @return
     */
    @PostMapping(value = "/toCart")
    Wrapper addProductToCart(@RequestBody OmsCartDetailDto omsCartDto);


    /**
     * 刪除购物车中的商品
     * @param omsRequest
     */
    @PostMapping(value = "/cleanCart")
    Wrapper deleteCart(@RequestBody List<Long> productId);


    /**
     * 反选商品
     * @param cartId
     * @param productId
     * @return
     */
    @PostMapping(value = "/modifySelected/{cartId}")
    Wrapper inverseSelection(@PathVariable("cartId") long cartId,long productId);




}
