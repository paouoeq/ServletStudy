package com.service;

import java.util.HashMap;
import java.util.List;

import com.dto.BoardDTO;
import com.dto.PageDTO;

public interface BoardService {
	
	//전체 목록
	public PageDTO list(HashMap<String, String> map, int curPage);
	//글 저장
	public int write(BoardDTO dto);
	//글 자세히보기 + 조회수 증가
	public BoardDTO retrieve(int num);
	//글 수정
	public int update(BoardDTO dto);
	//글 삭제
	public int delete(int num);
}
