

package com.louis.common.api.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;


/**
 * The class Wrapper.
 * 返回到首页的包装类
 * @param <T> the type parameter @author John·Louis
 */
@Data
@JsonInclude(value =  JsonInclude.Include.NON_NULL)
public class Wrapper<T> implements Serializable {

	/**
	 * 序列化标识
	 */
	private static final long serialVersionUID = 4893280118017319089L;

	/**
	 * 基本上成功就返回200<=code<300
	 * 常用的错误提示码
	 * @see com.louis.exception.ErrorCodeEnum
	 *
	 */
	private int code;

	/**
	 * 信息.
	 * 常用的错误提示信息
	 * @see com.louis.exception.ErrorCodeEnum
	 */
	private String message;

	/**
	 * 结果数据
	 * 包装我们需要返回给View端的数据
	 */
	private T result;

	/**
	 * Instantiates a new wrapper. default code=200
	 */
	Wrapper() {
		this(WrapperMassage.SUCCESS_CODE, WrapperMassage.SUCCESS_MESSAGE);
	}

	/**
	 * Instantiates a new wrapper.
	 *
	 * @param code
	 * @param message the message
	 */
	Wrapper(int code, String message) {
		this(code, message, null);
	}

	/**
	 * Instantiates a new wrapper.
	 *
	 * @param code    the code
	 * @param message the message
	 * @param result  the result
	 */
	Wrapper(int code, String message, T result) {
		super();
		this.code(code).message(message).result(result);
	}

	/**
	 * Sets the 编号 , 返回自身的引用.
	 *
	 * @param code the new 编号
	 *
	 * @return the wrapper
	 */
	private Wrapper<T> code(int code) {
		this.setCode(code);
		return this;
	}

	/**
	 * Sets the 信息 , 返回自身的引用.
	 *
	 * @param message the new 信息
	 *
	 * @return the wrapper
	 */
	private Wrapper<T> message(String message) {
		this.setMessage(message);
		return this;
	}

	/**
	 * Sets the 结果数据 , 返回自身的引用.
	 *
	 * @param result the new 结果数据
	 *
	 * @return the wrapper
	 */
	public Wrapper<T> result(T result) {
		this.setResult(result);
		return this;
	}

	/**
	 * 判断是否成功： 依据 Wrapper.SUCCESS_CODE == this.code
	 *
	 * @return code =200,true;否则 false.
	 */
	@JsonIgnore
	public boolean success() {
		return WrapperMassage.SUCCESS_CODE == this.code;
	}

	/**
	 * 判断是否成功： 依据 Wrapper.SUCCESS_CODE != this.code
	 *
	 * @return code !=200,true;否则 false.
	 */
	@JsonIgnore
	public boolean error() {
		return !success();
	}

}
