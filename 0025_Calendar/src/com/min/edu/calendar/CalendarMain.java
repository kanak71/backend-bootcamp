package com.min.edu.calendar;

public class CalendarMain {

	public static void main(String[] args) {
		
//		//첫번째 테스트
//		//테스트 조건 : 2026까지 몇개의 윤년판단
//		//				4년 윤년, 100년 평년, 400윤년
		Calendar cal = new Calendar();
//		boolean isc01 = cal.isCheckLeap(4);
//		boolean isc02 = cal.isCheckLeap(100);
//		boolean isc03 = cal.isCheckLeap(400);
//		System.out.println(isc01);
//		System.out.println(isc02);
//		System.out.println(isc03);
//		
//		int chk = 0;
//		for(int i=1; i<= 2026; i++) {
//			if(cal.isCheckLeap(i)) {
//				chk++;
//			}
//		}
//		
//		System.out.println(chk);
		
		//두번째 테스트 2026년 이전까지(1~2025)의 일수는?
//		int days = cal.calDays(2026);
//		System.out.println(days);
		
		//세번째 테스트 2026년 3월 이전까지의 일수
//		int days= cal.calDays(2026, 3);
//		System.out.println(days);
		
		//네번째 테스트 2026년 3월 4일 까지의 일수
		int days = cal.calDays(2026, 3, 4);
		System.out.println(days);
	}

}
