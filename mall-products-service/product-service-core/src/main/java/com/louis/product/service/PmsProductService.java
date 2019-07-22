package com.louis.product.service;

import com.louis.core.service.CRUDService;
import com.louis.product.entity.PmsProduct;
import com.louis.product.repository.PmsProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author John·Louis
 * @date create in 2019/5/26
 */
@Service
public class PmsProductService extends CRUDService<PmsProduct, Long> {

    public PmsProductRepository getRepository() {
        return (PmsProductRepository)baseRepository;
    }
}
