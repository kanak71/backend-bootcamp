package com.min.edu;

import java.util.Scanner;	//import는 물리적으로 구분되어 있는 클래스의 위치를 명시적으로 나타내는 것

public class IfMain {

	public static void main(String[] args) {
		
		//Scanner 클래스는 java에서 IO(input, output)에서 쉽게 형변환을 통해서 값을 만들어 낼 수 있는 클래스
		Scanner scan = new Scanner(System.in);	//system 메모리, in 읽어옴 => 키보드에 입력한 값을 읽어오는 기능
		System.out.print("정수값을 입력해주세요 : ");
		int input = scan.nextInt();
		System.out.println("입력받은 정수 값 " + input);
		
		//3 4 5 6 7 8 9 10 -> 입력하는 숫자, 3그룹으로 구분하는 if문을 만들어라
		if(input % 3 == 0) {
			System.out.println("3으로 나눠진다");
		} else if(input % 3 == 1) {
			System.out.println("나머지가 1");
		} else if(input % 3 == 2) {
			System.out.println("나머지가 2");
		}
		
		
		// 홀수 / 4의 배수 / 4의 배수로 나눠서 2가 남는 것 => 이런거 만들어보자
		if(input % 2 == 1) {
			System.out.println("홀수이다");
		} else if(input % 4 == 0) {
			System.out.println("4의 배수입니다");
		} else if(input % 4 == 2) {
			System.out.println("4의 배수로 나눠서 2가 남습니다");
		}
		
		
		
		if(input > 0) {
			System.out.println("입력받은 값은 양수이다");
		} else {
			System.out.println("입력받은 값은 음수이다");
		}
		
		//여러개의 조건절
		if(input == 1) {
			System.out.println("1이 입력됨");
		}else if(input == 2) {
			System.out.println("2이 입력됨");
		}else if(input == 3) {
			System.out.println("3이 입력됨");
		}else {
			System.out.println("4이상의 값을 입력함");
			
		}
		
	}

}
