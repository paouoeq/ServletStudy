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
import com.service.OrderService;
import com.service.OrderServiceImpl;

@WebServlet("/OrderConfirmServlet")
public class OrderConfirmServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그인 여부 확인
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login"); // 세션에 login키값이 있는지 확인
		
		String nextPage = null;
		if(dto != null) { // 로그인 했음
			String num = request.getParameter("num");
			
			// num 값에 해당되는 CartDTO 얻기 - 주문정보를 얻기 위해
			OrderService service = new OrderServiceImpl();
			CartDTO cDTO = service.cartByNum(Integer.parseInt(num));
			
			// 주문자 정보
			String userid = dto.getUserid();
			// userid 값에 해당하는 MemberDTO 얻기 - 주문시 고객정보 필요
			MemberDTO mDTO = service.memberByUserid(userid);
			
			// scope에 저장
			request.setAttribute("cDTO", cDTO);
			request.setAttribute("mDTO", mDTO);
			
			// 요청위임
			nextPage = "orderConfirm.jsp";
		} else { // 로그인 안 했음 or time-out된 경우
			nextPage = "member/checkLogin.jsp";
		}
		
		// 요청
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

}
