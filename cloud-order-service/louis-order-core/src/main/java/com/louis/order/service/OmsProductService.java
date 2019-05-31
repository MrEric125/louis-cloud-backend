package com.louis.order.service;


import com.louis.core.service.CRUDService;
import com.louis.order.entity.OmsProduct;
import com.louis.order.repository.OmsProductRepository;
import org.springframework.stereotype.Service;

/**
 * @author Eric
 * @date create in 2019/5/12
 */
@Service
public class OmsProductService extends CRUDService<OmsProduct,Long> {


    public OmsProductRepository getRepository() {
        return (OmsProductRepository)baseRepository;
    }


}
