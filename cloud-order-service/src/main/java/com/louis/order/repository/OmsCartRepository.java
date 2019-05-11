package com.louis.order.repository;

import com.louis.order.entity.OmsCart;
import com.louis.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Eric
 * @date create in 2019/5/11
 */
@Repository
public interface OmsCartRepository extends BaseRepository<OmsCart,Long> {
}
