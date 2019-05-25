package com.louis.order.api.feign;

import com.louis.common.api.wrapper.PageWrapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.order.api.dto.OmsCartDto;
import com.louis.order.api.dto.OmsRequest;
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
     * @param omsRequest
     * @return
     */
    @PostMapping(value = "/toCart")
    Wrapper addProductToCart(@RequestBody OmsRequest omsRequest);

    /**
     * 修改购物车
     * @param omsRequest
     * @return
     */
    @PostMapping(value = "/modifyCart")
    Wrapper modifyCart(@RequestBody OmsRequest omsRequest);

    /**
     * 刪除购物车中的商品
     * @param omsRequest
     */
    @PostMapping(value = "/cleanCart")
    Wrapper deleteCart(@RequestBody OmsRequest omsRequest);


    /**
     * 反选商品
     * @param omsRequest
     * @return
     */
    @PostMapping(value = "/insertCart")
    Wrapper inverseSelection(@RequestBody OmsRequest omsRequest);




}
