<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-rside">
	<div class="rside-user">
		<c:if test="${not empty target}">
			<div><label>아이디</label>${target.userid}</div>
			<div><label>닉네임</label>${target.username}</div>
			<div><label>이메일</label>${target.email}</div>
			<div><label>point</label>${target.point}</div>
		</c:if>
	<div>
		<a href="/logout">로그아웃</a>
		<a href="/updateUserForm">정보 변경</a>
	</div>
</div>
	<div class="rside-content">
		<label>이달의 우수 사진</label>
		<img src="/images/image009.jpg"/>
		<img src="/images/image010.jpg"/>
		<img src="/images/image012.jpg"/>
		<img src="/images/image003.jpg"/>
	</div>
</div>