package com.louis.stream.core.repository;

import com.louis.core.repository.BaseRepository;
import com.louis.stream.core.entity.ExceptionLog;
import org.springframework.stereotype.Repository;

/**
 * @author louis
 * <p>
 * Date: 2019/8/30
 * Description:
 */
@Repository
public interface ExceptionLogRepository extends BaseRepository<ExceptionLog,Long> {
}
