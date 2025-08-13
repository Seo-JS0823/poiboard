package com.poiboard.paging_example;

import com.poiboard.domain.BoardDTO;

public class PagingExample {
	
	
	public void exampl1() {
		
		int count = 1;
		
		PageResponse<BoardDTO> response = null;
		/*
		if (count < 1) {
			response = new PageResponse<>(
				Collections.emptyList(), null
			);
		}
		Collections.emptyList()
		자료가 없는 빈 리스트를 만들어서 채운다.
		컬렉션 타입 중의 비어있는 리스트 반환
		*/
		
		/*
		페이징을 위한 초기 설정
		SearchDTO searchDto = new SealedObject(getClass(), null);
		
		현재 페이지 정보 넣기
		searchDto.setPage(nowpage);
		
		한 줄에 몇개 씩 보여줄 지 정수값으로 넣기
		searchDto.setRecodeSize(10);
		
		View에 출력할 페이지 번호 수
		searchDto.setPageSize(10);
		
		SearchDTO에 담아놓고 Pagination으로
		
		Pagination pagination = new Pagination(count, searchDto);
		searchDto.setPagination(pagination);
		
		
		int offset = 30;
		int recodeSize = searchDto.getRecodeSize();
		List<BoardDTO> list = boardPagingMapper.getBoardPagingList(offset, recodeSize);
		
		
		
		*/
	}
	
}
