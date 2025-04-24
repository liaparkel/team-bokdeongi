package com.bok.model;

public class PagingVO {
    private int pageIndex;
    private int pageSize;
    private int startRow;
    private int endRow;
    
	public PagingVO(int pageIndex, int pageSize) {
		this.pageIndex = pageIndex < 1 ? 1 : pageIndex;
		this.pageSize = pageSize;
		this.startRow = (this.pageIndex -1) * this.pageSize;
		this.endRow = this.startRow + this.pageSize;
	}
	
	public int getPageIndex() {
		return pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getStartRow() {
		return startRow;
	}
	public int getEndRow() {
		return endRow;
	}
}
