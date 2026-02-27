package com.min.edu;

//TODO 000 final
//변수 : instance(클래스 내부에 정의, 외부에서 new를 통해서 사용)
//		local(메소드 내부에서 사용 - 외부로 꺼낼 수 없다 - return 값을 반환 : 단 한개 가능하다 : DTO 여러개를 묶어서 반환)
//		static(클래스명. 사용한다. 메모리에 단 한 번 올라간다, 주소가 공유되기 때문에 모두 사용 가능하다)

/**
 * 자식을 사용되는 클래스
 * 클래스에서의 final은 난 다른 클래스의 부모가 될 수 없는 클래스를 정의할 때 사용
 */
public class FinalClass {
	//멤버필드의 특징 : 멤버필드 class가 instance될 때 초기화된다(타입의 초기값 대입을 한다)
	public static final int[] arr;	//처음에 변수의 final은 값을 가지고 있는 형태여야 한다
	public static final int age = 10;
	
	static { //static 생성자 : 인스턴스화보다 가장 먼저 실행된다
		arr = new int[3];	//int[] 배열공간을 3만들겠다 [ [0], [0], [0] ]
		
	}
	
	/**
	 * final이 없는 일반 메소드<br> 일반메소드는 재정의가 가능함 
	 */
	public void change() {
		arr[0] = 100;	//arr의 변수에 묶여 있는 안의 0번째 방에 100을 넣어줘
		final int a;
		a = 10;
		//변수의 특징 : 재입력이 가능하다
		//a = 20; 상수는 첫번째 선언된 값 이외는 재입력을 할 수 없다
		System.out.println("상수값 : " + a);
		
	}
	
	/**
	 * final로 선언된 메소드<br> final은 재정의를 하지 못함
	 * @return 문자열
	 */
	public final String callMessage() {
		return "금요일입니다";
	}
}
