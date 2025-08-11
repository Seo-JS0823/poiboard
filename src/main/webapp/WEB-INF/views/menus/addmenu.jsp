<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>PoI Board Manager</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="/css/reset.css">
	<link rel="stylesheet" href="/css/menus.css">
</head>
<body>
<!-- Header 영역 -->
<jsp:include page="../header.jsp">
	<jsp:param name="menus" value="${menus}"/>
</jsp:include>

<!-- main 영역 -->
<main>
	<form class="menuadd-box" action="/menu/add" method="post">
		<div>
			<a href="/admin/on">관리자 홈</a>
			관리자 기능 [메뉴 추가]
			<a href="/admin/userList">유저 리스트</a>
		</div>
		<div>
			<p>메뉴 이름</p>
			<input type="text" name="menuname" placeholder="메뉴이름을 입력해주세요."/>
			<p id="add">메뉴 추가</p>
		</div>
	</form>
	<table class="menulist-box">
		<colgroup>
			<col style="width: 100px;">
			<col style="width: 250px;">
			<col style="width: 250px;">
			<col style="width: 100px;">
		</colgroup>
		<tr>
			<th>메뉴 번호</th>
			<th>메뉴 이름</th>
			<th>메뉴 아이디</th>
			<th>게시글 수</th>
			<th colspan="2">관리</th>
		</tr>
		<c:forEach var="menu" items="${menuList}">
		<tr>
			<td>${menu.menuseq}</td>
			<td>${menu.menuname}</td>
			<td>${menu.menuid}</td>
			<td>게시글 수</td>
			<td><a href="/menu/upd?menuid=${menu.menuid}">수정</a></td>
			<td><a href="/menu/del?menuid=${menu.menuid}">삭제</a></td>
		</tr>
		</c:forEach>
	</table>
</main>
<script>
	const addEl = document.querySelector('[id=add]');
	const menuname = document.querySelector('[name=menuname]');
	
	addEl.addEventListener('click', function(e) {
		
		if(menuname.value.trim() == '') {
			alert('관리자씨? 메뉴를 입력을 해야 추가가 되겠지?');
			
			e.preventDefault();
			
			return false;
		} else {
			document.querySelector('form').submit();			
		}
		
	});
</script>
</body>
</html>