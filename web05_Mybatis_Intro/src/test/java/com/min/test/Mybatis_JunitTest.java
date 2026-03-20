package com.min.test;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.min.edu.mybatis.SqlSessionManager;

public class Mybatis_JunitTest {

	//TODO 010 Mybatis를 사용하기 위한 sqlSessionFactory 객체의 생성 확인
	@Test
	public void sqlSession_Create() {
		SqlSessionFactory manager = SqlSessionManager.getFactory();
		SqlSession session =  manager.openSession();
		assertNotNull(session);
	}

}
