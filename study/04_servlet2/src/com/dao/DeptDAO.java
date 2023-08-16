package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.DeptDTO;

public class DeptDAO {

	public List<DeptDTO> findAll(SqlSession session){
		List<DeptDTO> list = session.selectList("DeptMapper.findAll");
		return list;
	}
	
	public DeptDTO findByDeptno(SqlSession session,
			int deptno) {
		DeptDTO dto = 
				session.selectOne("DeptMapper.findByDeptno",
						deptno);
		return dto;
	}
	//DML
	public int  addDept(SqlSession session, DeptDTO dto) {
		int n = session.insert("DeptMapper.addDept", dto);
		return n;
	}
	
	public int updateDept(SqlSession session, 
			  HashMap<String, Object> map) {
		int n = session.update("DeptMapper.updateDept", map);
		return  n;
	}
	
	public int deleteDept(SqlSession session, 
			  int deptno) {
		int n = session.delete("DeptMapper.deleteDept", deptno);
		return  n;
	}
}





