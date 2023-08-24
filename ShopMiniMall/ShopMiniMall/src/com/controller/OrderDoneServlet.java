package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.dto.OrderDTO;
import com.service.OrderService;
import com.service.OrderServiceImpl;

@WebServlet("/OrderDoneServlet")
public class OrderDoneServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*url로 넘어오는 정보
		  ?same_address=on
		  &orderName=홍길동
		  &post=06035
		  &addr1=서울+강남구+가로수길+5+%28신사동%29
		  &addr2=12
		  &phone=01012341234
		  &payMethod=신용카드
		  
		  [ 들여쓰기 한 것들이 url로 얻을 수 있는 정보 => 배송지 정보] - 이들을 제외하고는 추가로 작성해줘야 한다.(input type="hidden" 사용)
		 */
		
		// 로그인 여부 확인
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login"); // 세션에 login키값이 있는지 확인
		
		String nextPage = null;
		if(dto != null) { // 로그인 했음
			// ID
			String userid = dto.getUserid();
			// 상품정보
			String gCode = request.getParameter("gCode");
			String gName = request.getParameter("gName");
			String gPrice = request.getParameter("gPrice");
			String gSize = request.getParameter("gSize");
			String gColor = request.getParameter("gColor");
			String gAmount = request.getParameter("gAmount");
			String gImage = request.getParameter("gImage");
			// 배송정보
			String orderName = request.getParameter("orderName");
			String post = request.getParameter("post");
			String addr1 = request.getParameter("addr1");
			String addr2 = request.getParameter("addr2");
			String phone = request.getParameter("phone");
			String payMethod = request.getParameter("payMethod");
			
			// Cart 테이블에서 삭제할 num 얻기
			String del_num = request.getParameter("num");
			
			
			// DTO에 저장
			OrderDTO orderDTO = new OrderDTO();
			
			orderDTO.setUserid(userid);
			
			orderDTO.setgCode(gCode);
			orderDTO.setgName(gName);
			orderDTO.setgPrice(Integer.parseInt(gPrice));
			orderDTO.setgSize(gSize);
			orderDTO.setgColor(gColor);
			orderDTO.setgAmount(Integer.parseInt(gAmount));
			orderDTO.setgImage(gImage);
			
			orderDTO.setOrderName(orderName);
			orderDTO.setPost(post);
			orderDTO.setAddr1(addr1);
			orderDTO.setAddr2(addr2);
			orderDTO.setPhone(phone);
			orderDTO.setPayMethod(payMethod);
			
			
			// orderDTO 값을 서비스 거쳐서 DAO에 전달
			OrderService service = new OrderServiceImpl();
			int n = service.orderDone(orderDTO, Integer.parseInt(del_num)); // insert&delete
			
			
			// scope에 저장(orderDone에서 주문 정보를 보여줘야 하기 때문)
			request.setAttribute("orderDTO", orderDTO);
			
			
			nextPage = "orderDone.jsp";
		} else { // 로그인 안 했음 or time-out된 경우
			nextPage = "member/checkLogin.jsp";
		}
		
		// 요청
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

}
