<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>POI BOARD</title>
	<link rel="stylesheet" href="/css/reset.css">
	<link rel="stylesheet" href="/css/menus.css">
</head>
<body>
<!-- Header 영역 -->
<jsp:include page="../header.jsp">
	<jsp:param name="menus" value="${menus}"/>
</jsp:include>

<!-- Main 영역 -->
<main>
	<form class="menuadd-box" action="/menu/update_run" method="post">
		<div>관리자 기능 [메뉴 수정]</div>
		<div>
			<p>메뉴 이름</p>
			<input type="hidden" name="menuid" value="${menuid}"/>
			<input type="text" name="menuname" value="${menuname}"/>
			<p id="add">메뉴 수정</p>
		</div>
	</form>
</main>
<script>
	const addEl = document.querySelector('[id=add]');
	
	addEl.addEventListener('click', function() {
		document.querySelector('form').submit();
	});
</script>
</body>
</html>