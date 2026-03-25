package com.min.edu;

/*
 * TODO 001 각 use 메소드를 구현을 강요하기 위한 클래스
 * 
 * 모든 "제품"이 가져야 할 기본 동작 use()를 추상 메소드로 선언
 * 실제 구현은 구체적인 클래스(IDCard)가 정의한다
 */
public abstract class Product {
	public abstract void use();
}
