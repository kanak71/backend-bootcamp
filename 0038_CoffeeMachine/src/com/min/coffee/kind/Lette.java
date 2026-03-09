package com.min.coffee.kind;

/**
 * 카페라떼 정보를 가지고 있는 클래스
 */
public class Lette implements ICoffeeMenu {

	@Override
	public String getCoffeeName() {
		return "카페라떼";
	}

	@Override
	public int getPrice() {
		return 500;
	}

}
