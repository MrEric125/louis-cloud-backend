package com.louis.order.web.controller;

import com.google.common.collect.Lists;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.web.web.BaseController;
import com.louis.core.utils.StringGenerateUtil;
import com.louis.order.Constant;
import com.louis.order.entity.OmsOrder;
import com.louis.order.entity.OmsPayInfo;
import com.louis.order.enums.OrderStatusEnum;
import com.louis.order.enums.PayInfoEnum;
import com.louis.order.service.OmsOrderDetailService;
import com.louis.order.service.OmsOrderLogisticsService;
import com.louis.order.service.OmsOrderService;
import com.louis.order.service.OmsPayInfoService;
import com.louis.product.api.dto.PmsProductDto;
import com.louis.product.api.feign.PmsProductClientApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author louis
 * <p>
 * Date: 2019/9/27
 * Description:
 */
@RestController
@RequestMapping("/data")
public class DataGenerateController extends BaseController {


    @Value("${order.length}")
    private int orderLength;

    @Autowired
    PmsProductClientApi pmsProductClient;

    @Autowired
    OmsOrderService orderService;

    @Autowired
    OmsOrderDetailService orderDetailService;

    @Autowired
    OmsOrderLogisticsService orderLogisticsService;

    @Autowired
    OmsPayInfoService omsPayInfoService;

    @PostMapping("generateOrder/{seller}")
    @Transactional
    public Wrapper generateOrder(@PathVariable String seller) {
        List<PmsProductDto> dtos = pmsProductClient.findBySellerName(seller);
        List<OmsOrder> omsOrders = Lists.newArrayList();
        OrderStatusEnum[] orderStatus = OrderStatusEnum.values();
        List<OmsPayInfo> omsPayInfos = Lists.newArrayList();


        for (PmsProductDto dto : dtos) {

            Random random = new Random();
            int index = random.nextInt(orderStatus.length);

            Date closeDate = null;
            String deliverCode=null;
            Integer payChannel = null;
            String transactionNumber = null;
            if (orderStatus[index].code()==60) {
                closeDate = new Date();
            }
//            生成配送信息
            if (orderStatus[index].code()==40) {
                deliverCode = StringGenerateUtil.generateCode(Constant.DELIVERY_PRE, new Date(), 20);
            }
            //生成支付信息
            if (orderStatus[index].code() == 20) {
                PayInfoEnum[] payInfoEnums = PayInfoEnum.values();
                payChannel= payInfoEnums[random.nextInt(payInfoEnums.length)].code();



            }
//            生成完成收货信息
            if (orderStatus[index].code() == 50) {
                transactionNumber = StringGenerateUtil.generateCode("T", new Date(), 20);
            }

            OmsOrder order = OmsOrder.builder()
                    .orderCode(StringGenerateUtil.generateCode(Constant.ORDER_PRE, new Date(), orderLength == 0 ? 30 : orderLength))
                    .beganTime(new Date())
                    .orderStatus(orderStatus[index].code())
                    .closeTime(closeDate)
                    .deliverCode(deliverCode)
                    .integral(payChannel == null ? null : (int) (dto.getPrice().doubleValue() * 0.2))
                    .payChannel(payChannel)
                    .payment(payChannel == null ? null : dto.getPrice())
                    .paymentTime(payChannel == null ? null : new Date())
                    .postage(5)
                    .sendTime(deliverCode != null ? null : new Date())
                    .transactionNumber(transactionNumber)
                    .userId(1L)
                    .build();
            order.setCreatedTime(new Date());
            order.setUpdateTime(new Date());
            order.setCreatorId(1L);
            order.setLastOperator("admin");
            order.setLastOperatorId(1L);
            if (payChannel != null) {
                OmsOrder saveOrder = orderService.save(order);
                OmsPayInfo payInfo = new OmsPayInfo();
                payInfo.setOrderNo(saveOrder.getId());
                payInfo.setPaymentAmount(saveOrder.getPayment().add(BigDecimal.valueOf(saveOrder.getPostage())));
                payInfo.setUserId(1L);
                payInfo.setPayPlatform(payChannel);
                payInfo.setPlatformStatus("1");
                omsPayInfoService.save(payInfo);
            } else {
                omsOrders.add(order);
            }
        }
        List<OmsOrder> saveOrder = orderService.saveBatch(omsOrders);
        Page<OmsOrder> omsOrderPage = new PageImpl<>(saveOrder);
        return handlePageAndSortResult(omsOrderPage);

    }






}
