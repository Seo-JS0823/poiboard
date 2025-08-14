package com.poiboard.domain;

import com.poiboard.service.Pagination;

public class SearchDTO {
	
	/* 현재 페이지 번호 : nowPage */
	private int page;
	
	/* 페이지당 출력할 게시글 개수 : pageCount */
	private int recordSize;
	
	/* 화면 하단에 출력할 페이지 번호 개수 : pageTotalCount */
	private int pageSize;
	
	/* 검색 키워드 : 검색 가능한 문장 */
	private String keyword;
	
	/* 검색 유형 : title, content, writer */
	private String searchType;
	
	/* Pagination 정보 */
	private Pagination pagination;
	
	public SearchDTO() {
		this.page = 1;
		this.recordSize = 10;
		this.pageSize = 10;
	}
	
	public int getOffset() {
		return (page - 1) * recordSize;
	}
	
	/* Getter 영역 */
	public int getPage() {
		return this.page;
	}
	
	public int getRecordSize() {
		return this.recordSize;
	}
	
	public int getPageSize() {
		return this.pageSize;
	}
	
	public String getKeyword() {
		return this.keyword;
	}
	
	public String searchType() {
		return this.searchType;
	}
	
	public Pagination getPagination() {
		return this.pagination;
	}
	
	/* Setter 영역 */
	public void setPage(int page) {
		this.page = page;
	}
	
	public void setRecordSize(int recordSize) {
		this.recordSize = recordSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	@Override
	public String toString() {
		return "SearchDTO [page=" + page + ", recordSize=" + recordSize + ", pageSize=" + pageSize + ", keyword="
				+ keyword + ", searchType=" + searchType + ", pagination=" + pagination + "]";
	}
}
