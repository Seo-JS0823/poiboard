package com.poiboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.poiboard.domain.BoardDTO;

@Mapper
public interface BoardMapper {

	/* 게시글 추가 */
	void insertBoard(BoardDTO boardDto);
	
	/* Menu에 해당하는 게시글 목록 가져오기 */
	List<BoardDTO> getBoardList(String menuid);
	
	/* 제목 검색으로 게시글 목록 가져오기 */
	List<BoardDTO> searchTitle(String search);
	
	/* idx 번호로 게시글 콘텐츠까지 가져오기 */
	BoardDTO getIdxContent(int idx);
	
	/* 게시글 누르면 조회수 증가하기 */
	void hitUp(BoardDTO boardDto);
	
	/* 페이징 번호에 따른 게시글 목록 가져오기 */
	List<BoardDTO> count(String menuid, int start, int recodeSize);
	
	/* 나누기 10한 게시글 수 가져오기 */
	int pagingsCount(String menuid);
	
}
