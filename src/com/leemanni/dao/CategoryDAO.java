package com.leemanni.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.leemanni.vo.CategoryVO;

/**
 * @author leemanni
 *	Category DAO Class
 */
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
	 * 반드시 increment() 메소드가 실행된 뒤 실행되어져야 함.
	 * 출력 순서가 조정된 뒤 저장
	 */
	public void reply(SqlSession mapper, CategoryVO vo) {
		System.out.println("CategoryDAO ==> reply");
		mapper.insert("reply", vo);
	}
	
	/**
	 * @param mapper
	 * @param idx
	 * @return CategoryVO
	 * 삭제 또는 수정할 대상의 카테고리의 정보를 selete sql 로 데려와서 VO 타입으로 리턴 해주는 메소드
	 */
	public CategoryVO selectByIdx(SqlSession mapper, int idx) {
		System.out.println("CategoryDAO ==> selectByIdx");
		return (CategoryVO) mapper.selectOne("selectByIdx", idx);
	}
	
	/**
	 * @param mapper
	 * @param idx
	 * 삭제할 인덱스를 Service 로 받아서 idx 에 일치하는 엔터티를 삭제해 버리는 메소드
	 */
	public void delete(SqlSession mapper, int idx) {
		System.out.println("CategoryDAO ==> delete");
		mapper.delete("delete", idx);
	}
	
	
	/**
	 * @param mapper
	 * @param idx
	 * 
	 * 카테고리 내용을 '삭제 되었습니다' 로 바꿔주는 sql 문 실행
	 */
	public void deleteRemain(SqlSession mapper, int idx) {
		System.out.println("CategoryDAO ==> deleteRemain");
		mapper.delete("deleteRemain", idx);
	}
	
	
	/**
	 * @param mapper
	 * @param idx
	 * xml 에 삭제한 idx 번 카테고리의 deleteCheck 를 'YES' 로 변경 
	 */
	public void deleteCheck(SqlSession mapper, int idx) {
		System.out.println("CategoryDAO ==> deleteCheck");
		mapper.update("deleteCheck", idx);
	}
	/**
	 * @param mapper
	 * @param idx
	 * xml 에 삭제한 idx 번 카테고리의 deleteCheck 를 'NO' 로 변경 
	 */
	public void deleteRestore(SqlSession mapper, int idx) {
		System.out.println("CategoryDAO ==> deleteRestore");
		mapper.update("deleteRestore", idx);
	}
	/**
	 * @param mapper
	 * @param idx
	 * 신고횟수 deleteReport 변수의값을1 증가하도록  sql 문을 실행하는 메소드
	 * 
	 */
	public void deleteReport(SqlSession mapper, int idx) {
		System.out.println("CategoryDAO ==> deleteReport");
		mapper.update("deleteReport", idx);
	}
	
	
	/**
	 * @param mapper
	 * @param vo
	 * 카테고리의 내용을 수정하는 sql 문을 실행시키는 메소드
	 */
	public void update(SqlSession mapper, CategoryVO vo) {
		System.out.println("CategoryDAO ==> update");
		mapper.update("update", vo);
	}
	/**
	 * @param mapper
	 * @param vo
	 * 
	 * 삭제할 대상의 카테골와 하위 카테고리를 배열로 반환 해주는 메소드
	 * @return
	 */
	public ArrayList<CategoryVO> getDeleteList(SqlSession mapper, CategoryVO vo) {
		System.out.println("CategoryDAO ==> getDeleteList");
		return (ArrayList<CategoryVO>) mapper.selectList("getDeleteList", vo);
	}
	
	/**
	 * @param mapper
	 * @param gup
	 * @return
	 * 
	 * gup 가 같은 카테고리를 배열로 리턴해주는 메소드
	 */
	public ArrayList<CategoryVO> getGupList(SqlSession mapper, int gup) {
		System.out.println("CategoryDAO ==> getGupList");
		return (ArrayList<CategoryVO>) mapper.selectList("getGupList", gup);
	}
	
	
	/**
	 * @param mapper
	 * @param hmap
	 * 삭제 후 같은 그룹의 seq 를 초기화 하는 메소드
	 */
	public void updateReq(SqlSession mapper, HashMap<String, Integer> hmap) {
		System.out.println("CategoryDAO ==> upateReq");
		mapper.update("updateReq", hmap);
	}
	
	
	
}













