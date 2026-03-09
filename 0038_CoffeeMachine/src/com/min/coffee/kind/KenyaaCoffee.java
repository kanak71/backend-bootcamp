package com.min.coffee.kind;

/**
 * 케냐AA 정보를 가지고 있는 클래스
 */
public class KenyaaCoffee implements ICoffeeMenu {

	@Override
	public String getCoffeeName() {
		return "케냐AA";
	}

	@Override
	public int getPrice() {
		return 300;
	}

}
