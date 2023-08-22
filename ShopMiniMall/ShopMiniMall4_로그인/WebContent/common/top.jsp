<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- top.jsp -->
<%
	MemberDTO dto = (MemberDTO)session.getAttribute("login");

	if(dto == null) {// 로그인이 안 된 상황
%>
<a href="LoginUIServlet">로그인</a>
<a href="MemberUIServlet">회원가입</a>
<%
	} else {
%>
안녕하세요.<%= dto.getUsername() %>
<a href="">로그아웃</a>
<a href="">마이페이지</a>
<a href="">장바구니목록</a>
<%
	}
%>