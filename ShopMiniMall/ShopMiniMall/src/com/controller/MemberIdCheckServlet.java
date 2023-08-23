package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MemberDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;

@WebServlet("/MemberIdCheckServlet")
public class MemberIdCheckServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Ajex => 화면 필요 X => 요청위임하지 않음
		// 해당 서블릿은 memberForm.jsp에서 아이디 입력할 때 요청
		// id 중복 여부 확인할 것
		
		String userid = request.getParameter("userid"); // memberForm에서 userid값이 넘어옴
		
		MemberService service = new MemberServiceImpl();
		MemberDTO dto = service.idCheck(userid); // id 중복체크
		
		String mesg = "아이디 사용 가능";
		if(dto != null) { // null이 아님 => dto 존재 => 동일한 아이디 있음
			mesg = "아이디 중복";
		}
		
		// 응답처리
		response.setContentType("text/plain;charset=utf-8"); // html이 아닌 글자로 응답처리함
		PrintWriter out = response.getWriter();
		out.print(mesg); // 요청한 곳으로 이제 메세지를 건내줌(중복이다/아니다)
		
	}

}
