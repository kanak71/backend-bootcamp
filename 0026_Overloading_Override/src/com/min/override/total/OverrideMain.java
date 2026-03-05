package com.min.override.total;

/*
 * 정의 : VMI(Virtual Method Invocation) : 역전현상
 * 		부모의 메소드를 실행했지만, 자식에 재정의한 메소드가 실행되는 것
 */

public class OverrideMain {

	public static void main(String[] args) {
		//TODO 301 오버라이드 되지 않은 메소드는 모두 부모를 실항한다
		Child c = new Child();
//		c.parentMethod();	//자식클래스에서 오버라이드하지 않았기 때문에 부모의 메소드이다
//		c.parentMake();
//		
		//TODO 302 생성된 타입이 child인데 Parent 타입으로 형변환시켜보자
		Parent p = c;	//부모의 타입으로 자식을 참조한다
//		p.parentMethod();
		p.parentMake();	//타입은 Parent이지만 자동으로 오버라이드 되어 있는 자식의 메소드를 실행 //난 부모를 재정의했다

	}

}
