package com.dto;

import java.util.List;

public class PageDTO {
	
	// 4가지 정보(한 페이지에 보여줄 레코드 개수, 전체 레코드 개수, 현제 페이지 정보, List)
	List<BoardDTO> list; // 3개의 목록
	int perPage = 3; // 페이지당 보여줄 행 개수
	int totalCount; // 전체 레코드 개수
	int curPage; // 현재 페이지 번호
	
	// 검색을 위해 searchName, searchValue 저장
	String searchName;
	String searchValue;
	
	// getter/setter
	public List<BoardDTO> getList() {
		return list;
	}
	public void setList(List<BoardDTO> list) {
		this.list = list;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	
	
}
