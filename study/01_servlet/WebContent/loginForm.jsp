<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> GET-로그인화면 </h2>
<form action="login" method="get"> <!-- get방식: http://localhost:8090/01_servlet/login?userid=aaa&passwd=1234 -->
아이디 : <input type="text" name="userid"><br>
비번 : <input type="text" name="passwd"><br>
<input type="submit" value="로그인">
</form>

<h2> POST-로그인화면 </h2>
<form action="login" method="post"> <!-- get방식: http://localhost:8090/01_servlet/login?userid=aaa&passwd=1234 -->
아이디 : <input type="text" name="userid"><br>
비번 : <input type="text" name="passwd"><br>
<input type="submit" value="로그인">
</form>
</body>
</html>