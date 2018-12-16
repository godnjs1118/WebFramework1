<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/main.css" />
</head>
<body>
	<h3>Custom Login with Username and Password</h3>
	<c:if test="${not empty logoutMsg }">
		<div style="color:#0000ff"><h3> ${logoutMsg} </h3></div>
	</c:if>
	<form name='f' action='<c:url value="/login"/>' method='POST'>
		<c:if test="${not empty errorMsg }">
			<div style="color:#ff0000"><h3> ${errorMsg} </h3></div>
		</c:if>
		<table>
			<tr><td>User: </td><td><input type='text' name='username'/></td></tr>
			<tr><td>Password: </td><td><input type='password' name='password'/></td></tr>
			<tr><td colspan='2'><input type='submit' value='login'/></td></tr>
		</table>
		<input name='${_csrf.parameterName }' type='hidden' value='${_csrf.token }' />
	</form>
</body>
</html>