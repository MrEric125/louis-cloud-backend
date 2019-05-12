package com.louis.order.api.repository;


import com.louis.common.api.repository.BaseRepository;
import com.louis.order.web.entity.OmsOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/6
 * Description:
 */
@Repository
public interface OmsOrderRepository extends BaseRepository<OmsOrder,Long> {


    List<OmsOrder> findAllByOrderUser(String userId);


}
