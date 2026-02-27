package com.min.edu;

public class FinalMain {
	
	//final의 실행
	public static void main(String args[]) {
		ChildClass child = new ChildClass();
		child.change(); //자식 클래스에서 부모의 final로 되어 있지 않은 메소드를 재정의 한 메소드
	}

}
