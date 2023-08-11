package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.DeptService;
import com.service.DeptServiceImpl;

@WebServlet("/update")
public class DeptUpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String deptno = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		// HashMap 형식으로 서비스를 넘어가기 때문에 HashMap 생성
		HashMap<String, Object> map = new HashMap<>();
		map.put("deptno", deptno);
		map.put("dname", dname);
		map.put("loc", loc);
		
		DeptService service = new DeptServiceImpl();
		int n = service.updateDept(map);
		
		// 응답처리
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("<html><head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>Insert title here</title>");
		out.write("</head><body>");
		
		if(n==1) {
			out.write("부서 수정 성공<br>");
			out.write("<a href='list'>목록보기</a>"); // 부서 수정 성공하면 list화면으로 넘어가는 링크 생성
		} else {
			out.write("부서 수정 실패<br>");
			out.write("<a href='retrieve?deptno="+deptno+"'>부서등록</a>"); // 부서 수정 실패하면 다시 부서 정보 화면으로 넘어가는 링크 생성
		}
		
		out.write("</body></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//POST 한글처리 => 나중에 필터로 구현
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
