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
<body>
<!-- Header 영역 -->
<%@ include file="../header.jsp" %>

<!-- main 영역 -->
<main>
	<table class="menulist-box">
		<colgroup>
			<col style="width: 100px;">
			<col style="width: 250px;">
		</colgroup>
		<tr>
			<th>메뉴 번호</th>
			<th>메뉴 이름</th>
		</tr>
		<c:forEach var="menu" items="${menuList}">
		<tr>
			<td>${menu.menuseq}</td>
			<td>${menu.menuname}</td>
		</tr>
		</c:forEach>
	</table>
</main>
</body>
</html>