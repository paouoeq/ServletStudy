package com.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.CartService;
import com.service.CartServiceImpl;

@WebServlet("/CartDeleteAllServlet")
public class CartDeleteAllServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 1번,7번,6번 선택했을 때
			?check=1
			&check=7
			&check=6
			=> url에 체크값이 들어감
		*/
		// 로그인 여부 확인
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login"); // 세션에 login키값이 있는지 확인
		
		String nextPage = null;
		if(dto != null) { // 로그인 했음
			String[] check = request.getParameterValues("check"); // 키(check)는 하나, value는 여러개(num값들)
			List<String> del_list = Arrays.asList(check);
			
			// 리스트를 dao까지 전달
			CartService service = new CartServiceImpl();
			int n = service.cartDeleteAll(del_list);
			
			nextPage = "CartListServlet";
		} else { // 로그인 안 했음 or time-out된 경우
			nextPage = "member/checkLogin.jsp";
		}
		
		// 요청
		response.sendRedirect(nextPage);
	}

}
