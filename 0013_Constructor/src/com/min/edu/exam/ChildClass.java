package com.min.edu.exam;

//extends 했는데 오류가 나는 이유
//클래스에 오류 표시가 뜨면 생성자에 관련 코드 오류
//체이닝

public class ChildClass extends ParentsClass {

	public ChildClass(String msg) {
		super(msg);	//argument가 있는 부모의 생성자 호출
		System.out.println("난 자식의 생성자 호출");
	}

}
