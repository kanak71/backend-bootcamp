package com.min.edu.override_hidingfield;

/*
 * 정의 : 오버라이드는 부모와 자식의 메소드에서 발생
 * 		멤버필드는 오버라이드 되지 않고 
 * 		각 타입으로 정의된 멤버필드를 사용하게 된다
 * 		이것을 field hiding 이라한다
 * 결론 : 다형성발생원리(OOP - Object Oriented Programming);
 * 		ploymorphism
 * 
 * 추가사항 : 자식은 부모의 타입으로 참조될 수 있다!!!!
 */

public class HidingFieldMain {

	public static void main(String[] args) {
		Triangle tri = new Triangle();
		
		System.out.println(tri.w);
		System.out.println(tri.h);
		
		Rectangle rec = tri;	//부모타입으로 형변환
								//타입이 변경되어서 부모타입으로만 보인다
		System.out.println(rec.w);
		System.out.println(rec.h);
		System.out.println(tri.w);
		System.out.println(tri.h);

	}

}
