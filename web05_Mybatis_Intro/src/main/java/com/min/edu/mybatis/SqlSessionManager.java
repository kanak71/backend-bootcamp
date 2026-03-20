package com.min.edu.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//TODO 009 Configuration.xml의 환경설정을 읽어서 mybatis 객체를 만들어내는 클래스
public final class SqlSessionManager {
	
	//static으로 구성해서 DB와 연결을 쉽게 하도록
	//웹 백엔드 개발이기 때문에 기본적으로 DB연결이 필요하다
	
	private static SqlSessionFactory factory;

	static {
		//Configuration.xml의 위치
		String path = "com/min/edu/mybatis/Configuration.xml";
		
		try {
			//1) IO로 읽어서 값으로 만든다
			Reader reader = Resources.getResourceAsReader(path);
			//2) 만들어진 값으로 MyBatis 객체를 만들어낸다
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			System.out.println("MyBatis SqlSessionFactory 객체 생성 성공");
		} catch (IOException e) {
			System.out.println("MyBatis SqlSessionFactory 객체 생성 실패");
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
	
	

}
