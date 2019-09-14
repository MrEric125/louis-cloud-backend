package com.louis.stream.dto;

import com.louis.common.api.dto.IdName;
import com.louis.common.api.dto.LoginAuthDto;
import lombok.*;

import java.util.Date;

/**
 * @author louis
 * <p>
 * Date: 2019/8/30
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionLogDto {


    /**
     * 运行环境
     */
    private String profile;

    /**
     * 应用名称
     */
    private String applicationName;

    /**
     * 异常信息
     */
    private String exceptionMessage;

    private String username;

    /**
     * 用户id
     */
    private long userId;


    /**
     * 异常发生的时间
     */
    private Date exceptionTime;

    /**
     * 异常的原因
     */
    private String errorCause;

    /**
     * 异常类型
     */
    private String exceptionType;

    public static ExceptionLogDto exceptionLogDtoInstance(Throwable e, String profile, String applicationName, IdName<Long> user) {


        return ExceptionLogDto.builder()
                .applicationName(applicationName)
                .profile(profile)
                .userId(user.getId())
                .username(user.getName())
                .errorCause(e.getCause().getMessage())
                .exceptionMessage(e.getMessage())
                .exceptionType("")
                .exceptionTime(new Date())
                .build();
    }

}
