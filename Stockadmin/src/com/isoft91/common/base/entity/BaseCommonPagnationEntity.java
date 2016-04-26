package com.isoft91.common.base.entity;

public class BaseCommonPagnationEntity implements BaseCommonEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7204517766871891551L;
	
	
	private Integer page;
	private Integer rows;
	private Integer startIndex;
	private Long totalCount;
	private Long totalPageCount;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getStartIndex() {
		startIndex = (page-1)*rows;
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public Long getTotalPageCount() {
		if(totalCount%rows==0){
			totalPageCount = totalCount/rows;
		}else{
			totalPageCount = totalCount/rows+1;
		}
		return totalPageCount;
	}
	public void setTotalPageCount(Long totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	
	
}
