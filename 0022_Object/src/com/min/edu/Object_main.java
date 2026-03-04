package com.min.edu;

/*
 * 정리 : java.lang.Object
 *  1) java의 객체의 최상위 부모이다
 *  2) java의 모든 객체는 java.lang.Object를 extends(확장) - 상속구조
 *  
 *  - 중요 메소드
 *   getClass(); 객체가 생성된 물리적인 구조를 출력해줌
 *   toString(); 객체는 메인에 있기 때문에 안에 값을 출력할 수가 없다. 그래서 부모는 겉의 상태를 출력해줌
 *  			ex) 생성된 위치@고유값
 *   equals(); 객체의 고유값인 hashcode를 통해서 고유성을 비교할 때
 *   hashcode(); 객체의 고유값을 출력
 *  
 *  결론 : java.lang.Object 최상위 부모이고 이를 통해 생성된 자식의 정보를 확인하고 출력 할 수 있다
 */

public class Object_main {

	public static void main(String[] args) {
		
		//같은 값을 가지고 같은 타입 같은 형태를 가지고 있는 객체 생성
		UserDefinedClass u1 = new UserDefinedClass();	//class com.min.edu.UserDefinedClass
		UserDefinedClass u2 = new UserDefinedClass();	//class com.min.edu.UserDefinedClass
		
		//첫번째 getClass를 통해서 구성된 설계도(물리적인 위치 : package import)를 확인한다
		System.out.println(u1.getClass());
		System.out.println(u2.getClass());
		
		//두번째 hashcode를 객체의 고유값을 확인해보자
		//결론 : 같은 곳에서 만들어진 것 이라도 메모리에 할당되면 다른 객체이다
		System.out.println(u1.hashCode());	//664740647
		System.out.println(u2.hashCode());	//804564176
		
		//세번째 : 객체를 표출해보자
		//결론 : 위치와 고유값을 한꺼번에 출력한다
		System.out.println(u1.toString());	//com.min.edu.UserDefinedClass@279f2327
		System.out.println(u2.toString());	//com.min.edu.UserDefinedClass@2ff4acd0

		//네번째 : equals
		//결론 : 객체는 고유값을 가지고 있다
		//		고유값을 만들어내는 방식은 안에 있는 값을 통해서 만들게 된다
		//		객체의 안의 값을 확인하지 않고 고유값(s/n시리얼넘버)을 확인하면 그 객체이다 라고 판단한다
		//		: new 항상 새로운 ref(주소)와 hashcode를 부여받는다
		System.out.println(u1 == u2); //참조타입의 주소 값을 비교 => 무조건 false
		System.out.println(u1.equals(u2)); //참조타입의 hashcode(고유값)을 비교 false
										   //결론 : hashcode를 오버라이드 하지 않으면 모두 다르다
		
		
		/* hashcode 오버라이드 된 후 겨로가
		 *  class com.min.edu.UserDefinedClass
			class com.min.edu.UserDefinedClass
			54152077
			54152077
			com.min.edu.UserDefinedClass@33a4b8d
			com.min.edu.UserDefinedClass@33a4b8d
			false	//주소는 다르다
			true	//같은 값을 가진 객체다
		 */
	}

}
