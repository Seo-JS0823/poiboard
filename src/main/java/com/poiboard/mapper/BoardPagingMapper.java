package com.poiboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.poiboard.domain.BoardDTO;
import com.poiboard.domain.MenuDTO;

@Mapper
public interface BoardPagingMapper {
	int count(MenuDTO menuDto);
	
	List<BoardDTO> getBoardPagingList(String menuid, int offset, int recordSize);
}
