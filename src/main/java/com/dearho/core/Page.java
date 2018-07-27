package com.dearho.core;

import java.io.Serializable;

public class Page implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 5245489448079707060L;

	private int  pageSize = 10;
	 
	private int  currentPage = 1;
	
	private String pageOrderString;
	 
	

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getPageOrderString() {
		return pageOrderString;
	}

	public void setPageOrderString(String pageOrderString) {
		this.pageOrderString = pageOrderString;
	}

	
	 

}
