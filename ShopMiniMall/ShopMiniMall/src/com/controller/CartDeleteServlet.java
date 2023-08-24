package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.service.CartService;
import com.service.CartServiceImpl;

@WebServlet("/CartDeleteServlet")
public class CartDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 여부 확인
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login"); // 세션에 login키값이 있는지 확인
		
		String nextPage = null;
		if(dto != null) { // 로그인 했음
			String num = request.getParameter("num");
			
			// num값을 서비스 거쳐서 DAO에 전달
			CartService service = new CartServiceImpl();
			int n = service.cartDelete(Integer.parseInt(num));
			
			nextPage = "CartListServlet";
		} else { // 로그인 안 했음 or time-out된 경우
			nextPage = "member/heckLogin.jsp";
		}
		
		// 요청
		response.sendRedirect(nextPage); 
	}

}
