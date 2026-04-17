package com.min.edu.bean01; //자동으로 Bean이 되는 검색 main의 하위 package면 된다. @CompenentScan

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//TODO 003
@Slf4j //SpringBoot starter가 모든 의존성을 가져와준다
@Component //Spring이 자동으로 멤버를 모두 bean으로 등록해준다
public class SamsungTelevision implements RemoteController {

	@Override
	public FunctionExecutionDto powerOn() {
		log.info("@Component로 생성한 삼성 텔레비젼의 powerOn");
		return new FunctionExecutionDto("텔레비젼을 켜다", "삼성텔레비젼");
	}

	@Override
	public FunctionExecutionDto powerOff() {
		log.info("@Component로 생성한 삼성 텔레비젼의 powerOff");
		return new FunctionExecutionDto("텔레비젼을 끄다", "삼성텔레비젼");
	}

}
