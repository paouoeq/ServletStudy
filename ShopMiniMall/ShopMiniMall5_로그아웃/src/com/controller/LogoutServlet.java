package com.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그인 여부 확인 - 로그인이 되어있어야 로그아웃 가능
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		
		String nextPage = null;
		if(dto != null) { // 로그인 O
			nextPage = "main";
			session.invalidate(); // session 키값 즉시 삭제 => 로그아웃에 사용
		} else { // 로그인 X
			nextPage = "member/checkLogin.jsp"; // 로그인이 필요한 작업임을 알려주는 화면
		}
		
		
		response.sendRedirect(nextPage); // 로그인 여부에 따라 보여주는 화면이 다름 => nextPage 활용
	}

}
