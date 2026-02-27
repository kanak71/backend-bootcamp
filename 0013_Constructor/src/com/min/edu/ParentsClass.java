package com.min.edu;

public class ParentsClass {
	
	private String name;	//null은 참조타입이 초기값

	//default 생성자
	public ParentsClass() {
		super();
	}
	
	//오버로딩된(overloading) 생성자
	//멤버필드를 argument로 받는 생성자가 만들어짐
	//메소드에서 같은 이름인 경우 변수의 우선순위는 local
	//따라서 영역을 구분하기 위해서 멤버필드는 내것(this) 접두사 사용
	public ParentsClass(String name) {
		this.name = name;
	}
	
	
	//멤버필드가 접근이 안되기 때문에 출력만 되는 기능의 메소드
	public void printMember() {
		System.out.println(name);	
	}

	

}
