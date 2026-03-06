package com.min.edu;

//TODO 002 외부에서 MyClass를 접근하기 위해서 반드시 객체를 생성해야 한다(new)
public class ExternalClass {
	
	//TODO 증명 002 외부에서 new를 통해서 접근
	//		private를 제외한 모든 접근 제한자는 new를 통해서 외부에서 접근이 가능하다
	public void exMyClass() {
		MyClass my = new MyClass();
		my.publicMethod();
		my.protectedMethod();
		my.defaultMethod();
		//my.privatedMethod();
	}
	

}
