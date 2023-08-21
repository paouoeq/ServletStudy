package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.PageDTO;
import com.service.BoardService;
import com.service.BoardServiceImpl;

@WebServlet("/list")
public class BoardListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String curPage = request.getParameter("curPage");
		if(curPage == null) { // 맨 처음 요청시 curPage는 null
			curPage = "1";
		}
		
		BoardService service = new BoardServiceImpl();
		PageDTO pageDTO = service.list(Integer.parseInt(curPage));
		
		// scope에 저장
		request.setAttribute("pageDTO", pageDTO);
		
		// 요청위임(forward)
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
