package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.DeptDTO;
import com.service.DeptService;
import com.service.DeptServiceImpl;

// Dept 목록을 보여줌
// 현재 : http://localhost:8090/03_servlet/write
// 타겟1(성공시) : http://localhost:8090/03_servlet/write
// 타겟2(실패시) : http://localhost:8090/03_servlet/deptForm.jsp
@WebServlet("/write")
public class DeptWriteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String deptno = request.getParameter("deptno"); // ** getParameter의 리턴타입은 무조건 String **
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		// DeptDTO로 저장
		DeptDTO dto = new DeptDTO(Integer.parseInt(deptno), dname, loc);
		// 서비스 연동
		DeptService service = new DeptServiceImpl();
		int n = service.addDept(dto);
		
		
		////////////////////// 요청위임 사용하여 바로 페이지 이동하기 //////////////////////
		if(n==1) { // 부서 등록 성공 -> 바로 페이지 이동(DeptListServlet으로)
			response.sendRedirect("list"); // DeptListServlet으로 요청위임
		} else { // 부서 등록 실패 -> 바로 페이지 이동(deptForm.jsp으로)
			response.sendRedirect("deptForm.jsp"); // deptForm.jsp으로 요청위임
		}
		//////////////////////////////////////////////////////////////////////
		
		
		// 응답처리
//		response.setContentType("text/html; charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.write("<html><head>");
//		out.print("<meta charset=\"UTF-8\">");
//		out.print("<title>Insert title here</title>");
//		out.write("</head><body>");
//		
//		if(n==1) {
//			out.write("부서 등록 성공<br>");
//			out.write("<a href='list'>목록보기</a>"); // 부서 등록 성공하면 list화면으로 넘어가는 링크 생성
//		} else {
//			out.write("부서 등록 실패<br>");
//			out.write("<a href='deptForm.jsp'>다시시도</a>"); // // 부서 등록 실패하면 다시 등록 화면으로 넘어가는 링크 생성
//		}
//		
//		out.write("</body></html>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//POST 한글처리 => 나중에 필터로 구현
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
