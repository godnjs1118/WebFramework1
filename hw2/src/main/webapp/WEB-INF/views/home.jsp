<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>Home</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/main.css" />
</head>
<body>
	<p><a href=${pageContext.request.contextPath}/creditcount>학기별 이수 학점 조회</a></p>
	<p><a href=${pageContext.request.contextPath}/registercourse>수강 신청하기</a></p>
	<p><a href=${pageContext.request.contextPath}/checkregistration>수강 신청 조회 메뉴</a></p> 

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<a href="javascript:document.getElementById('logout').submit()">Logout</a>
	</c:if>
	
	<form id="logout" action="<c:url value="/logout" />" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
</body>
</html>