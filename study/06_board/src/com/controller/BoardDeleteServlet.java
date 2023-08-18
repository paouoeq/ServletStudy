package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.BoardService;
import com.service.BoardServiceImpl;

@WebServlet("/delete")
public class BoardDeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		// jsp에서 num값을 받아옴 : location.href="delete?num="+num;
		String num = request.getParameter("num");
		
		// 서비스 연동
		BoardService service = new BoardServiceImpl();
		int n = service.delete(Integer.parseInt(num));
		
		// 요청 위임
		response.sendRedirect("list");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
