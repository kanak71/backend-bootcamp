package com.min.edu.bean01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

//TODO 004 @Configuration은 내부에 있는 메소드를 각각 Bean으로 만들 수 있다
@Slf4j
@Configuration
public class SamsungAircon implements RemoteController {

	@Override
	@Bean(name = "airconOn")
	public FunctionExecutionDto powerOn() {
		log.info("@Configuration으로 생성한 삼성 에어콘 powerOn");
		return new FunctionExecutionDto("에어콘을 켜다", "삼성 에어콘");
	}

	@Override
	@Bean(name = "airconOff")
	public FunctionExecutionDto powerOff() {
		log.info("@Configuration으로 생성한 삼성 에어콘 powerOff");
		return new FunctionExecutionDto("에어콘을 끄다", "삼성 에어콘");
	}

}
