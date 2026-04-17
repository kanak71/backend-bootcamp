package com.min.edu.anno02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//TODO 005 @Configuration으로 선언해서 같은 타입을 반환하는 기능을 가진 여러개의 메소드를 Bean으로 생성한다
@Configuration
public class ConfigurationBean {
	
	@Bean(name = "stu01")
	public Student student01() {
		Student stu = new Student();
		stu.setName("홍길동");
		stu.setAddr("제주도");
		stu.setAge("100");
		return stu;
	}
	
	@Bean(name = "stu02")
	public Student student02() {
		Student stu = new Student();
		stu.setName("홍길은");
		stu.setAddr("울릉도");
		stu.setAge("110");
		return stu;
	}
	
	
	
	
}
