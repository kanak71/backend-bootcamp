package com.min.edu.ext;

import com.min.edu.MyClass;

//TODO 005 외부 package에서 extends를 사용한 클래스
public class External_Package_ExtendsClass extends MyClass {
	
	
	//TODO 증명 005 패키지가 다른 곳에서 extends를 했다면 public되고
	//		패키지가 다르면 접근하지 못했던 default와 protected 중에서
	//		"protected"는 사용할 수 있다
	public void epTest() {
		publicMethod();
		protectedMethod();
		
	}

}
