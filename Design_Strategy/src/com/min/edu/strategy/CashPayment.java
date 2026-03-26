package com.min.edu.strategy;

import com.min.edu.comm.PaymentStrategy;

//TODO 003 현금으로  결제하는 전략
public class CashPayment implements PaymentStrategy {

	@Override
	public void pay(int amount) {
		System.out.println(amount +"원을 현금으로 결제합니다");
	}

}
