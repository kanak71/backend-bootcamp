package com.min.edu;

//TODO 0001_02 클래스에 기능(method)을 가지고있는 클래스
// 커피를 사용해서 기능을 담당(출력) : 반환타입이 있어야 한다
public class Machine {
	
	//접근제한자 반환타입 메소드명
	public Coffee order() {
		
		return make();
		//return null;	//null의 의미는 아무것도 없는 것
	}
	
	private Coffee make() {
		//인스턴스화 : 클래스를 사용할 수 있도록 메모리에 올려 놓는 작업
		Coffee 프라프치노 = new Coffee();
		프라프치노.name = "프라프치노";
		프라프치노.sugar = "8스푼";
		return 프라프치노;	
	}

}



