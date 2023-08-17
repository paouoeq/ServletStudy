package com.service;

import java.util.List;

import com.dto.BoardDTO;

public interface BoardService {
	
	//전체 목록
	public List<BoardDTO> list();
}
