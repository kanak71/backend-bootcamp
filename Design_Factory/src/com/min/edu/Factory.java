package com.min.edu;

//TODO 003 각 클래스에서 카드를 발급, 등록리스트 구현하게 만드는 클래스
public abstract class Factory {
	
	/*
	 * 클로저 함수
	 */
	public final Product create(String owner) {
		Product p = createProduct(owner);
		registProduct(p);
		return p;
	}
	
	/*
	 * 값을 입력받아서 Product 객체를 생성하는 메소드
	 */
	public abstract Product createProduct(String owner);
	
	/*
	 * 생성된 Product 객체를 모아서 관리해주는 메소드
	 */
	public abstract void registProduct(Product product);
	
	

}
