package com.louis.order.api.dto;


import com.louis.common.api.dto.BaseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @author John·Louis
 * @date create in 2019/5/12
 */
@Setter
@Getter
@ApiModel(description = "购物车")
public class OmsCartDto extends BaseDto<Long> {


    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("购物车中商品相关属性")
    private List<OmsCartDetailDto> itemDtoList;


    @ApiModelProperty("跟新时间")
    private Date updateTime;

    @ApiModelProperty("已选的商品总价=各个商品单价*件数")
    private int totalAmount;





}
