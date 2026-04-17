package com.min.edu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.min.edu.anno01.IFunction;
import com.min.edu.anno01.Radio;
import com.min.edu.anno02.School;

@SpringBootTest
class Springboot02AnnotationApplicationTests {

	//TODO 003 @Component를 통해 생성된 Bean 주입 Radio, OCP를 통한 실행
	//JUnit(Jupiter-JUnit5)에서는 Bean을 테스트하기 위해서 @Autowired를 사용해야 한다
	@Autowired
	private IFunction radio;
	
	@Test
	void testPowerOn() {
		radio.powerOn();
	}
	
	//TODO 007 anno02의 @Autowired, @Qulifier, @Resource, @Autowired(required=false)
	
	
	@Autowired
	private School school;
	
	@Test
	void testSchool() {
		// 주입테스트
		school.printStudnets();
	}

}
