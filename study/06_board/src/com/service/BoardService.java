package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;

public interface BoardService {
	
	//전체 목록
	public List<BoardDTO> list(HashMap<String, String> map);
	//글 저장
	public int write(BoardDTO dto);
	//글 자세히보기 + 조회수 증가
	public BoardDTO retrieve(int num);
	//글 수정
	public int update(BoardDTO dto);
	//글 삭제
	public int delete(int num);
}
