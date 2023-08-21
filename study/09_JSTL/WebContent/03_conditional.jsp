<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>조건 if 태그</h2>
<c:if test="${userid=='홍길동'}">
	홍길동이다.
</c:if>
<c:if test="${userid!='홍길동'}">
	홍길동이 아니다.
</c:if>
<br>

<c:choose>
	<c:when test="${userid=='홍길동'}">
		홍길동입니다.
	</c:when>
	<c:when test="${userid=='이순신'}">
		이순신입니다.
	</c:when>
	<c:otherwise>
		유관순입니다.
	</c:otherwise>
</c:choose>
</body>
</html>