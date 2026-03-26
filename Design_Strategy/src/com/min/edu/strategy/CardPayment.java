package com.min.edu.strategy;

import com.min.edu.comm.PaymentStrategy;

//TODO 002 카드로 결제하는 전략
public class CardPayment implements PaymentStrategy {

	@Override
	public void pay(int amount) {
		System.out.println(amount+ "원을 신용카드로 결제합니다");
	}

}
