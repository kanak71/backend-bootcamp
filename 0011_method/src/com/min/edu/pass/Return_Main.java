package com.min.edu.pass;

public class Return_Main {
	
	//TODO 202 Argument 두개를 전달하고 반환되는 문자열을 출력

	public static void main(String args[]) {
		Return_Method rm = new Return_Method();
		String msg = rm.retunValue("전민균", 10);
		System.out.println("반환출력 : " + msg); //concat, String.format : binding 문법
		
		rm.myPrint("출력해주세요");
	}
}
