package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.DeptDTO;
import com.service.DeptService;
import com.service.DeptServiceImpl;

@WebServlet("/retrieve")
public class DeptRetrieveServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptno = request.getParameter("deptno"); // DeptListServlet에서 쿼리스트링으로 받아온 deptno
		
		
		/* 서비스를 통해 쿼리스트링으로 받아와 저장한 deptno를 넘겨줌 
		 * -> 해당하는 번호의 정보가 DAO, service를 거쳐 다시 넘어옴
		 * -> 넘어온 데이터를 DTO로 저장
		 */
		DeptService service = new DeptServiceImpl(); // 서비스 연동
		DeptDTO dto = service.findByDeptno(Integer.parseInt(deptno)); 
		
		
		// 응답처리
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("<html><head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>Insert title here</title>");
		out.write("</head><body>");
		
		out.write("<h1>클릭한 데이터</h1>");
		
		out.write("<form action='update' mathod='get'>"); // 수정한 데이터를 submit하기위해 form태그로 감쌈, DeptUpdateServlet으로 넘김
		
		out.write("부서번호: "+dto.getDeptno()+"<br>");
		// 부서번호를 넘기기 위해 hidden태그 사용한다.
		out.write("<input type='hidden' name='deptno' value='"+dto.getDeptno()+"'>");
		
		// input태그를 통해 부서명을 수정할 수 있도록 만듦
		out.write("부서명: <input type='text' name='dname' value='"+dto.getDname()+"'><br>");

		// input태그를 통해 부서위치를 수정할 수 있도록 만듦
		out.write("부서위치: <input type='text' name='loc' value='"+dto.getLoc()+"'<br><br>");
		
		out.write("<input type='submit' value='수정'>");
		out.write("</form>");
		
		/*	삭제할 링크 생성 -> DeptDeleteServlet과 연결 -> deptno를 넘겨줘야하기 때문에 쿼리스트링으로 넘겨줌
		 * 	-> out.write("<a href='delete?deptno="+deptno+"'>삭제</a>");
		 */
		out.write("<hr>");
		out.write("<a href='delete?deptno="+deptno+"'>삭제</a>");
		
		out.write("</body></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//POST 한글처리 => 나중에 필터로 구현
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
