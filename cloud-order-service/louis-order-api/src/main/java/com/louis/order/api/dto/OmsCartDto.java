package com.louis.order.api.dto;


import com.louis.common.api.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Eric
 * @date create in 2019/5/12
 */
@Setter
@Getter
public class OmsCartDto extends BaseDto<Long> {


    private Long userId;

    private Long productId;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 是否选择,1=已勾选,0=未勾选
     */
    private boolean checked;


}
