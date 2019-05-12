package com.louis.order.api.repository;

import com.louis.common.api.repository.BaseRepository;

import com.louis.order.web.entity.OmsCart;
import org.springframework.stereotype.Repository;

/**
 * @author Eric
 * @date create in 2019/5/11
 */
@Repository
public interface OmsCartRepository extends BaseRepository<OmsCart,Long> {

    OmsCart findByProductIdAndUserId(long productId, Long userId);


}
