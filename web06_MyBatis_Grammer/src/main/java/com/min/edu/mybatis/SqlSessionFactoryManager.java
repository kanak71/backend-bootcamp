package com.min.edu.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//TODO 00801 myBatis 설정파일(configuration.xml + mapper xml)을 읽어서 객체(SqlSessionFactory)로 만듦
public final class SqlSessionFactoryManager {
	
	
	//TODO 00802 외부에 노출할 멤버필드, applicaton이 실행되자 마자 단 1회 생성되기 위해서 static으로 ㅏㅈㄱ성
	//								외부에서 입력하지 못하도록 private 접근자 사용
	private static SqlSessionFactory factory;
	
	static {
		//TODO 00803 mybatis configuration.xml 파일 위치
		String path = "mybatis/Configuration.xml";
		
		//TODO 00804 IO로 읽어서 MyBatis SqlSessionFactory 객체 생성(Builer 사용)
		try {
			Reader reader = Resources.getResourceAsReader(path);	//xml을 데이터로 읽어옴
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close(); //Stream은 닫아 준다
			System.out.println("SqlSessionFactory 객체 생성 성공");
		} catch (IOException e) {
			System.out.println("SqlSessionFactory 객체 생성 실패");
			e.printStackTrace();
		}
		
	} //static 생성자

	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
	

}
