package com.min.edu;

//TODO 002 추상클래스는 extends 해서 use()를 구현
// 입력받은 문자열의 값을 멤버필드에 저장
public class IDCard extends Product {
	
	private String owner;
	
	

	public IDCard(String owner) {
		System.out.println(owner + "의 카드를  만듭니다");
		this.owner = owner;
	}



	@Override
	public void use() {
		System.out.println(owner + "의 카드를 사용했습니다");
	}


	@Override
	public String toString() {
		return "IDCard [owner=" + owner + "]";
	}
	
	

}
