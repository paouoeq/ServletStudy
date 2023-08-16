package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 쿠키얻기
		Cookie[] cookies = request.getCookies();
		
		String id = null;
		Cookie xxx = null;
		for(Cookie c : cookies) {
			if("user".equals(c.getName())) { // key값이 user라면
				id = c.getValue();
				xxx = c;
			}
		}
		
		if(id!=null) {
			// 로그인을 한 경우 -> 응답처리
			xxx.setMaxAge(0); // 쿠키 삭제
			response.addCookie(xxx); // 서버에 삭제됐다고 보냄
			response.sendRedirect("LoginForm.jsp");
		} else { // id값이 null => 로그인을 안 한 경우 or 로그인 했지만 타임아웃 된 상황
			response.sendRedirect("LoginForm.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
