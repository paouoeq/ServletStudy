<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
  int num = 0; // 변수 가능
  //public void a(){} // 메소드는 불가능
  if(num==0) {
	  System.out.println("num==0");
  }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
  int num2 = 10;
  for(int i=0; i<5; i++) {
	  System.out.println("hello");
  }
%>

</body>
</html>