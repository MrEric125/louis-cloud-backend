package com.louis.common.repository;

import com.louis.entity.Payment;
import com.louis.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 80003996
 * <p>
 * Date: 2019/5/8
 * Description:
 */
@Repository
public interface PaymentRepository extends BaseRepository<Payment,Long> {
}
