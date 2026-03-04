package com.min.edu.ref;

public class StaticMain {

	public static void main(String[] args) {
		//정의 : 호출방식은 메모리가 고정되어 있는 주소 속해 있는 클래스명으로 호출하게 된다
		
		StaticIncludeClass.makeA();	//권고사항 호출 방식
		StaticIncludeClass.makeC();
		
		//non-static은 객체를 만든 후에 호출이 가능
		//	메모리에 올리는 작업을 해 줘야 한다
		StaticIncludeClass sc = new StaticIncludeClass();
		sc.makeB();
		sc.makeD();
		
		//결론 : static은 미리 메모리에 할당된다
		//		non-static은 new를 통해서 메모리에 할당하는 작업을 해야 객체를 통해 호출된다

	}

}
