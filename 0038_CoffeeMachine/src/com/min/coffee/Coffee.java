package com.min.coffee;


/**
 * 커피 종류, 가격, 잔돈을 가지고있는 클래스
 * @author 82108
 * @since 2026. 03. 09
 */
public class Coffee {
	
	//TODO 001 커피종류, 가격, 잔돈을 저장하는 멤버필드
	private String CoffeeName;
	private int price;
	private int pay;
	private int cup;
	
	/**
	 * 커피 객체를 생성하기 위한 생성자
	 * @param coffeeName 커피명
	 * @param price 가격
	 * @param pay 잔돈
	 * @param cup 출력된 커피의 잔수
	 */
	public Coffee(String coffeeName, int price, int pay, int cup) {
		super();
		CoffeeName = coffeeName;
		this.price = price;
		this.pay = pay;
		this.cup = cup;
	}

	/**
	 * 외부에서 커피명을 가져갈 수 있는 get 메소드
	 * @return String 커피명
	 */
	public String getCoffeeName() {
		return CoffeeName;
	}

	/**
	 * 외부에서 커피 가격을 가져갈 수 있는 get 메소드
	 * @return int 커피가격
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 외부에서 커피 잔돈을 가져갈 수 있는 get 메소드
	 * @return int 잔돈
	 */
	public int getPay() {
		return pay;
	}

	/**
	 * 외부에서 커피 개수를 가져갈 수 있는 get 메소드
	 * @return int 커피 잔 수
	 */
	public int getCup() {
		return cup;
	}
	
	
	
	
	

}
