package com.min.edu.anno01;

import org.springframework.stereotype.Component;

//TODO 002 @Component를 사용하여 자동으로 @SpringBootApplication이 읽어서 Bean으로 등록해준다
@Component
public class Radio implements IFunction {

	@Override
	public void powerOn() {
		System.out.println("라디오를 켜다");

	}

	@Override
	public void powerOff() {
		System.out.println("라디오를 끄다");

	}

}
