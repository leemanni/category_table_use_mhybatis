package com.leemanni.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.leemanni.vo.CategoryVO;

public class CategoryDAO {
	private static CategoryDAO instance = new CategoryDAO();
	private CategoryDAO() {
	}
	public static CategoryDAO getInstance() {
		return instance;
	}
	
	
	/**
	 * @param mapper
	 * @param vo => CategoryVO
	 * 
	 * service => dao 받은 걸  mapper 을 이용해서
	 * category.xml 로 보내서 insert sql 실행
	 */
	public void insert(SqlSession mapper, CategoryVO vo) {
		System.out.println("CategoryDAO ==> insert");
		mapper.insert("insert", vo);
	}
	/**
	 * @param mapper
	 * @return CategoryList
	 * DB 에 저장된  category 들 select sql 실행
	 * 
	 */
	public ArrayList<CategoryVO> selectList(SqlSession mapper) {
		System.out.println("CategoryDAO ==> selectList");
		return (ArrayList<CategoryVO>) mapper.selectList("selectList");
	}
	
	
	/**
	 * @param mapper
	 * @param hmap
	 * 서브 카테고리의 출력 순서를 조정
	 * 최신글의 seq 가  1이 되도록  update sql 을 실행
	 */
	public void increment(SqlSession mapper, HashMap<String, Integer> hmap) {
		System.out.println("CategoryDAO ==> increment");
		mapper.update("increment" , hmap);
	}
	
	
	/**
	 * @param mapper
	 * @param vo
	 * 출력 순서가 조정된 뒤 저장
	 */
	public void reply(SqlSession mapper, CategoryVO vo) {
		System.out.println("CategoryDAO ==> reply");
		mapper.insert("reply", vo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
