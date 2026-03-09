package com.min.edu.machine;

import java.util.Scanner;

import com.min.coffee.kind.Americano;
import com.min.coffee.kind.ICoffeeMenu;
import com.min.coffee.kind.KenyaaCoffee;
import com.min.coffee.kind.Lette;

/**
 * 커피 솔루션을 동작시키는 main 클래스
 * @author 82108
 * @since 2026. 03. 09
 */
public class CoffeeMain {
	/**
	 * Scanner를 통해서 커피의 종류 및 입력 금액을 처리하는 main 메소드
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		CoffeeMachine machine = new CoffeeMachine();
		
		System.out.println("---------- 커피 메뉴 ----------");
		System.out.println("1. 케냐AA (300)");
		System.out.println("2. 아메리카노 (200)");
		System.out.println("3. 카페라떼 (500)");
		
		System.out.println("메뉴 선택 :");
		int menu = sc.nextInt();
		
		System.out.println("돈 입력 :");
		int money = sc.nextInt();
		
		ICoffeeMenu coffee = null;
		
		
		switch (menu) {
		case 1: coffee = new KenyaaCoffee(); break;
		case 2: coffee = new Americano(); break;
		case 3: coffee = new Lette(); break;

		default:
			System.out.println("잘못된 메뉴");
			return;
		}
		
		machine.coffeeProcess(money, coffee);
		sc.close();
	}

}
