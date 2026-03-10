package com.min.edu;

//TODO 102
/*
 * 정의 : 람다식 실행 블럭{}에서는 클래스인 멤버필드와 메소드를 제약없이 사용 가능하다
 * 		람다식 실행 블럭{} 내에서는 this 람다식을 실행 객체를 참조한다
 */
public class LamdaExam_Inner {
	
	private int memberField = 10;	//인스턴스 변수이다
	
	//Inner 클래스 : 클래스의 내부에 정의해서 이름이 없는 클래스
	class Inner{
		
		int innerField = 20;
		
		void method() {
			
			//람다식---------
			MyFunction f = () -> {
				System.out.println("memberField" + memberField);	//바깥(외부클래스) 객체의 참조를 얻기 위해서는 클래스명.this.를 사용
				System.out.println("memberField" + LamdaExam_Inner.this.memberField);
				System.out.println("memberField" + innerField);
				System.out.println("memberField" + this.innerField);	//람다 표현식 내부에서 있는 this는 Inner 객체를 참조한다
				
			};	//람다식 끝---------
			
			//실행
			f.method();
		}
		
		
		
	}
	

}
