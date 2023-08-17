<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.dto.BoardDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<BoardDTO> list = (List<BoardDTO>)request.getAttribute("boardList");
%>
<table border=1>
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
<% 
	for(BoardDTO dto : list) {
		int num = dto.getNum();
		String title = dto.getTitle();
		String author = dto.getAuthor();
		String writeday = dto.getWriteday();
%>
	<tr>
		<td><%= num %></td>
		<td><%= title %></td>
		<td><%= author %></td>
		<td><%= writeday %></td>
		<td><%= dto.getReadcnt() %></td>
	</tr>
<% 
	}
%>

</table>

</body>
</html>