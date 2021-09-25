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
}













