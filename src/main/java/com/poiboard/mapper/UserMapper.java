package com.poiboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.poiboard.domain.UserDTO;

@Mapper
public interface UserMapper {
	
	/* 
	INSERT : addUser
	사용자 추가
	*/
	void addUser(UserDTO user);
	
	/*
	SELECT(1) : getUser
	사용자 검색
	 */
	UserDTO getUser(UserDTO user);
	
	/*
	SELECT(ALL) : getUserList
	사용자 전부 검색
	*/
	List<UserDTO> getUserList();
	
	/*
	UPDATE(point) : contentPlusPoint
	그 머시냐 게시글 쓰면 포인트 증가하는거
	*/
	void contentPlusPoint(UserDTO user);
	
	/*
	UPDATE(passwd) : updatePasswd
	비밀번호 변경
	*/
	
	/*
	UPDATE(email) : updateEmail
	이메일 변경
	*/
	
	/*
	UPDATE(flag) : deleteUser
	유저 삭제
	*/
	
}
