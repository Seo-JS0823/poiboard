<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="/css/reset.css">
	<link rel="stylesheet" href="/css/home.css">
</head>
<body>
<!-- Header 영역 -->
<jsp:include page="../header.jsp">
	<jsp:param name="menus" value="${menus}"/>
</jsp:include>

<!-- main 영역 -->
<main>

<!-- Left Side 영역 -->
<jsp:include page="../lside.jsp">
	<jsp:param name="target" value="${target}"/>
</jsp:include>

	<form id="content-submit" action="/board/write" method="post">
	<div class="container-content">
		<div class="content-top">
			<div>
				<input type="text" name="search" placeholder="검색할 제목을 입력해주세요."/>
				<a href="" id="btn-m">검색</a>
			</div>
			<div>
				<input type="hidden" name="userid" value="${target.userid}" readonly/>
				<input type="hidden" name="writer" value="${target.username}" readonly/>
				<input id="title" type="hidden" name="title" placeholder="작성할 제목을 입력해주세요."/>
				<a id="btn-m">글쓰기</a>
			</div>
			<div>
				<select id="menuList" name="menuid">
					<option value="" disabled selected>옵션을 선택해 주세요</option>
					<c:forEach var="menu" items="${menus}">
						<option value="${menu.menuid}">${menu.menuname}</option>
					</c:forEach>
				</select>	
				<a id="btn-m">작성 취소</a>
				<button type="button">작성 완료</button>
			</div>
		</div>
		<div>
			<textarea id="inputArea" name="content" placeholder="내용을 입력해주세요."></textarea>
		</div>
	</div>
	</form>
</main>
</body>
<script src="/js/home.js"></script>
</html>