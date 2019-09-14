
package com.louis.common.web.web;
import com.louis.common.api.BaseHandler;
import com.louis.common.api.dto.LoginAuthDto;
import com.louis.core.entity.BaseEntity;
import com.louis.core.utils.ReflectUtils;
import com.louis.exception.BusinessException;
import com.louis.exception.ErrorCodeEnum;
import com.louis.core.constant.GlobalConstant;
import com.louis.core.entity.generator.IncrementIdGenerator;
import com.louis.core.entity.generator.UniqueIdGenerator;
import com.louis.core.utils.ThreadLocalMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Optional;
import java.util.function.Supplier;
/**
 * @author John·Louis
 * @date 2019年5月30日22:53:36
 * <p>
 * description
 */
@Slf4j
public abstract class BaseController<Entity extends BaseEntity, ID extends Serializable> extends BaseHandler<Entity> {

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	@ModelAttribute
	public void initReqAndRes(HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		this.request = servletRequest;
		this.response = servletResponse;
	}
	/**
	 * Gets login auth dto
	 * @return the login auth dto
	 */
	protected LoginAuthDto getLoginAuthDto() {
		LoginAuthDto loginAuthDto = (LoginAuthDto) ThreadLocalMap.get(GlobalConstant.Sys.TOKEN_AUTH_DTO);
		return Optional.ofNullable(loginAuthDto).orElseThrow(() -> new BusinessException(ErrorCodeEnum.UAC10011041));
	}

	protected long generateId() {
		return UniqueIdGenerator.getInstance(IncrementIdGenerator.getServiceId()).nextId();
	}
}
  