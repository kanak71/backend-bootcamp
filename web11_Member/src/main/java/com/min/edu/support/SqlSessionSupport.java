package com.min.edu.support;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//TODO 004 myBatis 객체 생성을 위한 SqlSessionFactory 객체 생성 클래스
public class SqlSessionSupport {
	
	private static SqlSessionFactory factory;

	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
	static {
		try {
			//IO 읽어낼 파일의 경로
			String path = "mybatis/config.xml";
			
			//IO를 통해서 값으로 만들어 준다. myBatis에 맞춰 Resources
			Reader reader = Resources.getResourceAsReader(path);
			//IO를 통해서 Builder를 통해서 java의 객체로 변경 SqlSessionFactory
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
