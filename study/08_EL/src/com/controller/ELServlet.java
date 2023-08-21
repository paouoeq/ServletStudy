package com.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.LoginDTO;

@WebServlet("/ELServlet")
public class ELServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// scope에 저장
		request.setAttribute("userid", "홍길동"); // DB에 접근해서 "홍길동" 값을 가져왔다는 가정
		
		HttpSession session = request.getSession();
		session.setAttribute("userid", "이순신");
		
		ServletContext application = getServletContext();
		application.setAttribute("userid", "유관순");
		
		// DTO 생성 후 scope에 저장
		LoginDTO dto = new LoginDTO("asdf","1234");
		request.setAttribute("login", dto);
		
		// list 생성 후 scope에 저장
		List<LoginDTO> list = Arrays.asList(new LoginDTO("asdf1", "1234"),
											new LoginDTO("asdf2", "5678"));
		request.setAttribute("list", list);
				
		
		// 요청위임
		request.getRequestDispatcher("el2.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
