package com.min.edu.payment;

import com.min.edu.comm.PaymentStrategy;

//TODO 004 결제수단을 입력 받은 객체에 따라서 선택되도록 한다
public class Payment {
	
	private PaymentStrategy paymentStrategy;

	//전략을 설정하는 메소드(실행중에 변경이 가능)
	public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}
	
	public void checkoyut(int amount) {
		if(paymentStrategy == null) {
			return;
		}
		
		paymentStrategy.pay(amount);
	}
	
	

}
