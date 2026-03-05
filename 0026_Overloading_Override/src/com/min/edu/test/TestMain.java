package com.min.edu.test;
/*
 * 정의 : 참조타입은 생성된 타입에 의해서 실행할 수 있는 멤버가 정해진다
 * 		만약에 부모와 자식관계일 경우
 * 		자식으로 생성된 객체는 부모의 타입으로 참조될 수 있다
 * 		ㄴ 만약에 오버라이드 되어 있는 메소드라면 보이지 않아도 자동으로 부모는 자식의 메소드를 실행시킨다
 * 
 */
public class TestMain {

	public static void main(String[] args) {
		
//		//TODO T001 각각의 클래스는 인스턴스화해서 호출해보자
//		Test_A a = new Test_A();
//		System.out.println(a.x);
//		a.make();
//		
//		Test_B b = new Test_B();
//		System.out.println(b.y);
//		b.make();
		
		//TODO T002 참조타입의 형변환은 부모<->자식이 구조가 전제조건이다
		//		참조타입은 서로 변할 수 없다
		//		int -> long 프로모션(Promotion) : 자동
		//		long -> int 캐스팅(Casting) : (int)10;
//		Test_B bb = a;
//		Test_A aa = b;
		// 둘 다 오류난다
		
		//TODO T003 부모와 자식 관계를 만들어서 확인해보자
		// 1) 자식의 이름으로 객체를 생성해본다
		//	자식이 생성되면 부모도 같이 생성된다
		Test_B bb = new Test_B();
		System.out.println(bb.x);	//부모에게 물려받은 멤버필드	//100
		System.out.println(bb.y);	//자식 자신의 멤버필드	//200
		bb.make();//자식클래스에서 부모의 make()를 오버라이드 한 메소드 : 한개만 보인다	//난 Test_B에서 실행된 make() 이다
		
		// 2) 자식의 타입이 아닌 부모의 타입으로 변경해보자(Up-Casting)
		Test_A aa = bb;	//타입이 변화했기 때문에 사용될 수 있는 멤버는 부모만이어야 한다
		System.out.println(aa.x); 	//부모의 타입이기 때문에 부모의 멤버만 보인다	//100
		aa.make();  //근데 부모의 결과인 "난 Test_A에서 실행된 make() 이다" 가 아니라
					//자식의 실행 결과가 나온다
					//오버라이드 됐다면 보이지 않아도 원래 타입의 메소드를 실행시킨다 VMI
		

	}

}
