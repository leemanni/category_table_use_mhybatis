package com.leemanni.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.leemanni.dao.CategoryDAO;
import com.leemanni.mybatis.MySession;
import com.leemanni.vo.CategoryList;
import com.leemanni.vo.CategoryVO;

/**
 * @author cjffy
 * List, reply 등 jsp 에서 호출한 메소드 모아둔 클래스
 * DAO 와 연결시켜 주어서 DB 와 관련된 사항을 관제
 */
/**
 * @author cjffy
 *
 */
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
	
	/**
	 * @param idx
	 * idx 를 인수로 받아서 해당 인덱스를 화면성 삭제하는 것처럼 
	 * 하지만 '삭제된 게시글 입니다.' 라는 멘드만으로 삭제되었음을 표시해두기
	 * for DAO 에 요청
	 */
	public void deleteRemain(int idx) {
		System.out.println("CategoryService ==> deleteRemain");
		SqlSession mapper = MySession.getSession();
		CategoryDAO.getInstance().deleteRemain(mapper, idx);
		mapper.commit();
		mapper.close();
	}
	
	/**
	 * @param idx
	 * 삭제될 해당 idx 글을 삭제했음을 표시함 => view 에 여향을 미침 
	 */
	public void deleteCheck(int idx) {
		System.out.println("CategoryService ==> deleteCheck");
		SqlSession mapper = MySession.getSession();
		CategoryDAO.getInstance().deleteCheck(mapper, idx);
		mapper.commit();
		mapper.close();
	}
	
	
	/**
	 * @param idx
	 *삭제 복구
	 *deleteCheck => yes -> no 로 변경
	 */
	public void deleteRestore(int idx) {
		System.out.println("CategoryService ==> deleteRestore");
		SqlSession mapper = MySession.getSession();
		CategoryDAO.getInstance().deleteRestore(mapper, idx);
		mapper.commit();
		mapper.close();
	}
	
	/**
	 * @param idx
	 * 신고 당한 카테고리의 신고 획수를 증가시켜주는 결과가 나도록
	 * DAO에 메소드를 호출하는 메소드
	 * 
	 */
	public void deleteReport(int idx) {
		System.out.println("CategoryService ==> deleteReport");
		SqlSession mapper = MySession.getSession();
		CategoryDAO.getInstance().deleteReport(mapper, idx);
		mapper.commit();
		mapper.close();
	}
	
	/**
	 * @param vo
	 * 카테고리 내용을 수정을 DAO 에 요청하는 메소드
	 */
	public void update(CategoryVO vo) {
		System.out.println("CategoryService ==> update");
		SqlSession mapper = MySession.getSession();
		CategoryDAO.getInstance().update(mapper, vo);
		mapper.commit();
		mapper.close();
	}
	
	/**
	 * @param vo
	 * 삭제할 카테고리의 하위 카테거고리 까지 지우기 위해 같은 lev 의 카테고리 들을 DAO 에 요청하는 메소드
	 */
	public ArrayList<CategoryVO> getDeleteList(CategoryVO vo) {
		System.out.println("CategoryService ==> getDeleteList");
		SqlSession mapper = MySession.getSession();
		ArrayList<CategoryVO> deleteList = CategoryDAO.getInstance().getDeleteList(mapper , vo);
		mapper.close();
		return deleteList;
	}
	
	/**
	 * @param gup
	 * 해당 그룹의 req 를 비는 순서 없이 초기화 해주기 위해 DAO 에 요청하는 메소드
	 */
	public void resetReq(int gup) {
		System.out.println("CategoryService ==> resetReq");
		SqlSession mapper = MySession.getSession();
		CategoryDAO dao = CategoryDAO.getInstance();
		
		ArrayList<CategoryVO> gupList = dao.getGupList(mapper, gup);
		
		for (int i = 0; i < gupList.size(); i++) {
			HashMap<String, Integer> hmap = new HashMap<>();
			hmap.put("idx", gupList.get(i).getIdx());
			hmap.put("seq", i);
			dao.updateReq(mapper, hmap);
		}
		
		mapper.commit();
		mapper.close();
	}
	
	
}






