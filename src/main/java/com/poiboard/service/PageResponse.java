package com.poiboard.service;

import java.util.ArrayList;
import java.util.List;

public class PageResponse<T> {
	
	/* 현재 페이지에 보여줄 DB 자료 : Select 결과 */
	private List<T> list = new ArrayList<>();
	
	private Pagination pagination;
	
	public PageResponse(List<T> list, Pagination pagination) {
		this.list = list;
		this.pagination = pagination;
	}
	
	public List<T> getList() {
		return list;
	}
	
	public Pagination getPagination() {
		return this.pagination;
	}
	
}
