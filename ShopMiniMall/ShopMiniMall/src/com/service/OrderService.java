package com.service;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;
import com.dto.MemberDTO;

public interface OrderService {
	
	public CartDTO cartByNum(int num);
	public MemberDTO memberByUserid(String userid);
	
}
