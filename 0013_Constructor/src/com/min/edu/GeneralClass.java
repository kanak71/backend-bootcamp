package com.min.edu;

/*
 * TODO 001 일반 클래스
 */

public class GeneralClass extends ParentsClass {


	//default 생성자란?
	/*
	 * 1) 클래스는 작성하면 암묵적으로 만들어지는 메소드
	 * 2) 생성자는 반환타입이 없는 메소드로 구성
	 * 3) 외부에서 instance화를 할 때 메모리에 올리는 작업을 위한 단 1회 사용된다
	 * 4) 암묵적으로 작성이 되는 명시적으로도 선언 할 수 있다(단, 필수인 경우도 있다)
	 */
	
	public GeneralClass() {	//default 생성자
		//super란? 
		super("전민균");	//내가 상속 받고있는 부모의 생성자를 호출
		make();	//super();위로 가면 오류가 남 -> 부모가 먼저 생성되어야 하기 때문
		//만약 super(); 코드가 없어도 default 생성자라 자동으로 생성이 돼 오류가 나지 않는다
		
	}
	
	public void make() {
		System.out.println("make 메소드");
	}
	
	/*
	 * 내 클래스에서 생성자를 부모의 생성자를 호출
	 *  => 부모가 먼저 생성되고, 내가 생성자
	 *  
	 */
}
