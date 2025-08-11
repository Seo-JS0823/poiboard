<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<!-- 상단 메뉴바가 올 영역 -->
	<a href="/">POI BOARD</a>
	<c:forEach var="menu" items="${menus}">
		<a href="/board/list?menuid=${menu.menuid}">${menu.menuname}</a>
	</c:forEach>
</header>