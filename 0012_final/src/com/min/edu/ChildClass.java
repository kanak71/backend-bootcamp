package com.min.edu;

/**
 * FinalClass를 부모로 가지고 있는 자식 클래스
 */

public class ChildClass extends FinalClass {

	@Override
	public void change() {
		System.out.println("난 ChildClass의 change()이다");
		String msg = callMessage();
		System.out.println(msg);
	}
	
	//부모의 final로 선언되어 있는 메소드는 재정의가 안되고 사용만 가능하다
	

}
