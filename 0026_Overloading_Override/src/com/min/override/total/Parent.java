package com.min.override.total;

public class Parent {
	
	//hiding 된다
	public int n = 200;
	//non-staitc인 메소드는 모두 자식클래스에서 오버라이드의 대상이 된다
	public void parentMethod() {
		
	}
	
	public void parentMake() {
		System.out.println("난 부모가 만들었다");
	}
	

}
