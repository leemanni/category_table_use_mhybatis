package com.leemanni.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.leemanni.dao.CategoryDAO;
import com.leemanni.mybatis.MySession;
import com.leemanni.vo.CategoryList;
import com.leemanni.vo.CategoryVO;

public class CategoryService {
	private static CategoryService instance = new CategoryService();
	private CategoryService() {;}
	public static CategoryService getInstance() {
		return instance;
	}
	
	// 메인 카테고리 => dao 로 토스
	public void insert(CategoryVO vo) {
		System.out.println("CategoryService ==> insert");
		SqlSession mapper = MySession.getSession();
		CategoryDAO.getInstance().insert(mapper, vo);
		mapper.commit();
		mapper.close();
	}
	
	
	/**
	 * @return CategoryList
	 * DB 에 저장된 카테고리들 요청 => DAO
	 */
	public CategoryList selectList() {
		System.out.println("CategoryService ==> selectList");
		SqlSession mapper = MySession.getSession();
		CategoryList categoryList = new CategoryList();
		categoryList.setList(CategoryDAO.getInstance().selectList(mapper));
		mapper.close();
		return categoryList;
	}
	
	/**
	 * @param vo
	 * 1. 서브 카테고리의 내용을 불러와서 lev, seq 를  1씩 증가시키고
	 *  해당 gup, seq 를 HashMap 로 저장시켜서 출력순서를 조정하는 dao 메소드 호출
	 *  
	 * 2. 서브 카테고리를 저장하는  dao 메소드 호출
	 */
	public void reply(CategoryVO vo) {
		System.out.println("CategoryService ==> reply");
		SqlSession mapper = MySession.getSession();
		CategoryDAO dao = CategoryDAO.getInstance();
		vo.setLev(vo.getLev()+1);
		vo.setSeq(vo.getSeq()+1);
		HashMap<String, Integer> hmap = new HashMap<>();
		hmap.put("gup", vo.getGup());
		hmap.put("seq", vo.getSeq());
		
		dao.increment(mapper, hmap);
		dao.reply(mapper, vo);
		
		mapper.commit();
		mapper.close();
	}
	
	/**
	 * @param idx
	 * @return CategoryVO
	 * 
	 * category 에서 삭제 또는 수정할 idx 얻어옴 해당 idx 를 기반으로
	 * DAO 에 데이터 요규하는 메소드
	 */
	public CategoryVO selectByIdx(int idx) {
		System.out.println("CategoryService ==> selectByIdx");
		SqlSession mapper = MySession.getSession();
		CategoryVO vo = CategoryDAO.getInstance().selectByIdx(mapper, idx);
		mapper.close();
		return vo;
	}
	
	/**
	 *  category 에서 삭제할 idx 얻어옴 해당 idx 를 기반으로 
	 *  DAO 에 삭제요청하는 메소드
	 */
	public void delete(int idx) {
		System.out.println("CategoryService ==> delete");
		SqlSession mapper = MySession.getSession();
		CategoryDAO.getInstance().delete(mapper, idx);
		mapper.commit();
		mapper.close();
	}
}






