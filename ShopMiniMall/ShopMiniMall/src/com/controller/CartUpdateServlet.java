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
import com.service.CartService;
import com.service.CartServiceImpl;

@WebServlet("/CartUpdateServlet")
public class CartUpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그인 여부 확인
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login"); // 세션에 login키값이 있는지 확인
		
		if(dto != null) { // 로그인 했음
			String num = request.getParameter("num");
			String gAmount = request.getParameter("gAmount");
			
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("num", Integer.parseInt(num));
			map.put("gAmount", Integer.parseInt(gAmount));
			
			// 두 데이터(num, gAmount => map)를 서비스 거쳐 DAO까지 전달
			CartService service = new CartServiceImpl();
			int n = service.cartUpdate(map);
			
			// ajax이기 때문에 화면이 필요 없음 => 응답할 필요 X 그냥 update만 적용시켜주면 됨
			// ajax 성공시 그냥 ajax의(cartList.jsp에 있는) success 활성화
			
		} else { // 로그인 안 했음 or time-out된 경우
			response.sendRedirect("member/checkLogin.jsp"); 
		}
		
		
		
		
		
	}

}
