package com.louis.order.repository;


import com.louis.core.repository.BaseRepository;
import com.louis.order.entity.OmsOrder;
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


    List<OmsOrder> findAllByUserId(Long userId);


}
