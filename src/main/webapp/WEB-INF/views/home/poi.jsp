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
<%@ include file="../header.jsp" %>

<!-- main 영역 -->
<main>
	<div class="container-rside">
		<div class="rside-user">
			<a href="/logout">로그아웃</a>
		</div>
		<div class="rside-content">
			임시 영역
		</div>
	</div>
	<div class="container-content">
		콘텐트
	</div>
</main>
</body>
</html>