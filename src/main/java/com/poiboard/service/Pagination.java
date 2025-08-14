package com.poiboard.service;

import com.poiboard.domain.SearchDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pagination {
	/* menuid에 해당하는 검색된 전체 데이터 수 */
	private int totalRecordCount;
	
	/* 전체 페이지 수 */
	private int totalPageCount;
	
	/* 첫 페이지 번호 */
	private int startPage;
	
	/* 끝 페이지 번호 */
	private int endPage;
	
	/* LIMIT 시작 위치 */
	/* Oracle의 offset과 같음 */
	private int limitStart;
	
	/* 이전 페이지 존재 여부 */
	private boolean existPrevPage;
	
	/* 다음 페이지 존재 여부 */
	private boolean existNextPage;
	
	public Pagination(int totalRecordCount, SearchDTO params) {
		if(totalRecordCount > 0) {
			this.totalRecordCount = totalRecordCount;
			calculation(params);
		}
	}
	
	private void calculation(SearchDTO params) {
		
		/* 전체 페이지 수 계산 */
		totalPageCount = (int) Math.ceil((double) totalRecordCount / (double) params.getRecordSize());
		
		/* 현재 페이지 번호가 전체 페이지 수보다 큰 경우, 현재 페이지 번호에 전체 페이지 수 저장 */
		if(params.getPage() > totalPageCount) {
			params.setPage(totalPageCount);
		}
		
		/* 첫 페이지 번호 계산 */
		// startPage = ((params.getPage() - 1) / params.getPageSize()) * params.getPageSize() + 1;
		startPage = params.getPage() - (params.getPageSize() / 2);
		if(startPage < 0) {
			startPage = 1;
		}
		
		/* 끝 페이지 번호 계산 */
		// endPage = startPage + params.getPageSize() - 1;
		endPage = params.getPage() + (params.getPageSize() / 2);
		
		/* 끝 페이지가 전체 페이지 수보다 큰 경우, 끝 페이지 전체 페이지 수 저장 */
		if(endPage > totalPageCount) {
			endPage = totalPageCount;
		}
		
		/* LIMIT 시작 위치 계산 */
		limitStart = (params.getPage() - 1) * params.getRecordSize();
		
		/* 이전 페이지 존재 여부 확인 */
		existPrevPage = startPage != 1;
		
		/* 다음 페이지 존재 여부 확인 */
		existNextPage = (endPage * params.getRecordSize()) < totalRecordCount;
		
	}
	
	/*
	public static void main(String[] args) {
		int startPage = 0;
		int endPage = 0;
		int nowPage = 4;
		int pageSize = 7;
		
		for(int i = 0; i < 10; i++) {
			startPage = nowPage - (pageSize / 2);
			
			endPage = nowPage + (pageSize / 2);
			
			nowPage += 1;
			
			System.out.println("startPage: " + startPage + " || endPage: " + endPage);
		}
	}
	*/
	
	
	
	
}
