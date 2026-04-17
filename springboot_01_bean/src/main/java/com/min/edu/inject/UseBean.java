package com.min.edu.inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.min.edu.bean01.FunctionExecutionDto;
import com.min.edu.bean01.SamsungTelevision;

//TODO 008 외부(다른-com.min.edu.bean01)에서 생성된 Bean을 주입(DI)해서 사용하겠다
/*
 * @Autowired를 사용해서 주입한다
 * *** 주입을 하기 위해서 반드시 해당 클래스도 Bean으로 되어 있어야한다
 * 		클래스가 @Component로 되어 있어야한다
 */

@Component
public class UseBean {

	// 멤버필드 주입 방식
	// 주입 할 때 고민해야 할 점, "타입기반의 @Component인가 아니면 name기반의 @Bean인가"
	@Autowired
	private SamsungTelevision samsungTelevision;
	
	@Autowired
	private FunctionExecutionDto airconOn;
	
	@Autowired
	private FunctionExecutionDto airconOff;
	
	//TODO 009 모든 생성된 Bean을 모아서 호출
	public void print() {
		System.out.println("외부의 Bean을 Bean에서 주입해서 사용한다: DI");
		System.out.println(samsungTelevision.powerOn());
		System.out.println(samsungTelevision.powerOff());
		System.out.println("-".repeat(20));
		System.out.println(airconOn);
		System.out.println(airconOff);
		
	}
}






