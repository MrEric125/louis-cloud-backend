package com.louis.stream.feign;

import com.louis.common.api.wrapper.Wrapper;
import com.louis.stream.dto.ExceptionLogDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author louis
 * <p>
 * Date: 2019/8/30
 * Description:
 */
@FeignClient(value = "louis-order-web")
@RequestMapping("/exception")
public interface ExceptionLogFeignApi {

    @PostMapping("/load")
    Wrapper loadExceptionLog(ExceptionLogDto logDto);

}
