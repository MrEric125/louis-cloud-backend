package com.louis.entity;

import com.louis.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/8
 * Description:
 */
@Setter
@Getter
public class Payment extends BaseEntity<String> {
    private String orderId;

    private String payBank;

    private int cash;

    private Date pay_date;


}
