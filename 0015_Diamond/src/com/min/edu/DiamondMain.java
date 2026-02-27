package com.min.edu;

import java.util.Scanner;

import com.lion.like.util.InputUtil;

public class DiamondMain {

	public static void main(String[] args) {
		
//		Diamond_Div div = new Diamond_Div();
		
		//1단계 : 메소드가 두개라서 입력 및 순서 문제가 발생할 수 있다
		//따라서 메소드를 순서대로 그리고 같은 값을 입력하는 위임 메소드를 만들자
		//div.printIncrease(3);
		//div.printDecrease(3);
		
		//2단계 : 사용자가 원하는 층수를 입력 할 수 있도록 제공해주자
		//키보드의 값을 입력받자
//		Scanner scan = new Scanner(System.in);
//		System.out.print("숫자를 입력해주세요 : ");
//		int statge = scan.nextInt();
		
		//3단계 사용자가 입력하는 Scanner를 라이브러리로 만들어서 배포(jar)하고
		// 라이브러리를 프로젝트에 import하여 사용하자. static으로 만들어서 쉽게 사용
		
//		int statge = InputUtil.inputNumber();
//		
//		
//		div.printProcess(statge);	//얘가 위임메소드
		
//		Diamond_If divIf = new Diamond_If();
//		divIf.dia_if(5);
		
		Diamond_MathAPI api = new Diamond_MathAPI();
		api.dia_math_api(5);
		
	}

}
