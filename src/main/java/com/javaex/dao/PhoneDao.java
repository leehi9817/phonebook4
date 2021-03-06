 package com.javaex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {

	@Autowired
	private SqlSession sqlSession;
	
	//전체리스트 가져오기
	public List<PersonVo> getPersonList() {
		System.out.println("PhoneDao.getPersonList()");
		List<PersonVo> personList = sqlSession.selectList("phonebook.selectList");
		
		return personList;
	}
	
	//전화번호 추가
	public int personInsert(PersonVo personVo) {
		System.out.println("PhoneDao.personInsert()");
		int count = sqlSession.insert("phonebook.insert", personVo);
		System.out.println(count + "건 저장");
		
		return count;
	}
	
	//전화번호 삭제
	public int personDelete(int personId) {
		System.out.println("PhoneDao.personDelete()");
		int count = sqlSession.delete("phonebook.delete", personId);
		System.out.println(count + "건 삭제");
		return count;
	}
	
	//전화번호 수정
	public int personUpdate(PersonVo personVo) {
		System.out.println("PhoneDao.personUpdate()");
		int count = sqlSession.update("phonebook.update", personVo);
		System.out.println(count + "건 수정");
		return count;
	}
	
	//1명 정보 가져오기
	public PersonVo getPerson(int personId) {
		System.out.println("PhoneDao.getPerson()");
		PersonVo personVo = sqlSession.selectOne("phonebook.selectOne", personId);
		return personVo;
	}
}
