package com.louis.order.service;

import com.louis.common.api.search.SearchOperator;
import com.louis.common.api.search.Searchable;
import com.louis.core.service.AbstractCRUDService;

import com.louis.order.entity.OmsCart;
import com.louis.order.repository.OmsCartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author John·Louis
 * @date create in 2019/5/11
 */
@Slf4j
@Service
public class OmsCartService extends AbstractCRUDService<OmsCart, Long> {



    public OmsCartRepository getRepository() {
        return (OmsCartRepository)baseRepository;
    }


    public Page<OmsCart> findCartByUserId(long userId, Searchable searchable) {
        searchable.addSearchFilter("userId", SearchOperator.eq, userId);
        return getRepository().findAll(searchable);

    }

    public OmsCart findByIdAndProductId(long id ,long productId) {
//       return omsCartRepository.findByIdAndProductId(id,productId);
        return null;
    }

    /**
     * 通过商品id 来删除购物车中的产品
     */
    public void delByProductIds(List<Long> productIds,long userId) {
//        omsCartRepository.delProductIds(productIds,userId);
    }



    /*public int updateCartList(List<CartProductVo> cartProductVoList) {
        log.info("updateCartList - 更新购物车集合 cartProductVoList={}", cartProductVoList);

        LoginAuthDto loginUser = new LoginAuthDto();
        loginUser.setLoginName(GlobalConstant.Sys.SUPER_MANAGER_LOGIN_NAME);
        loginUser.setUserId(1L);
        for (CartProductVo cartProductVo : cartProductVoList) {
            Integer quantity = cartProductVo.getQuantity();
            Integer productChecked = cartProductVo.getChecked();
            Long productId = cartProductVo.getProductId();

            ProductDto productDto = mdcProductService.selectById(productId);

            if (PublicUtil.isEmpty(productDto)) {
                throw new MdcBizException(ErrorCodeEnum.MDC10021004, productId);
            }

            OmsCart omsCart = new OmsCart();
            omsCart.setUserId(loginUser.getUserId());
            omsCart.setQuantity(quantity);
            omsCart.setChecked(productChecked);
            omsCart.setProductId(productId);
            omsCart.setQuantity(quantity);

            this.saveCart(omsCart, loginUser);
        }
        return 1;
    }


    public void saveCart(OmsCart omsCart, LoginAuthDto<Long> authDto) {
        log.info("saveCart - 保存购物车记录 omsCart={}, userId={}", omsCart, authDto.getUserId());

        Long productId = omsCart.getProductId();
        Long userId = authDto.getUserId();
        Preconditions.checkArgument(productId != null, "货品ID不能为空");
        Preconditions.checkArgument(userId != null, ErrorCodeEnum.UAC10011001.msg());

        omsCart.setUpdateInfo(authDto);
        OmsCart omcCartExist = omsCartRepository.findByProductIdAndUserId(productId, userId);
        if (PublicUtil.isEmpty(omcCartExist)) {
            try {
                omsCartRepository.save(omsCart);
            } catch (Exception e) {
                log.error("新增购物车, 出现异常={}", e.getMessage(), e);
            }
            return;
        }
        omsCart.setId(omcCartExist.getId());
        omsCart.setQuantity(omsCart.getQuantity() + omcCartExist.getQuantity());
         omsCartRepository.save(omsCart);
        *//*if (updateResult < 1) {
            throw new OmsServiceExeception(ErrorCodeEnum.OMC10031014, omcCartExist.getId());
        }
*//*
    }*/

}
