package com.louis.order.api.dto;


import com.louis.common.api.dto.BaseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Eric
 * @date create in 2019/5/12
 */
@Setter
@Getter
@ApiModel
public class OmsCartDto extends BaseDto<Long> {


    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("商品id")
    private Long productId;

    /**
     * 数量
     */
    @ApiModelProperty("数量")
    private Integer quantity;

    /**
     * 是否选择,1=已勾选,0=未勾选
     */
    @ApiModelProperty("是否勾选")
    private boolean checked;

    @ApiModelProperty("创建时间")
    private Date createdTime;

    @ApiModelProperty("跟新时间")
    private Date updateTime;


}
