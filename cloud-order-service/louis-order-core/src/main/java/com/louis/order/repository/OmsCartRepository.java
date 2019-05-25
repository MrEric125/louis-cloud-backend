package com.louis.order.repository;

import com.louis.core.repository.BaseRepository;
import com.louis.order.entity.OmsCart;
import org.hibernate.annotations.SQLDelete;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Eric
 * @date create in 2019/5/11
 */
@Repository
public interface OmsCartRepository extends BaseRepository<OmsCart,Long> {


    OmsCart findByIdAndProductId(Long id, Long productId);


    @SQLDelete(sql = "update oms_cart set deleted=1,update_time= now() where product_id in ?1")
    void delProductIds(List<Long> productIds);

}
