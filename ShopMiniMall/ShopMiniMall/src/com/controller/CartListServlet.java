package com.controller;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/CartListServlet")
public class CartListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// top.jsp에서 장바구니 목록 호출
		// 로그인 여부 필요
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login"); // 세션에 login키값이 있는지 확인
		String nextPage = null;
		if(dto != null) { // 로그인 했음
			
			String userid = dto.getUserid(); // login키에 저장된 userid값 받아옴
			// userid 값을 서비스 거쳐서 DAO 전달하고 반환
			CartService service = new CartServiceImpl();
			List<CartDTO> list = service.cartList(userid);
			
			// jsp에 보여주기 위해 scope에 저장
			request.setAttribute("cartList", list);
			
			nextPage="cartList.jsp";
		} else { // 로그인 안 했음 or time-out된 경우
			nextPage="member/checkLogin.jsp";
		}
		
		// 요청위임
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

}
