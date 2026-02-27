package com.lion.like.util;

import java.util.Scanner;

/**
 * Diamond에서 정수값을 입력받는 기능을 가지고있는 클래스
 * @since 2026.02.27
 * @author KangNaKyung
 * @version 1.0b
 */
public class InputUtil {
	
	/**
	 * 콘솔에 숫자를 입력하면 해당 숫자를 값으로 반환해주는 IO메소드
	 * @return 입력 받은 숫자 값
	 */
	public static int inputNumber() {
		Scanner scan = new Scanner(System.in);
		System.out.print("사용할 정수를 입력해 주세요 : ");
		int num = scan.nextInt();
		return num;
	}

}
																															