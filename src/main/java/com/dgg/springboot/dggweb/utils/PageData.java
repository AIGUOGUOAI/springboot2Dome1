package com.dgg.springboot.dggweb.utils;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;


/**
 * 分页插件
 * @param <T>
 */
public class PageData<T> implements Serializable {

	private static final long serialVersionUID = -1345410588160781414L;

	private int pageNo;

	private int pageSize;

	private long totalCount;

	private List<T> data = Collections.emptyList();

	public int getPageNo() {
		return pageNo ;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo <= 0 ? 1 : pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		if(totalCount <= 0){
			this.totalCount = 0;
		}else{
			this.totalCount = totalCount;
			this.pageNo = 0;
		}

	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
