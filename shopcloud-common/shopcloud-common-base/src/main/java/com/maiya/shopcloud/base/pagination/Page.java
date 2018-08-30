package com.maiya.shopcloud.base.pagination;

import java.io.Serializable;
import java.util.List;

/**
 * 功能描述:分页参数
 *
 * @auther:  mandy.hu
 */
public class Page<T> implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2721489229612607933L;

	public static final int DEFAULT_PAGE_SIZE = 10;

    /** 每页记录条数 **/
    private int pageSize;
    /** 当前页页码 **/
    private int pageNo;
    /** 总页数 **/
    private int totalPage;
    /** 总记录条数 **/
    private int totalCount;
    /** 当前页数据集 **/
    private List<T> result;

    public Page() {
        this(1, DEFAULT_PAGE_SIZE);
    }

    public Page(int pageNo, int pageSize) {
        this.pageSize = pageSize;
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

	@Override
	public String toString() {
		return String.format("Page [pageSize=%s, pageNo=%s, totalPage=%s, totalCount=%s, result=%s]", pageSize, pageNo,
				totalPage, totalCount, result);
	}
}
