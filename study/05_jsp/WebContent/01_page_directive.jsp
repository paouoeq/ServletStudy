<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %> <%-- page directive --%>
<%@ page import="java.util.ArrayList" %> <%-- 위치는 어디에 만들어도 상관없다. --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 주석이 필요하면 자바 주석을 사용한다.
	ArrayList list = new ArrayList(); // import없이는 에러 발생
	Date d= new Date(); // ctrl + space로 자동 import
	String n = ""; // import 필요 없는 것들은 에러 발생 X
%>
</body>
</html>