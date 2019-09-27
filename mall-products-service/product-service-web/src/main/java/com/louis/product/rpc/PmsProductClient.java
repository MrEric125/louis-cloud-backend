package com.louis.product.rpc;

import com.louis.common.web.web.BaseController;
import com.louis.product.api.dto.PmsProductDto;
import com.louis.product.api.feign.PmsProductClientApi;
import com.louis.product.entity.PmsProduct;
import com.louis.product.service.PmsProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author louis
 * <p>
 * Date: 2019/9/27
 * Description:
 */
@RestController
@Api("order feign clientAPI")
public class PmsProductClient extends BaseController implements PmsProductClientApi {

    @Autowired
    PmsProductService pmsProductService;

    @Override
    public PmsProductDto findByProductId(Long id) {
        PmsProduct product = pmsProductService.findById(id);
        return pmsProductService.entityToDto(product);

    }

    @Override
    public List<PmsProductDto> findBySellerName(String sellerName) {
        List<PmsProduct> bySellerName = pmsProductService.findBySellerName(sellerName);
        return pmsProductService.entitiesToDtos(bySellerName);
    }
}
