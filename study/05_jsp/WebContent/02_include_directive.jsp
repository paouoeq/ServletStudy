<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>02_include_directive.jsp</h2>
<hr>
<%@ include file="common/top.jsp" %>
<hr>
<jsp:include page="common/top2.jsp" flush="true"/>
</body>
</html>