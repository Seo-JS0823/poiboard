<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="/css/reset.css">
	<link rel="stylesheet" href="/css/menus.css">
</head>
<style>
	table {
		table-layout: fixed;
	}
	
	.menulist-box {
		width: 90%;
		min-width: 1000px;
	}
</style>
<body>
<!-- Header 영역 -->
<jsp:include page="../header.jsp">
	<jsp:param name="menus" value="${menus}"/>
</jsp:include>

<!-- Main 영역 -->
<main>
	<div class="menuadd-box">
		<div>
			<a href="/admin/on">관리자 홈</a>
			관리자 기능 [유저 관리]
			<a href="/menu/addForm">메뉴 추가</a>
		</div>
		
	</div>
	<table class="menulist-box">
		<tr>
			<th>아이디</th>
			<th>PASS-WORD</th>
			<th>이름</th>
			<th>이메일</th>
			<th>포인트</th>
			<th>가입일</th>
			<th>관리</th>
		</tr>
		<c:forEach var="user" items="${users}">
		<tr>
			<td>${user.userid}</td>
			<td>${user.passwd}</td>
			<td>${user.username}</td>
			<td>${user.email}</td>
			<td>${user.point}</td>
			<td>${user.indate}</td>
			<td><a href="/admin/userdel?userid=${user.userid}">강제 탈퇴</a></td>
		</tr>
		</c:forEach>
	</table>
</main>
</body>
</html>