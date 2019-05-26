package com.louis.product.controller;

import com.louis.common.web.web.CRUDController;
import com.louis.core.service.CRUDService;
import com.louis.product.entity.PmsProduct;
import com.louis.product.service.PmsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author Eric
 * @date create in 2019/5/26
 * description:
 */
@Controller
public class PmsProductController extends CRUDController<PmsProduct,Long> {

    @Override
    public void setBaseService(CRUDService<PmsProduct, Long> baseService) {
        super.setBaseService( baseService);
    }
}
