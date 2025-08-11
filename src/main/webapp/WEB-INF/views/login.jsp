<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>POI BOARD</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="/css/reset.css">
	<link rel="stylesheet" href="/css/userbox.css">
</head>
<body>
<!-- Header 영역 -->
<%@ include file="header.jsp" %>

<!-- Main 영역 -->
<main>
<input type="hidden" id="menuSee" value="${menuSee}"/>
	<form class="userbox-form" action="/login" method="post">
		<c:choose>
			<c:when test="${not empty errorMsg}">
				<div style="color: red; font-size: 18px;">${errorMsg}</div>
			</c:when>
			<c:otherwise>
				<div>PoI Board</div>
			</c:otherwise>
		</c:choose>
		<div>
			<p>아이디</p><input type="text" name="userid" placeholder="아이디를 입력해주세요."/>
		</div>
		<div>
			<p>비밀번호</p><input type="password" name="passwd" placeholder="비밀번호를 입력해주세요."/>
		</div>
		<div>
			<a href="/signinForm">회원가입</a><button type="submit">로그인</button>
		</div>
	</form>
</main>
<script src="/js/user.js"></script>
</body>
</html>