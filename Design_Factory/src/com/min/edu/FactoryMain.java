package com.min.edu;

/*
 * Q1. Factory 클래스의 craete() 메소드에 final 키워드를 사용하는 이유는?
 * Q2. create() 메소드에서 내부적으로 호출되는 메소드 2개는?
 * Q3. IDCard가 아닌 Passport, MembershipCard 등을 만들려면 어떠한 클래스를 추가하면 될까?
 */
public class FactoryMain {

	public static void main(String[] args) {
		//생성하고 등록
		Factory fac = new IDCardFactory();
		
		//create() -> 개인사용자를 만듦 : 템플릿패턴
		Product p1 = fac.create("홍길동");
		Product p2 = fac.create("둘리");
		
		//만들어진 카드를 사용
		p1.use();
		p2.use();
		
		IDCardFactory facs = (IDCardFactory)fac;
		System.out.println(facs.getOwners());

	}

}
