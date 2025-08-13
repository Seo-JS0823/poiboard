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
	<form action="/updateUser" method="post">
		<c:if test="${not empty target}">
			<div class="user-update-box">
				<label>아이디</label>
				<input type="text" name="userid" value="${target.userid} (아이디는 변경할 수 없습니다)" readonly/>
			</div>
			<div class="user-update-box">
				<label>이름</label>
				<input type="text" name="username" value="${target.username} (이름은 변경할 수 없습니다)" readonly/>
			</div>
			<div class="user-update-box">
				<label>기존 비밀번호</label>
				<input type="password" name="passwd" placeholder="기존 비밀번호를 입력하세요.">
			</div>
			<div class="user-update-box">
				<label>변경할 비밀번호</label>
				<input type="password" name="newPasswd" placeholder="새로운 비밀번호를 입력하세요.">
			</div>
		</c:if>
	</form>
</div>
</main>
</body>
</html>