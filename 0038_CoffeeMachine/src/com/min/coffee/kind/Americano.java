package com.min.coffee.kind;

/**
 * 아메리카노 정보를 가지고 있는 클래스
 */
public class Americano implements ICoffeeMenu {

	@Override
	public String getCoffeeName() {
		return "아메리카노";
	}

	@Override
	public int getPrice() {
		return 200;
	}

}
