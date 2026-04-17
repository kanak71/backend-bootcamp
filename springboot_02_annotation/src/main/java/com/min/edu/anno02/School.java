package com.min.edu.anno02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

//TODO 006 Student의 @Configuration의 @Bean을 주입 받는 Bean
@Component
public class School {
	
	/* 
	 * 1. @Autowired 는 타입기반의 주입(단일 타입의 Bean이 있어야만 한다)
	 * 오류코드 : 실행할때 발생하는 것이 아니라, 프로젝트 로딩될때 발생한다 => 모두다 static final로 정상 할당 되어야지만 SpringBoot는 실행된다
	 * Field student in com.min.edu.anno02.School required a single bean, but 2 were found:
	 *  => student(@Configuration)라고 하는 Type안에 2개의 Bean이 존재하기 때문이다
	 *  어떠한 것을 주입해야 할지 모른다
	 */
	
//	@Autowired
//	private Student student;
	
	/* 
	 * 2. 
	 * 여러 Bean들 중에서 특정 Bean을 주입
	 * 		@Qauilfier 사용해야 한다 => 특정 bean의 name을 지정할 수 있다
	 */
	
	@Autowired
	@Qualifier("stu01")	//bean의 이름으로 주입을 받는다
	private Student student1;
	
	@Autowired
	@Qualifier("stu02")
	private Student student2;
	
	/*
	 * @Autowired는 기본으로 타입을 찾는다(타입 -> 이름)
	 * 그렇다면 타입이 아니라 이름기반으로 찾는 annotation이 있으면 좋겠다
	 * @Resource (이름 -> 타입)
	 */
	
	//3. 이름기반의 주입(@Resource)
	@Resource(name="stu01")
	private Student student3;
	
	@Resource(name="stu02")
	private Student student4;
	
	/*
	 * 4. 생성한 적이 없는 Bean을 사용한다면?
	 * required = false => 존재하지 않으면 null로 객체를 사용하겠다
	 */
	
	@Autowired(required = false)
	@Qualifier("stu05")	//어느곳(base-package:com.min.edu의 하위)에서도 만든 적이 없는 bean이름
	private Student student5;
	
	//메소드 출력 test
	public void printStudnets() {
		System.out.println("student" + student1);
		System.out.println("student" + student2);
		System.out.println("student" + student3);
		System.out.println("student" + student4);
		System.out.println("student" + student5);
	}
	
}










