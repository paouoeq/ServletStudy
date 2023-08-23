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

@WebServlet("/CartAddServlet")
public class CartAddServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 넘어온 url 값
		   ?gImage=top5
		   &gCode=T5
		   &gName=펀칭+스트라이프+레이어드+탑
		   &gPrice=11800&
		   gSize=L
		   &gColor=black
		   &gAmount=1
		 */
		
		// 장바구니를 사용하기 위해선 로그인 필요 => 로그인 체크
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login"); // 세션에 login키값이 있는지 확인
		
		String nextPage = null;
		if(dto != null) { // 로그인 했음
			String userid = dto.getUserid();
			String gCode = request.getParameter("gCode");
			String gName = request.getParameter("gName");
			String gPrice  = request.getParameter("gPrice");
			String gSize = request.getParameter("gSize");
			String gColor = request.getParameter("gColor");
			String gAmount = request.getParameter("gAmount");
			String gImage = request.getParameter("gImage");
			
			CartDTO cartDTO = new CartDTO();
			cartDTO.setUserid(userid);
			cartDTO.setgCode(gCode);
			cartDTO.setgName(gName);
			cartDTO.setgPrice(Integer.parseInt(gPrice));
			cartDTO.setgSize(gSize);
			cartDTO.setgColor(gColor);
			cartDTO.setgAmount(Integer.parseInt(gAmount));
			cartDTO.setgImage(gImage);
			
			// 서비스 거쳐 DAO 까지 전달, 반환
			CartService service = new CartServiceImpl();
			int n = service.cartAdd(cartDTO);
			
			nextPage="goods/cartAddSuccess.jsp";
			
		} else { // 로그인 안 했음 or time-out된 경우
			nextPage="member/checkLogin.jsp";
		}
		
		// 요청 위임
		response.sendRedirect(nextPage);
	}

}
