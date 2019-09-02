package com.louis.stream.core.feign;

import com.louis.common.api.BaseHandler;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.stream.core.entity.ExceptionLog;
import com.louis.stream.core.repository.ExceptionLogRepository;
import com.louis.stream.dto.ExceptionLogDto;
import com.louis.stream.feign.ExceptionLogFeignApi;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author louis
 * <p>
 * Date: 2019/8/30
 * Description:
 * // TODO: 2019/8/30  后期实现通过kafka 对日志文件的处理
 */
@Service
public class ExceptionLogClient extends BaseHandler implements ExceptionLogFeignApi  {

    @Autowired
    ExceptionLogRepository exceptionLogRepository;

    @Override
    public Wrapper loadExceptionLog(ExceptionLogDto logDto) {
        ExceptionLog exceptionLog = dtoConvertEntity(logDto);
        exceptionLogRepository.save(exceptionLog);
        return handlerNullResult();

    }

    private ExceptionLog dtoConvertEntity(ExceptionLogDto dto) {
        ExceptionLog exceptionLog = new ExceptionLog();
        BeanUtils.copyProperties(dto, exceptionLog);
        return exceptionLog;
    }
}
