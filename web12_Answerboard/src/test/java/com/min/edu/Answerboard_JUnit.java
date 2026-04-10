package com.min.edu;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.min.edu.support.SqlSessionSupport;

public class Answerboard_JUnit {

	@Test
	public void test() {
		SqlSessionFactory manager = SqlSessionSupport.getFactory();
		SqlSession session = manager.openSession();
		assertNotNull(session);
	}

}
