package com.min.edu.exam;


//TODO 201 부모클래스 작성
public class ParentsClass {
	
	/*
	 * 되게 중요한 특징이라하심
	 * ### 부모의 생성자를 오버로딩 하면 default 생성자는 사라짐
	 * 	따라서 생성자를 오버로딩 했는데 
	 * 	default 생성자도 필요로 한다면
	 * 	*반드시* 명시적으로 선언해 주어야 한다
	 */

	//생성자 오버로딩
	public ParentsClass(String msg) {
		System.out.println("부모의 생성자 호출 : " + msg);
	}
	
//	public ParentsClass() {
//		
//	}
	
	

}
