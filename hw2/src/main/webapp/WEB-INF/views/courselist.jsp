<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check Registration</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/main.css" />
</head>
<body>
	<table>
	<thead><tr><td>수강년도</td><td>학기</td><td>교과코드</td><td>교과목명</td><td>구분</td><td>학점</td></tr></thead>
	<tbody><c:forEach var="course" items="${courses }">
		<tr><td><c:out value="${course.year }"/></td><td><c:out value="${course.semester }"/></td>
		<td><c:out value="${course.code }"/></td><td><c:out value="${course.title }"/></td>
		<td><c:out value="${course.division }"/></td><td><c:out value="${course.credit }"/></td></tr>		
	</c:forEach></tbody>
	</table>
</body>
</html>