package com.min.edu.machine;

import com.min.coffee.Coffee;
import com.min.coffee.kind.ICoffeeMenu;
import com.min.coffee.print.CoffeePrint;

/**
 * 커피 출력을 위해 입력금액과, 커피 종류를 처리하는 클래스
 * @author 82108
 * @since 2026. 03. 09
 */
public class CoffeeMachine {
	
	/**
	 * 최종적인 구매커피를 입력받아 출력하는 프로세스
	 * @param money 입력 금액
	 * @param menu 선택한 커피
	 */
	public void coffeeProcess(int money, ICoffeeMenu menu) {
		int cup = coffeeMake(money, menu.getPrice());
		int pay = coffeePay(money, menu.getPrice());
		
		Coffee order = new Coffee(menu.getCoffeeName(), menu.getPrice(), pay, cup);
		
		CoffeePrint.print(order);
	}
	
	private int coffeeMake(int money, int price) {
		return money / price;
	}
	
	private int coffeePay(int money, int price) {
		return money%price;
	}

}
