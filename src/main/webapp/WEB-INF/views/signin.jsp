<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<jsp:include page="header.jsp">
	<jsp:param name="menus" value="${menus}"/>
</jsp:include>

<!-- Main 영역 -->
<main>
	<form class="userbox-form" action="/signin" method="post">
		<div>
			PoI Board 회원가입
		</div>
		<div>
			<p>성함</p><input type="text" name="username" placeholder="성함을 입력해주세요."/>
		</div>
		<div>
			<p>아이디</p><input type="text" name="userid" placeholder="아이디에 특수문자와 한글은 들어갈 수 없습니다."/>
		</div>
		<div>
			<p>비밀번호</p><input type="password" name="passwd" id="pwd" placeholder="8~12자 사이에 최소 1개의 영문 대·소문자, 특수문자(@,#,$,%,^,&,*)를 포함해야 합니다."/>
		</div>
		<div>
			<p>비밀번호 확인</p><input type="password" id="pwdcheck" placeholder="8~12자 사이에 최소 1개의 영문 대·소문자, 특수문자(@,#,$,%,^,&,*)를 포함해야 합니다."/>
		</div>
		<div>
			<p>이메일</p><input type="text" name="email"/>
		</div>
		<div>
			<button type="submit">회원가입</button>
		</div>
	</form>
</main>
<footer>
	<!-- 아래에 올 영역 -->
</footer>
<script src="/js/user.js"></script>
</body>
</html>