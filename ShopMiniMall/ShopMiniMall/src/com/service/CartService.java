package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;

public interface CartService {
	public int cartAdd(CartDTO dto);
	public List<CartDTO> cartList(String userid);
}
