package com.leemanni.vo;

import java.util.ArrayList;


/**
 * @author cjffy
 * 전체 카테고리를 저장하는 리스트 클래스
 */
public class CategoryList {
	private ArrayList<CategoryVO> list = new ArrayList<>();

	public ArrayList<CategoryVO> getList() {
		return list;
	}

	public void setList(ArrayList<CategoryVO> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "CategoryList [list=" + list + "]";
	}
	
}
