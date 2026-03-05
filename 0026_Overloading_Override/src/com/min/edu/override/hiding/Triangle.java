package com.min.edu.override.hiding;

/*
 * Rectangle을 부모로 가지고있는 클래스
 * Rectangle이 가지고있는 멤버가 오버라이드의 대상이 된다
 */
public class Triangle extends Rectangle {
	
	//오류는 발생하지 않는다
	//TODO 002 static으로 선언된 메소드는 오버라이드 되지 않고 HIDE되어 각 Class에 속해서 작동이 된다
	public static int newArea(int w, int h) {
		return w*h/2;
	}

	//부모의 메소드를 오버라이드 한다
	@Override
	public void callMethod() {
		System.out.println("Triangle 클래스");
	}
	

}
