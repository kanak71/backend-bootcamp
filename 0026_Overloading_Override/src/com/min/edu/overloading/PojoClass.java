package com.min.edu.overloading;

/*
 * 정의 : overloading은 같은 클래스에 같은 메소드명을 가진 것을 이야기한다
 * 		같은 의미의 기능을 명명하기 위해서
 * 		구분방법은 : argument의 갯수와 타입이 다르면 된다
 * 
 * 결론 : 메소드명만 같으면 된다
 * 		접근제한자, 반환타입, static과는 연관 없다
 */
public class PojoClass {
	//출력이라고 하는 공통된 의미를 부여한 userPrint명으로 되어 있는 메소드를 필요한 Argument를 통해 구분하겠다
	public void userPrint(String msg) {
		System.out.println("문자열 출력 : " + msg);
		
	}
	public void userPrint(int n) {
		System.out.println("정수 출력 : " + n);
		
	}
	public void userPrint(double d) {
		System.out.println("실수 출력 : " + d);
		
	}
	public void userPrint(String name, int age) {
		System.out.println("Argument 두개 : " + name + ":" + age);
		
	}
	public void userPrint() {
		System.out.println("Argument가 없는 메소드");
		
	}

}
