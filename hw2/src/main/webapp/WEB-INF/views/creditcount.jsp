<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Credit Count</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/main.css" />
</head>
<body>
	<table>
	<thead><tr><td>년도</td><td>학기</td><td>이수학점</td><td>상세보기</td></tr></thead>
	<tbody><c:forEach var="credit" items="${credits }">
		<tr><td><c:out value="${credit.year }"/></td><td><c:out value="${credit.semester }"/></td>
		<td><c:out value="${credit.credit }"/></td>
		<td><a href="<c:url value="/courselist" ><c:param name="year" value="${credit.year }"></c:param>
		<c:param name="semester" value="${credit.semester }"></c:param></c:url>">링크</a></td></tr>
	</c:forEach></tbody>
	</table>
</body>
</html>