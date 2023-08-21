<%@page import="com.dto.PageDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- CDM 방식으로 jquery 추가 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		// button에 대한 이벤트
		$("button").on("click", function(){
			var num = $(this).attr("data-num"); // this = button
			alert("button"+num);
			location.href="delete?num="+num; // 지정된 곳으로 넘어가기 위한 코드
			
		});
		
	});
</script>

</head>
<body>
<h2>게시판 목록보기</h2>
<!-- JSTL 적용 : 변수 -->
<c:set var="pageDTO" value="${PageDTO}"/>
<c:set var="list" value="${pageDTO.list}"/>

<table border=1>

	<!-- 검색화면 -->
	<tr>
		<td colspan="6">
			<form action="list">
				<select name="searchName">
					<option value="title">제목</option>
					<option value="author">작성자</option>
				</select>
				<input type="text" name="searchValue">
				<input type="submit" value="검색">
			</form>
		</td>
	</tr>
	<!-- 검색화면 -->
	
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
		<th>삭제</th>
	</tr>
	<!-- JSTL 적용 : list 반복문 -->
	<c:forEach var="dto" items="${list}">
		<tr>
			<td>${dto.num}</td>
			<td><a href="retrieve?num=${dto.num}">${dto.title}</a></td>
			<td>${dto.author}</td>
			<td>${dto.writeday}</td>
			<td>${dto.readcnt}</td>
			<td><button data-num="${dto.num}">삭제</button></td>
		</tr>
	</c:forEach>

	<!-- page 번호 출력 -->
	<!-- JSTL 적용 -->
	<c:set var="perPage" value="${pageDTO.perPage}"/>
	<c:set var="curPage" value="${pageDTO.curPage}"/>
	<c:set var="totalCount" value="${pageDTO.totalCount}"/>
	<c:set var="totalNum" value="${totalCount / perPage}" />
	
	<c:if test="${totalCount % perPage != 0}">
		<c:set var="totalNum" value="${totalNum+1}" />
	</c:if>
	
	<c:set var="searchName" value="${pageDTO.searchName}" />
	<c:set var="searchValue" value="${pageDTO.searchValue}" />
	
	<tr>
		<td colspan="6">
			<c:forEach var="i" begin="1" end="${totalNum}">
				<c:if test="${curPage == i}">
					${i}
				</c:if>
				<c:if test="${curPage != i}">
					<a href=" <c:url value='list?curPage=${i}&searchName=${searchName}&searchValue=${searchValue}'/> "> ${i} </a>
				</c:if>
			</c:forEach>
		</td>
	</tr>
</table>
<a href="writeui">글쓰기</a>
</body>
</html>