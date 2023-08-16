package com.service;

import java.util.HashMap;
import java.util.List;


import com.dto.DeptDTO;

public interface DeptService {
	public List<DeptDTO> findAll();
	public DeptDTO findByDeptno(int deptno);
	
	public int  addDept(DeptDTO dto);
	public int updateDept(HashMap<String, Object> map);
	public int deleteDept(int deptno);
}
