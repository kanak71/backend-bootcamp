package com.min.edu.main;

import com.min.edu.payment.Payment;
import com.min.edu.strategy.CardPayment;

//TODO 005 사용자의 결제 선택에 따라서 자동으로 실행된다
public class StrategyMain {

	public static void main(String[] args) {
		Payment cart = new Payment();
		
		//1. 카드  결제 선택
		cart.setPaymentStrategy(new CardPayment());
		cart.checkoyut(5000);
		
		//2. 현금 결제 선택
		cart.setPaymentStrategy(new CardPayment());
		cart.checkoyut(4500);

	}

}
