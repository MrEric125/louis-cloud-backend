package com.louis.order.repository;

import com.louis.core.repository.BaseRepository;
import com.louis.order.entity.OmsOrderDetail;
import org.springframework.stereotype.Repository;

/**
 * @author Eric
 * @date create in 2019/5/11
 */
@Repository
public interface OmsOrderDetailRepository extends BaseRepository<OmsOrderDetail,Long> {
}
