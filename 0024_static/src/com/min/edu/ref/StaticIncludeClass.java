package com.min.edu.ref;

/*
 * 정의: static은 method Area의 영역에 static 영역에 만들어진다
 * 		application 실행(Run As)될 때 가장 먼저 메모리에 할당된다
 * 		주소는 클래스명으로 고정된다
 * 		호출 클래스명.멤버 된다
 *  주의사항 : 멤버에만(클래스 내부에만 사용가능) 사용가능하다. class에는 static을 선언할 수 없다
 */

public class StaticIncludeClass {
	
	/*
	 * 정의 - static의 호출
	 * 	전제조건 : static은 메모리에 먼저 할당된다. 영역이 다르다(method | static)
	 * 결론 : 
	 * 		makeA()는 static으로 생성되어 있기 때문에 메모리에 올라가는 시점이 다른 non-static은 호출하지 못한다
	 * 					ㄴ 먼저 실행되는 static으로 선언된 멤버를 호출할 수 있다
	 * 		makeB()는 non-static으로 생성되어 있기 때문에 메모리에 올라가 먼저 올라가는 static과 같이 생성되는 non-static을 호출할 수 있다
	 */
	
	public static void makeA() {
		//makeB();	//내 class인데 호출되지 않는다
		makeC();	//내 class인데 static인데 호출이 된다
	}
	
	public void makeB() {
		//makeA();	//내 class인데 static인데 호출이 된다
		makeD();	//내 class인데 호출 된다
	}
	
	public static void makeC() {
		
	}
	
	public void makeD() {
		
	}

}
