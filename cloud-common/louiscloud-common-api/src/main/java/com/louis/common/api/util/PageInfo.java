

package com.louis.common.api.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


/**
 *  sj  2019年7月19日13:58:21
 *
 *   Spring page中的某些信息不需要，重新封装一下
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
	 * 总条数
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

//	/**
//	 * 是否为第一页
//	 */
//	private boolean start;
//
//
//	/**
//	 * 是否为最后一页
//	 */
//	private boolean last;

	/**
	 * 是否排序
	 */
	private boolean sorted;

	/**
	 * 如果排序了的话显示排序字段
	 */
	private List<SortInfo> sortInfos;







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
