

package com.louis.common.web.web;

import com.louis.common.api.dto.BaseDto;
import com.louis.common.api.dto.LoginAuthDto;
import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.api.wrapper.WrapperMassage;
import com.louis.core.entity.BaseEntity;
import com.louis.exception.BusinessException;
import com.louis.exception.ErrorCodeEnum;
import com.louis.core.constant.GlobalConstant;
import com.louis.core.entity.generator.IncrementIdGenerator;
import com.louis.core.entity.generator.UniqueIdGenerator;
import com.louis.core.utils.PublicUtil;
import com.louis.core.utils.ThreadLocalMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.List;


@Slf4j
public class BaseController<E extends BaseEntity,D extends BaseDto>  {



	/**
	 * Gets login auth dto.
	 *
	 * @return the login auth dto
	 */
	protected LoginAuthDto getLoginAuthDto() {
		LoginAuthDto loginAuthDto = (LoginAuthDto) ThreadLocalMap.get(GlobalConstant.Sys.TOKEN_AUTH_DTO);
		if (PublicUtil.isEmpty(loginAuthDto)) {
			throw new BusinessException(ErrorCodeEnum.UAC10011041);
		}
		return loginAuthDto;
	}

	/**
	 * Handle result wrapper.
	 *
	 * @param result the result
	 *
	 * @return the wrapper
	 */
	protected <T> Wrapper<T> handleResult(T result) {
		boolean flag = isFlag(result);

		if (flag) {
			return WrapMapper.wrap(WrapperMassage.SUCCESS_CODE, "操作成功", result);
		} else {
			return WrapMapper.wrap(WrapperMassage.ERROR_CODE, "操作失败", result);
		}
	}

	/**
	 * Handle result wrapper.
	 *

	 * @param result   the result
	 * @param errorMsg the error msg
	 *
	 * @return the wrapper
	 */
	protected <T> Wrapper<T> handleResult(T result, String errorMsg) {
		boolean flag = isFlag(result);

		if (flag) {
			return WrapMapper.wrap(WrapperMassage.SUCCESS_CODE, "操作成功", result);
		} else {
			return WrapMapper.wrap(WrapperMassage.ERROR_CODE, errorMsg, result);
		}
	}

	private boolean isFlag(Object result) {
		boolean flag;
		if (result instanceof Integer) {
			flag = (Integer) result > 0;
		} else if (result instanceof Boolean) {
			flag = (Boolean) result;
		} else {
			flag = PublicUtil.isNotEmpty(result);
		}
		return flag;
	}

	protected long generateId() {
		return UniqueIdGenerator.getInstance(IncrementIdGenerator.getServiceId()).nextId();
	}



}
  