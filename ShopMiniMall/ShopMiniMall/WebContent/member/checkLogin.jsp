<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- member/checkLogin.jsp -->
<!-- 로그인이 필요한 작업임을 알려줄 때 -->
<script>
	alert("로그인이 필요한 요청입니다. 로그인 후 다시 요청하세요.");
	location.href="LoginUIServlet" // 상대경로 -> 부모 디렉토리로 이동하려면 .. 이용 // url에 해당하는 곳으로 이동
</script>