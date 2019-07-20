package com.louis.common.api.dto;

import lombok.*;

/**
 * @author Eric
 * @date create in 2019/6/15
 *
 * 客戶请求的硬件基本信息
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientMessageDto {

    private String os;

    private String browser;

    private String remoteAddr;

    private String remoteLocation;

    private String ip;

    private String requestURI;





}
