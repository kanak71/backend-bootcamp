package com.min.edu.override.hiding;

/*
 * 정의 : 오버라이드는 부모와 자식간의 관계를 필요로한다
 * 		static은 오버라이드가 되는 것이 아니다
 * 		
 * 결론 : static은 주소가 고정되어 있기 때문에 static 영역에 고유한 주소를 가지고 있다
 * 		각 주소의 호출로 요청된다
 * 		hiding이라고 한다
 */

public class HidingMain {

	public static void main(String[] args) {
		
		Triangle t = new Triangle();
		
		//TODO 003 staic은 오버라이드 되지 않는다 
		int cal = Triangle.newArea(10, 10);
		System.out.println(cal);
		
		//TODO 004 오버라이드 된 메소드인 callMethod를 실행
		t.callMethod();
		
		//TODO 005 부모의(Rectangle) static 메소드를 실행
		int calRec = Rectangle.newArea(10, 10);
		System.out.println(calRec);

	}
}
