package com.poiboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.poiboard.domain.MenuDTO;

@Mapper
public interface MenuMapper {
	
	void addMenu(@Param("menuname") String menuname);
	
	List<MenuDTO> getMenuList();
}
