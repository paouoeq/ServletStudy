<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원등록화면</h2>
<form action="member" method="get">
  아이디: <input type="text" name="userid"><br>
  비번: <input type="text" name="passwd"><br>
  취미<br>
  축구:<input type="checkbox" name="hobby" value="football"><br>
  야구:<input type="checkbox" name="hobby" value="baseball"><br>
  농구:<input type="checkbox" name="hobby" value="basketball"><br>
  
 <input type="submit" value="회원등록">
</form>
</body>
</html>