package com.min.edu;

import java.text.Annotation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.min.edu.bean01.FunctionExecutionDto;
import com.min.edu.bean01.SamsungAircon;
import com.min.edu.bean01.SamsungTelevision;
import com.min.edu.inject.UseBean;

@SpringBootApplication
public class Springboot01BeanApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot01BeanApplication.class, args);
		
//		//TODO 005 main 메소드는 static으로 되어 있기 때문에 객체를 생성하여 호출 테스트
//		// 모든 bean @SpringBootApplication 생성 및 관리
//		ApplicationContext context1 = new AnnotationConfigApplicationContext(SamsungTelevision.class);
//		ApplicationContext context2 = new AnnotationConfigApplicationContext(SamsungAircon.class);
//		
//		//TODO 006 @Component로 작성된 class 하위의 모든 method가 자동으로 Bean이 된다
//		//		이름으로 static은 해당 클래스명,멤버
//		//		@Component로 작성된 Class는 클래스명을 Camel(첫글자 소문자 의미있는 다음 단어 대문자)방식으로 호출 하면 된다
//		SamsungTelevision television = context1.getBean("samsungTelevision", SamsungTelevision.class);	//bean이름, 캐스팅 타입
//		System.out.println(television.powerOn());
//		System.out.println(television.powerOff());
//		
//		//TODO 007 @Configuration으로 각각의 메소드를 @Bean으로 등록 했다
//		FunctionExecutionDto airconOn = context2.getBean("airconOn", FunctionExecutionDto.class);
//		FunctionExecutionDto airconOff = context2.getBean("airconOff", FunctionExecutionDto.class);
//		
//		System.out.println(airconOn.toString());
//		System.out.println(airconOff.toString());
	}
	
	//Bean을 호출하는 방법
	//@SpringBootApplication이 모두 Bean을 만들어서 등록해서 가지고 있다
	//Test 코드
	//Spring Boot가 모두 실행된(Bean이 완성된 후에) 직후 실행하는 인터페이스
	
	//주입할 수 있는 bean은
	//@Component 자동으로 하나만 있는 SamsungTelevision 타입을 주입한다
	//@Configuration + @Bean : 선언된 클래스의 name="값"과 같은 Parameter명을 사용하면 자동 주입
	@Bean
	public CommandLineRunner run(SamsungTelevision tv, SamsungAircon airconOn, UseBean useBean) {	//Argument로 생성되어 있는 빈들을 주입해서 사용하면 된다 - 메소드 형 주입방법
		return args->{
//			tv.powerOn();
//			tv.powerOff();
//			System.out.println(airconOn);
			useBean.print();
			
		};
	}
	
	

}
