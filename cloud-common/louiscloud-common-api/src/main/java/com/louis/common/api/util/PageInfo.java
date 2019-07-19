

package com.louis.common.api.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The class Page util.
 *
 * @author John·Louis
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo {

	/**
	 * The cur page.当前页
	 */
	@Builder.Default
	private int currentPage = 1;

	/**
	 * The next page.下一页
	 */
//	private int nextPage;

	/**
	 * The pre page. 上一页
	 */
//	private int prePage;

	/**
	 * The total row. 总条数
	 */
	private long totalElement;

	/**
	 * The page size.每页条数
	 */
	@Builder.Default
	private int pageSize = 10;

	/**
	 * The total page.总页数
	 */
	private int totalPage;

	/**
	 * The start. 开始条数
	 */
//	private int start;

	/**
	 * The buttons.
	 */
//	private int[] buttons;

	/**
	 * 当前页条数
	 */
//	private int curPageSize;



	/**
	 * Instantiates a new page util.
	 *
	 * @param currentPage the current page
	 */
	public PageInfo(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * Instantiates a new page util.
	 *
	 * @param currentPage the current page
	 * @param pageSize    the page size
	 */
	public PageInfo(int currentPage, int pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

	public PageInfo(int currentPage, int pageSize, int totalPage) {
		this(currentPage, pageSize);
		this.totalPage = totalPage;

	}

}
