package com.louis.order.repository;

import com.louis.core.repository.BaseRepository;
import com.louis.order.entity.OmsPayInfo;
import org.springframework.stereotype.Repository;

/**
 * @author John·Louis
 * @date create in 2019/5/31
 * <p>
 * description:
 */
@Repository
public interface OmsPayRepository extends BaseRepository<OmsPayInfo, Long> {

}
