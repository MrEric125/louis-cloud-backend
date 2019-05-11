package com.louis.entity;

import com.louis.entity.BaseEntity;
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
    private static final long serialVersionUID = -6395189170429579471L;
    private String orderId;

    private String payBank;

    private int cash;

    private Date pay_date;


}
