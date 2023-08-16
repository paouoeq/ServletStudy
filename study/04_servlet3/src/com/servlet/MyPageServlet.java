package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mypage")
public class MyPageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 세션얻기
		HttpSession session = request.getSession();
		
		// 세션에 로그인 정보 얻기
		String id = (String)session.getAttribute("user");
		
		if(id!=null) {
			// 로그인을 한 경우 -> 응답처리
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<html><head>");
			out.print("<meta charset=\"UTF-8\">");
			out.print("<title>Insert title here</title>");
			out.print("</head><body>");
			
			out.print("<h1>mypage</h1>");
			out.print("안녕하세요. "+id+"님<br>");
			out.print("<a href='logout'>로그아웃</a>");
			
			out.write("</body></html>");
		} else { // id값이 null => 로그인을 안 한 경우 or 로그인 했지만 타임아웃 된 상황
			response.sendRedirect("LoginForm.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
