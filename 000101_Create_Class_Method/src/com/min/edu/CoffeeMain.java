package com.min.edu;

//TODO 000101_03 객체를 생성하고 실행하는 main 메소드를 가진 main 클래스
public class CoffeeMain {

	//TODO etc 01 메인메소드 : 프로그램의 시작과 끝
	public static void main(String[] args) {
		//instance화를 통해서 Machine을 사용할 수 있다
		//메모리에 Machine이 올라가 있다
		Machine myCoffee = new Machine();
		Coffee orderCoffee = myCoffee.order();
		
		System.out.println(orderCoffee.name);
		System.out.println(orderCoffee.sugar);

	}

}

