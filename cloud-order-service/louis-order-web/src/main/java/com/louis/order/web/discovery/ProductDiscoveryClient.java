package com.louis.order.web.discovery;

import com.louis.order.entity.OmsProduct;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author John·Louis
 * @date create in 2019/6/9
 * <p>
 * description:
 */
@Component
public class ProductDiscoveryClient {

    @Autowired
    DiscoveryClient discoveryClient;

    public OmsProduct getProduct() {

        RestTemplate restTemplate = new RestTemplate();
        List<InstanceInfo> instancesById = discoveryClient.getInstancesById("");

        String serverUri = "";
        ResponseEntity<OmsProduct> exchange = restTemplate.exchange(serverUri, HttpMethod.GET, null, OmsProduct.class, "");
        return exchange.getBody();


    }
}
