<%@page import="com.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.dto.PageDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시판 목록</h2>
<%
	PageDTO pageDTO = (PageDTO)request.getAttribute("pageDTO");
	
	// 게시판 목록 3개
	List<BoardDTO> list = pageDTO.getList();
	
	// 페이지 번호를 만들 정보
	int perPage = pageDTO.getPerPage(); // 페이지 번호 만들 정보
	int curPage = pageDTO.getCurPage(); // 현재 페이지 정보
	int totalCount = pageDTO.getTotalCount(); // 전체 레코드 개수

	int totalNum = totalCount / perPage;
	if( totalCount % perPage != 0 ) totalNum++;
%>

<%
	// 목록 보여주기
	for(BoardDTO dto : list) {
		int num = dto.getNum();
		String title = dto.getTitle();
%>
	<%= num %>, <%= title %><br>
<%
	} // end for
%>
<hr>
<%
	// 페이지 번호 보여주기
	for(int i=1; i<=totalNum; i++) {
		if(curPage == i) { // 현재페이지일때
%>
		<%= i %>
		<% } else { %>
		<a href="list?curPage=<%= i %>"><%= i %></a>
<%		
		}
	} // end for
%>


</body>
</html>