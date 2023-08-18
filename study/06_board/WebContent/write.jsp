<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="write" method="post">
제목 : <input type="text" name="title"><br>
작성자 : <input type="text" name="author"><br>
내용 : <textarea rows="10" cols="10" name="content"></textarea>
<input type="submit" value="저장">
</form>
</body>
</html>