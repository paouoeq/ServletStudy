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
<h2>set 태그</h2>
<c:set var="xxx" value="${ userid }"/>
이름:${userid}<br>
이름:${xxx}<br>
이름:<c:out value="${userid}"/><br>
</body>
</html>