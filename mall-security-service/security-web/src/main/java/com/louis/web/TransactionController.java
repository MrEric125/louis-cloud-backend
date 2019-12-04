package com.louis.web;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Maps;
import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author louis
 * <p>
 * Date: 2019/12/3
 * Description:
 */
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @RequestMapping("/list")
    public Wrapper transactionList() {

        Map<String, Object> item = Maps.newHashMap();
        item.put("order_no", "CE6DD2EE-fa1C-AB34-ee22-E0CB3232aBb");
        item.put("price", "1015.7");
        item.put("status", "pending");
        item.put("timestamp", 949718587873L);
        item.put("username", "Scott Wilson");

        Map<String, Map<String, Object>> returnMap = ImmutableMap.of("item", item);
        return WrapMapper.wrap(returnMap);

    }


}
