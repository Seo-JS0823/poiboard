<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="/css/reset.css">
	<link rel="stylesheet" href="/css/home.css">
	<title>Insert title here</title>
</head>
<style>
	
</style>
<body>
<!-- Header 영역 -->
<jsp:include page="../header.jsp">
	<jsp:param name="menus" value="${menus}"/>
</jsp:include>

<!-- Main 영역 -->
<main>

<!-- Left Side 영역 -->
<jsp:include page="../lside.jsp">
	<jsp:param name="target" value="${target}"/>
</jsp:include>

	<div class="container-content">
		<c:if test="${not empty menu}">
			<div class="menu-title-box"><label>${menu}</label> 게시판 목록</div>
			<div>
				<table class="paging">
					<tr>
					<c:set var="prev" value="${response.pagination.existPrevPage}"/>
					<c:set var="next" value="${response.pagination.existNextPage}"/>
					<c:set var="start" value="${response.pagination.startPage}"/>
					<c:set var="end" value="${response.pagination.endPage}"/>
					<c:set var="totalPage" value="${response.pagination.totalPageCount}"/>
					<c:if test="${prev == true}">
						<td><a href="/board/list?nowpage=1&menuid=${menuid}">⏮</a></td>
						<td><a href="/board/list?nowpage=${start - 1}&menuid=${menuid}">⏪</a></td>
					</c:if>
					<c:forEach var="page" begin="${start}" end="${end}">
						<td><a href="/board/list?nowpage=${page}&menuid=${menuid}">${page}</a></td>
					</c:forEach>
					<c:if test="${next == true}">
						<td><a href="/board/list?nowpage=${end + 1}&menuid=${menuid}">⏩</a></td>
						<td><a href="/board/list?nowpage=${totalPage}&menuid=${menuid}">⏭</a></td>
					</c:if>
					</tr> 
				</table>
			</div>
		</c:if>
		<table class="board-table">
			<colgroup>
				<col style="width: 70px;"/>
				<col style="width: 300px;"/>
				<col style="width: 100px;"/>
				<col style="width: 200px;"/>
				<col style="width: 70px;"/>
			</colgroup>
			<tr>
				<th>게시번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성 날짜</th>
				<th>조회수</th>
			</tr>
		<c:forEach var="board" items="${boards}">
			<tr>
				<td>${board.idx}</td>
				<td><a href="/board/content?idx=${board.idx}">${board.title}</a></td>
				<td>${board.writer}</td>
				<td>${board.regdate}</td>
				<td>${board.hit}</td>
			</tr>
		</c:forEach>
		</table>
	</div>
</main>
</body>
</html>