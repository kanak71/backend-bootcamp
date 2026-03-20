package com.test.edu;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.dto.JobsDto;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class Mybatis_JUnitTest {

	@Test
	public void test() {
		SqlSessionFactory manager =  SqlSessionFactoryManager.getFactory();
		SqlSession session =  manager.openSession();	//Mybatis통해서 로그인된 상태
		assertNotNull(session);
	}
	
	//TODO 011 Mybatis를 통한 쿼리 실행 및 결과 받기
	
	private SqlSessionFactory manager;
	
	@Before
	public void createSQLSessionFactory() {
		manager = SqlSessionFactoryManager.getFactory();
	}
	
	@Test
	public void selectALLJobsTest() {
		SqlSession session = manager.openSession();
		List<JobsDto> lists = session.selectList("com.min.edu.jobs.selectALLJobs");
		System.out.println(lists);
		assertNotEquals(0,lists.size());
	}

}
