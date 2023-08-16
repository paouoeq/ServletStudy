package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.DeptDAO;
import com.dto.DeptDTO;

public class DeptServiceImpl implements DeptService {
	
	@Override
	public List<DeptDTO> findAll() {
		List<DeptDTO> list = null;
		// SqlSession 얻기
		
		SqlSession session = 
				MySqlSessionFactory.getSession();
		try {
		//////////////////////////
        // DAO 연동		
		DeptDAO dao = new DeptDAO();
		list = dao.findAll(session);
		//////////////////////////
		}finally {
		  session.close();
		}
		return list;
	}
	@Override
	public DeptDTO findByDeptno(int deptno) {
		DeptDTO dto = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
		  //DAO 연동코드
		  DeptDAO dao = new DeptDAO();
		  dto = dao.findByDeptno(session, deptno);
		}finally {
			session.close();
		}
		
		return dto;
	}
	@Override
	public int addDept(DeptDTO dto) {
		 int n = 0;
		 SqlSession session = MySqlSessionFactory.getSession();
			try {
			// DAO 연동
			  DeptDAO dao = new DeptDAO();
			  n = dao.addDept(session, dto);
			  session.commit(); // 명시적 commit
			}finally {
				session.close();
			}
		
		return n;
	}
	@Override
	public int updateDept(HashMap<String, Object> map) {
		int n = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			//DAO 연동
			DeptDAO dao = new DeptDAO();
			n = dao.updateDept(session, map);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}
	@Override
	public int deleteDept(int deptno) {
		int n = 0;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
			//DAO 연동
			DeptDAO dao = new DeptDAO();
			n = dao.deleteDept(session, deptno);
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}
	
	/*
	  SqlSession session = sqlSessionFactory.openSession();
		try {
			
			
		}finally {
			session.close();
		}
	*/
}





