package com.min.edu.main;

import java.util.Scanner;

import com.min.edu.H2O;
import com.min.edu.choice.ChoiceFactory;
import com.min.edu.sub.Steam;
import com.min.edu.H2OImpl;
//다른 패키지에 있다면 물리적인 위치를 구분하기 위해 import가 작성되고 물리적인 위치인 package가 작성된다

public class H2OMain {

	//TODO 003 참조타입의 형변환(Polymorphism)을 확인하자
	public static void main(String[] args) {
		
		/*
		 * 정의 : 각각의 완료된 클래스를 new를 통해 생성한다
		 * 		이를 통해서 같은 method명으로 호출된다
		 * 결론 : OCP(Open Closed Principle) : 개폐원칙
		 * 		Open : 작성되는 코드는 자유롭게 작성하여 method의 규칙에 맞도록 해준다
		 * 		Closed : 호출을 할 때는 공통적인 메소드를 사용하여 호출한다
		 * 		ㄴ 구성은 규칙적으로, 작성은 자유롭게
		 */
//		Steam s = new Steam();
//		Water w = new Water();
//		Ice i = new Ice();
//		
//		s.make();
//		s.print();
//		
//		w.make();
//		w.print();
//		
//		i.make();
//		i.print();
		
//		ChoiceFactory fac = new ChoiceFactory();
//		System.out.println("선택해주세요");
//		System.out.println("1. 수증기, 2. 물, 3. 얼음");
//		
//		Scanner scan = new Scanner(System.in);
//		int choice = scan.nextInt();
//		
//		H2O obj = fac.factory(choice);
//		obj.make();
//		obj.print();
//		
		//-------------------------------------
		//정의 : 다형성의 조심해햐할 문제
		//		부모와 자식 관계에서만 발생
		Steam s = new Steam();
		//up-casting <-> 반대로 <-> Down-Casting
		H2OImpl h01 = s;
		H2O h02 = s;
		h02.make();
		h02.print();
		
		//결론 : 처음에 정의되있지(인스턴스) 않은 형태로 돌아 갈 수 없다
		//s는 원래 형태가 Steam
		
		/*
		 * 기본타입은 promotion과 casting으로 처리가 된다
		 * 같은 타입으로 변환되는 것
		 */
		
		byte b = 10;
		short ss = b;
		int i = ss;
		
		int n = 100;
		short sh = (short)n;
		

	}

}
