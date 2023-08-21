package com.controller;

import java.io.IOException;
import java.util.HashMap;

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
		
		// list.jsp에서 1,2,3,4 페이지 번호를 클릭할 때 전달된 현재 페이지 번호 얻기
		// <a herf="list?curPage=2">2</a> 와같이 쿼리스트링으로 현재 페이지 번호 받음
		String curPage = request.getParameter("curPage"); // DAO까지 넘겨줘야 함
		
		if(curPage == null) { // 맨 처음 실행한 경우
			curPage = "1";
		}
		// 검색 파라미터 얻기
		String searchName = request.getParameter("searchName");
		String searchValue = request.getParameter("searchValue");
		
		// 2개의 값을 서비스 거쳐서 DAO에 전달
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("searchName", searchName);
		map.put("searchValue", searchValue);
		
		// BoardService 연동
		BoardService service = new BoardServiceImpl();
		PageDTO pageDTO = service.list(map, Integer.parseInt(curPage));
		
		/* 이전에는 서블릿에서 응답처리를 했지만, 이제는 list.jsp에 요청위임 할 것
		   list.jsp에서 List<BoardDTO> 보여주기 위해 scope에 저장해야 된다. 
		   => request scope가 적당(보여주고 없어지면 되니까)*/
		request.setAttribute("PageDTO", pageDTO);
		
		// 요청위임 : 데이터를 request로 넘겨주기 때문에 포워드방식 사용
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
