package com.min.edu.nest;

public class NestMain {
	
	public static void main(String[] args) {
		//자식의 이름으로 자식을 생성
		UseNestInterface message = new UseNestInterface();
		message.msg();
		
		//속해있는(nest)되어 있는 클래스는 부모자식 관계가 아니다
		//Showable sMessage = message;
		Showable.Message sMessage = message;
	}

}
