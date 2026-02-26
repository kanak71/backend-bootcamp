package com.min.edu;

import java.util.Scanner;

public class SwitchMain {

	public static void main(String[] args) {
		//TODO 001 switch ~ case 문 선택 조건문, IF문과는 다르게 선택된 한개만 값을 판단하여 실행된다
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		/*
		 * IF문은 조건절 처리 한다 : 비교연산 == > < 를 사용해서 조건을 처리
		 * switch ~ case문은 조건절이 "선택 조건"을 처리 한다 : 타입이 같고 값이 같은 경우
		 * 
		 * 범위가 있으면 if문 사용, 범위가 없으면 switch문 사용
		 */
		
		//if(key==value) {} : 절대 IF으로 변경하지 마세요
		switch (n) {	//입력되는 값 : n 값은 타입이 int이다
		case 0:		//value 비교되는 값 : 따라서 비교되는 value 값은 반드시 int여야 한다
			System.out.println(n + "는 0이다");
			break;
		case 1:		//value 비교되는 값 : 따라서 비교되는 value 값은 반드시 int여야 한다
			System.out.println(n + "는 1이다");
			break;

		default:
			System.out.println("다른값");
			break;
		}
		
		//TODO 002 java 7이후부터는 문자열도(String)도 비교가 가능하다(이전 버전은 정수만)
		String fruit = "apple";
		
		switch (fruit) {
		case "apple":	// value는 항상 입력되는 타입과 같아야 한다"
			System.out.println("apple은 한국어로 사과입니다");
			break;

		default:
			System.out.println("한국어로 과일 이름이 없습니다");
			break;
		}
		
		//TODO 003 java 14버전 이후부터는 case가 아닌 표현식( =, arrow Expression)도 사용이 가능하다
		String result; //선언만 되어 있음
		int key = 1;
		switch (key) {
		case 1: result = "하나"; break;
		case 2: result = "둘"; break;

		default:
			result = "다른숫자";
		}
		System.out.println("표현식을 통한 외부로 값 전달 : " + result);
		
		
		//TODO 004 Arrow expression
		String result2;
		switch (key) {	//key는 1이 입력되고있다(위에 int)
		case 1 -> result2 = "하나";
		case 2, 3 -> result2 = "두개 세개";
		
		
		default ->
			result2 = "다른숫자";
		}
		System.out.println("Arrow Expression을 통한 처리 : " + result2);
		
		
		//TODO 005 004까지는 변수에 재입력을 통해서 값을 전달 받아서 사용했다. switch 문이 반환할 수 있도록 만들자
		String result2_1 = switch (key) {	//key는 위에 1이라 되어있다
				case 1 -> "하나";
				
				default -> "unknown";
		};
		System.out.println("switch문은 반환도 됩니다 : " + result2_1);
		
		//TODO 006 yield
		//하나 이상의 표현식이 필요한 경우 전체 코드 블록이 포함 될 수 있다
		//이러한 블럭에서 yield 문은 switch 표현이 평가할 값을 지정하는데 사용된다
		
		String result4 = switch (key) {
				case 1 -> "하나";
				case 2, 3 -> "둘 셋";
				
				default ->{	//블럭으로 묶어줘야한다
					if(key >4) {	//논리적으로 문제가 생긴 코드
						yield "사";
					} else {
						yield "많음";	//death code 도달하지 않는 코드
					}
				}
				
			};	
			
		int nm = 10;
		System.out.println("yield : " + result4);
		
		
	}

}
