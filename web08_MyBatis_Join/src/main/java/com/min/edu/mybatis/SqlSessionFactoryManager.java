package com.min.edu.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryManager {
	
	private static SqlSessionFactory factory;

	static {
		String path ="com/min/edu/mybatis/config.xml";
		try {
			Reader reader = Resources.getResourceAsReader(path);
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			System.out.println("SqlSessionFactory 생성");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
	

}
