package com.min.edu;

public class ThisSuperMain {
	public static void main(String[] args) {
//		Child c = new Child();
//		System.out.println(c.num);
		//질문 : 부모의 멤버를 호출하고 싶어요!!!
		//결론 : 안됩니다!!
		//		무조건 자식을 통해서 부모(super)를 호출할 수 있다
		//정리 : 외부에서 생성된 instance를 통새서 절대 내 부모를 호출
		
		Child c = new Child(100);
		c.print();
		
		/* 결과 : 
		 * Parent의 멤버필드 : 200
		   Parent를 super예약어를 통해 멤버필드 호출 : 200
		   child의 멤버필드 : 100

		 */
	}

}
