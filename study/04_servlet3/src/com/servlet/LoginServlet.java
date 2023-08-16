package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		
		// ~ DB연동해서 아이디 비밀번호가 맞다고 가정(confirm) - 인증완료 ~
		
		HttpSession session = request.getSession(); // 세션얻기
		System.out.println("세션의 id값 : "+session.getId());
		
		// 세션에 로그인 정보 저장 - 여러 자원들에서 공유하고자 하는 데이터
		session.setAttribute("user", userid);
		
		// 로그인 이후 응답 처리
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("<html><head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>Insert title here</title>");
		out.write("</head><body>");
		
		out.write("<h1>로그인 성공</h1>");
		out.write("안녕하세요. "+userid+"님<br>");
		out.write("<a href='mypage'>mypage</a>");
		
		out.write("</body></html>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
