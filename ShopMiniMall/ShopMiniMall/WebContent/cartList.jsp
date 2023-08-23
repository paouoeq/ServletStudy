<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니목록</title>
</head>
<body>
<jsp:include page="common/top.jsp" flush="true" /><br>
<jsp:include page="common/menu.jsp" flush="true" />
<hr>
<h1> - 장바구니 -</h1>
<hr>
<jsp:include page="goods/cartList.jsp" flush="true" />
</body>
</html>