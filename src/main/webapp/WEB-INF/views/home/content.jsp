<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="/css/reset.css">
	<link rel="stylesheet" href="/css/home.css">
	<link rel="stylesheet" href="/css/content.css">
	<title>Insert title here</title>
</head>
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

	<div class="content-main-box">
		<c:if test="${not empty content}">
			<div>제목 : ${content.title}</div>
			<div>
				<label>글쓴이</label>
				<div>${content.writer}</div>
				<label>작성 날짜</label>
				<div>${content.regdate}</div>
				<label>조회수</label>
				<div>${content.hit} 건</div>
			</div>
			
				<textarea readonly>${content.content}</textarea>
			
		</c:if>
	</div>
</main>
</body>
</html>