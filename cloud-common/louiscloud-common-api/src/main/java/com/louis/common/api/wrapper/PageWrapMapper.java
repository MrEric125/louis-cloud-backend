

package com.louis.common.api.wrapper;


import com.louis.common.api.util.PageInfo;

/**
 * The class Page wrap mapper.
 *
 * @author John·Louis
 */
public class PageWrapMapper {

	/**
	 * Instantiates a new page wrap mapper.
	 */
	private PageWrapMapper() {
	}

	private static <E> PageWrapper<E> wrap(int code, String message, E o, PageInfo Pageable) {
		return new PageWrapper<>(code, message, o, Pageable);
	}

	/**
	 * Wrap data with default code=200.
	 *
	 * @param <E>      the type parameter
	 * @param o        the o
	 * @param Pageable the page util
	 *
	 * @return the page wrapper
	 */
	public static <E> PageWrapper wrap(E o, PageInfo Pageable) {
		return wrap(WrapperMassage.SUCCESS_CODE, WrapperMassage.SUCCESS_MESSAGE, o, Pageable);
	}


	/**
	 * Un wrapper.
	 *
	 * @param <E>     the type parameter
	 * @param wrapper the wrapper
	 *
	 * @return the e
	 */
	public static <E> E unWrap(PageWrapper<E> wrapper) {
		return wrapper.getResult();
	}


}
