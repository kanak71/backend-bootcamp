package com.min.edu;


//TODO 001 접근제한자를 가지고 있는 클래스
public class MyClass {
	
	public void publicMethod() {
		System.out.println("public 메소드");
	}
	
	void defaultMethod() {
		System.out.println("default 메소드");
	}
	
	protected void protectedMethod() {
		System.out.println("protected 메소드");
	}
	
	private void privatedMethod() {
		System.out.println("private 메소드");
	}
	
	//TODO 증명 001 내 클래스의 내 멤버는 접근제한자의 영향을 받을까? 결론은 "아니다"
	//		해당 클래스가 new 했을 때 같이 생성되기 때문에 new를 하지 않아도 접근 할 수 있다
	public void accessTest() {
		publicMethod();
		defaultMethod();
		protectedMethod();
		privatedMethod();
	}

}
