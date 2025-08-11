package com.poiboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.poiboard.domain.MenuDTO;

@Mapper
public interface MenuMapper {
	
	/* INSERT : 메뉴추가 */
	void addMenu(@Param("menuname") String menuname);
	
	/* SELECT ALL : 모든 메뉴 검색 */
	List<MenuDTO> getMenuList();
	
	/* SELECT 1 : 단일 메뉴 검색 */
	MenuDTO getMenu(@Param("menuid") String menuid);
	
	/* UPDATE menuname : 메뉴 이름 수정 */
	void updateMenuname(@Param("menuid") String menuid, @Param("menuname") String menuname);
	
	/* DELETE 임시 */
	void deleteMenu(@Param("menuid") String menuid);
}
