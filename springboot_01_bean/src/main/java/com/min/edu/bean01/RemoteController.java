package com.min.edu.bean01;

//TODO 002 기능을 정의하는 인터페이스 : OCP 구조 - VMI - 부모의 이름으로 자식을 생성 할 수 있다 - 부모의 메소드로 자식의 메소드를 호출 할 수 있다

public interface RemoteController {

	public FunctionExecutionDto powerOn();
	public FunctionExecutionDto powerOff();
	
}
