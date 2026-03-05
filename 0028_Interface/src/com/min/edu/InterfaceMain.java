package com.min.edu;

/*
 * 인터페이스란(interface)?
 * 1) 인터페이스는 구현체가 없는 선언만 되어 있는 메소드를 이야기한다
 * 	접근제한자는 모두허용(public), 같은 페이지 허용(default)로 작성이 된다
 * 2) 선언된 멤버필드는 모두 static final로 자동으로 변경되어 선언된다
 * 
 * 결론 : 강제상속을 위해서 만들어 놓은 설계도
 */

public class InterfaceMain {
	
	public static void main(String[] args) {
		//멤버필드는 모두 static final
		//static 메소드도 선언이 가능하다
		//결론 : interface에 묶어서 설계하면 관리하기가 편하다
		System.out.println(IGame.age);
		System.out.println(IGame.name);
		System.out.println(IGame.val);	//부모의 이름으로 자식을 호출
		System.out.println(IGame_Conf.val); //자신의 이름으로 호출
		System.out.println(IGame.sum(10)); //inferface에는 static 메소드
		
		//정의 : interface는 new하지 마시고 반드시 implements를 통해서 구현하세요
		//결론 : new를 하면 내부에 구성된 모든 선언된 메소드를 강제구현하는 소스를 작성해야한다
		GameImpl game = new GameImpl();
		// 다형성 : 자식이름으로 생성했기 때문에 부모의 타입으로 변할 수 있다
		//		부모타입으로 변경했다면, 사용하는 멤버는 부모의 멤버이다
		//		interface 강제구현 오버라이드가 반드시 되어 있다. 따라서 무조건 VMI가 동작
		IGame ig = game;
		IGame_Bin bg = game;
		IGame_Conf ic = game;
		
		ig.makeA();	//VMI가 동작돼서 구현된 자식 makeA()가 실행된다
		ig.printConf();	//VMI가 동작돼서 구현된 자식 printConf가 실행된다\
		
		game.printString();	//Default 메소드
		
		IGame.HelperClass helper = new IGame.HelperClass();
		helper.helperMethod();
	}
	

}
