

package com.louis.common.web.web;

import com.louis.common.api.dto.LoginAuthDto;
import com.louis.common.api.wrapper.WrapMapper;
import com.louis.common.api.wrapper.Wrapper;
import com.louis.common.api.wrapper.WrapperMassage;
import com.louis.core.entity.BaseEntity;
import com.louis.core.utils.ReflectUtils;
import com.louis.exception.BusinessException;
import com.louis.exception.ErrorCodeEnum;
import com.louis.core.constant.GlobalConstant;
import com.louis.core.entity.generator.IncrementIdGenerator;
import com.louis.core.entity.generator.UniqueIdGenerator;
import com.louis.core.utils.PublicUtil;
import com.louis.core.utils.ThreadLocalMap;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Optional;
import java.util.function.Supplier;


/**
 * @author John·Louis
 *
 * @date 2019年5月30日22:53:36
 *
 * description
 */
@Slf4j
public abstract class BaseController<ID extends Serializable>  {






	/**
	 * Gets login auth dto.
	 *
	 * @return the login auth dto
	 */
	protected LoginAuthDto<Long> getLoginAuthDto() {
		LoginAuthDto<Long> loginAuthDto = (LoginAuthDto) ThreadLocalMap.get(GlobalConstant.Sys.TOKEN_AUTH_DTO);
		return Optional.ofNullable(loginAuthDto).orElseThrow(() -> new BusinessException(ErrorCodeEnum.UAC10011041));
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


	/**
	 * special Scene ,should return null result
	 *
	 * @param result
	 * @param errorMsg
	 * @param <T>
	 * @return
	 */
	protected <T> Wrapper<T> returnNullResult( String errorMsg) {

		if (errorMsg == null) {
			return WrapMapper.wrap(WrapperMassage.SUCCESS_CODE, "操作成功");
		} else {
			return WrapMapper.wrap(WrapperMassage.ERROR_CODE, errorMsg);
		}
	}

	/**
	 * special Scene ,should return null result
	 *
	 * @param result
	 * @param errorMsg
	 * @param <T>
	 * @return
	 */
	protected <T> Wrapper<T> returnNullResult() {
		return returnNullResult( null);
	}

	/**
	 * 判断对象是否为空
	 * @param result
	 * @return
	 */
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

	protected <T> void resolve(Supplier<T> resolver){

	}

	protected long generateId() {
		return UniqueIdGenerator.getInstance(IncrementIdGenerator.getServiceId()).nextId();
	}



}
  