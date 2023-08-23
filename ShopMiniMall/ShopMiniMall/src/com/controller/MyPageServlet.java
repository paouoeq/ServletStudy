package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;

@WebServlet("/MyPageServlet")
public class MyPageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		// 로그인 여부 확인 필요
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login"); // 세션에 login키값이 있는지 확인
		
		String nextPage = null;
		if(dto != null) { // 로그인 했음
			nextPage = "mypage.jsp";
			/* 
			 * 현재는 세션에 멤버dto를 저장했지만, 사실 세션에 일부 정보만 저장하는 경우도 있음 
			 * => 그렇다면 필요한 정보들은 세션이 아닌 DB에 있기 때문에 DB에서 가져오는 작업이 필요하다.
			 */
			String userid = dto.getUserid(); // id값 받기 => 이를 이용해서 DB에서 정보 불러옴
			
			// userid를 서비스 거쳐서 DAO에 전달 => id에 해당되는 정보들을 보여주도록 만듦
			MemberService service = new MemberServiceImpl();
			MemberDTO mypage = service.mypage(userid);
			session.setAttribute("login", mypage); // 로그인 키값에 정보 저장
			
		} else { // 로그인 안 했음 or time-out된 경우
			nextPage = "member/checkLogin.jsp";
		}
		
		
		// 요청 위임
		response.sendRedirect(nextPage); // 정보들은 session에 저장되었기 때문에 리다이렉트 사용(넘겨줄 request 데이터가 없음)
		
	}

}
