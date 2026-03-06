package com.min.edu;

//TODO 004 Extends(상속-물려받는다. 확장한다) 통해서 특정 클래스를 확장하여 사용할 경우, 사용되는 접근제한자 확인

public class External_ExtendsClass extends MyClass{	//같은 패키지 이기 때문에 import되지 않음
	
	//TODO 증명 004 부모로 MyClass Extends 한다면, 부모의 멤버를 물려받게 된다.
	//		질문? 1. 부모로부터 물려받지 못한다는 의미?
	//				오버라이드 할 수 없다
	
	//		     2. 물려받지 못하는 것은?
	//				final, 생성자
	
	//	extends를 통해서 사용할 수 있는 접근제한자는 private를 제외한 모든 것들 이다
	public void extendsTest() {
		publicMethod();
		defaultMethod();
		protectedMethod();
	}

}
