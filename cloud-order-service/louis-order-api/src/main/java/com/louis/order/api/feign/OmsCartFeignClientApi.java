package com.louis.order.api.feign;

import com.louis.common.api.wrapper.PageWrapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.core.search.Searchable;
import com.louis.order.api.dto.OmsCartDto;
import com.louis.order.api.dto.OmsRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @RequestMapping(value = "/cartDetail/{userId}", method = RequestMethod.GET)
    PageWrapper<List<OmsCartDto>> queryOmsCartDetail(@PathVariable("userId") long userId, Searchable searchable);

    /**
     * 添加购物车
     * @param omsRequest
     * @return
     */
    @PostMapping(value = "/toCart/{omsRequest}")
    Wrapper addProductToCart(@PathVariable("omsRequest") OmsRequest omsRequest);

    /**
     * 修改购物车
     * @param omsRequest
     * @return
     */
    @PostMapping(value = "/modifyCart/{omsRequest}")
    Wrapper modifyCart(@PathVariable("omsRequest") OmsRequest omsRequest);

    /**
     * 刪除购物车中的商品
     * @param omsRequest
     */
    @PostMapping(value = "/cleanCart/{omsRequest}")
    Wrapper deleteCart(@PathVariable("omsRequest") OmsRequest omsRequest);


    /**
     * 反选商品
     * @param omsRequest
     * @return
     */
    @PostMapping(value = "/cleanCart/{omsRequest}")
    Wrapper inverseSelection(@PathVariable("omsRequest") OmsRequest omsRequest);




}
