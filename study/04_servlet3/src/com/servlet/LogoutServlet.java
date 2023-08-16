package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 세션얻기
		HttpSession session = request.getSession();
		
		// 세션에 로그인 정보 얻기
		String id = (String)session.getAttribute("user");
		
		if(id!=null) {
			// 로그인을 한 경우 -> 응답처리
			session.invalidate(); // 데이터 삭제
			// 로그아웃 이후의 화면 선택
			response.sendRedirect("LoginForm.jsp");
		} else { // id값이 null => 로그인을 안 한 경우 or 로그인 했지만 타임아웃 된 상황
			response.sendRedirect("LoginForm.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
