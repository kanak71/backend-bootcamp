package com.min.edu;

public class SingleTon_Main {

	public static void main(String[] args) {
//		SingleFactory sf = new SingleFactory();
		
		//테스트 : 객체가 한번만 생성되는지
		
		SingleFactory sf1 = SingleFactory.getInstance();
		SingleFactory sf2 = SingleFactory.getInstance();
		
		//주소가 같은지 확인
		System.out.println(sf1 == sf2);
		//hashcode도 같은지 확인
		System.out.println(sf1.equals(sf2));
	}

}
