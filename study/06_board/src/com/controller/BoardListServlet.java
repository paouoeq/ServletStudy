package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.BoardDTO;
import com.service.BoardService;
import com.service.BoardServiceImpl;

@WebServlet("/list")
public class BoardListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		// 검색 파라미터 얻기
		String searchName = request.getParameter("searchName");
		String searchValue = request.getParameter("searchValue");
		
		// 2개의 값을 서비스 거쳐서 DAO에 전달
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("searchName", searchName);
		map.put("searchValue", searchValue);
		
		// BoardService 연동
		BoardService service = new BoardServiceImpl();
		List<BoardDTO> list = service.list(map);
		
		// 이전에는 서블릿에서 응답처리를 했지만, 이제는 list.jsp에 요청위임 할 것
		// list.jsp에서 List<BoardDTO> 보여주기 위해 scope에 저장해야 된다. 
		// => request scope가 적당(보여주고 없어지면 되니까)
		request.setAttribute("boardList", list);
		
		// 요청위임 : 데이터를 request로 넘겨주기 때문에 포워드방식 사용
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
