package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.GoodsDTO;
import com.service.GoodsService;
import com.service.GoodsServiceImpl;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 상품목록
		String gCategory = request.getParameter("gCategory"); // 카테고리 누르면 돌아오는 값을 받음
		if(gCategory == null) { // 메인을 처음 요청하면 gCategory가 null 값
			gCategory = "top"; // 처음 메인화면에 보여줄 카테고리 설정
			
		}
		
		GoodsService service = new GoodsServiceImpl();
		List<GoodsDTO> list = service.goodsList(gCategory);
		
		// scope에 저장
		request.setAttribute("goodsList", list);
		
		// 요청위임-포워드
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
