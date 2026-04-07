package com.test.edu;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.min.edu.support.SqlSessionSupport;

public class SqlSessionCreate_JUnit {

	@Test
	public void test() {
		SqlSessionFactory factory = SqlSessionSupport.getFactory();
		//openSession()은 default값 false이기 때문에 manual commit 이다
		SqlSession session = factory.openSession();
		assertNotNull(session);
	}

}
