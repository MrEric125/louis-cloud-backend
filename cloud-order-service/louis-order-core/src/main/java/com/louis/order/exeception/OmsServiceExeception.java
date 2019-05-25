package com.louis.order.exeception;

import com.louis.exception.BusinessException;
import com.louis.exception.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Eric
 * @date create in 2019/5/12
 */
@Slf4j
public class OmsServiceExeception extends BusinessException {
    private static final long serialVersionUID = -634451955707946257L;

    /**
     * Instantiates a new Uac rpc exception.
     */
    public OmsServiceExeception() {
    }

    /**
     * Instantiates a new Uac rpc exception.
     *
     * @param code      the code
     * @param msgFormat the msg format
     * @param args      the args
     */
    public OmsServiceExeception(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
        log.info("<== OmcRpcException, code:{}, message:{}", this.code, super.getMessage());
    }

    /**
     * Instantiates a new Uac rpc exception.
     *
     * @param code the code
     * @param msg  the msg
     */
    public OmsServiceExeception(int code, String msg) {
        super(code, msg);
        log.info("<== OmcRpcException, code:{}, message:{}", this.code, super.getMessage());
    }

    /**
     * Instantiates a new Omc rpc exception.
     *
     * @param codeEnum the code enum
     */
    public OmsServiceExeception(ErrorCodeEnum codeEnum) {
        super(codeEnum.code(), codeEnum.msg());
        log.info("<== OmcRpcException, code:{}, message:{}", this.code, super.getMessage());
    }

    /**
     * Instantiates a new Omc rpc exception.
     *
     * @param codeEnum the code enum
     * @param args     the args
     */
    public OmsServiceExeception(ErrorCodeEnum codeEnum, Object... args) {
        super(codeEnum, args);
        log.info("<== OmcRpcException, code:{}, message:{}", this.code, super.getMessage());
    }
}
