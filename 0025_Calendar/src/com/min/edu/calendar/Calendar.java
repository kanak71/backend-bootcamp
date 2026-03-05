package com.min.edu.calendar;

/*
 * 정의 : 원하는 달력을 출력하기 위해서 전일수의 전체 일수가 필요하다
 */

public class Calendar {
	
	//각 평년과 윤년의 최대일수를 정의
	private final int[] LEAP = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private final int[] PLAIN = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	//TODO 001 윤년판단 메소드
	/**
	 * 입력받은 년도를 판단하여 윤년/평년을 반환한다.
	 * 윤년이란 ? 4년에 한번 100년은 아니고 400년은 윤년이 된다
	 * @param year int 년도
	 * @return 윤년 true, 평년 false
	 */
	public boolean isCheckLeap(int year) {
		boolean isc = false;
		if(year%4==0 && year%100 != 0 || year%400 == 0) {
			isc = true;
		}
		return isc;
	}
	
	//TODO 002 년도를 누적하는 메소드
	/**
	 * 입력받은 년도 이전까지 일수를 누적해서 계산해주는 메소드<br>
	 * 윤년은 366으로 처리하고 평년은 365일로 계산한다
	 * @param year 구하고자 하는 년도의 범위
	 * @return 해당년도 이전까지의 일수를 누적 값
	 */
	
	public int calDays(int year) {
		int days = 0;
		for (int i = 1; i < 2026; i++) { //1~2025
			if(isCheckLeap(i)) { //입력되는 년도를 판단
				days+=366;
			} else {
				days+=365;
			}
			
		}
		
		return days;
	}
	
	//TODO 003 구하고자 하는 년도와 월 이전의 일수의 합
	/**
	 * 입력받은 년도/월 이전까지의 누적 일수 계산
	 * @param year 월을 계산할 기준의 년도
	 * @param month 이전월까지 계산할 기준 월
	 * @return 년도 이전의 최대일수 + 기준년도의 월 이전 최대일수
	 */
	public int calDays(int year, int month) {
		int days = calDays(year);
		
		for (int i = 1; i < month; i++) {	//month 이전까지
			if(isCheckLeap(year)) {	//현재 월을 계산하는 년도의 윤년여부
				days += LEAP[i]; //값은 1부터, index는 0부터
			} else {
				days += PLAIN[i-1];
			}
			
		}
		return days;
		
	}
	
	//TODO 004 일수까지의 누적 일 계산
	public int calDays(int year, int month, int day) {
		int days = calDays(year, month);
		return days += day;
	}
	
	//TODO 005 입력하는 월에 최대일수 LEAF[] PLAIN[]에서 가져오면 된다. -1로 계산해야한다
	
	/**
	 * 입력받은 월의 최대 일수를 구함
	 * @param year 해당년도
	 * @param month 해당월
	 * @return 윤년/평년을 판단하여 LEAF[] or PLAIN[]에서 월 -1을 통해서 index의 값을 가져온다
	 */
	public int getDayMonth(int year, int month) {
		int days = 0;
		if(isCheckLeap(year)) { //윤년(true)/평년 판단
			days = LEAP[month-1];
		} else {
			days = PLAIN[month-1];
		}
		return days;
		
	}
	
	//TODO 007 이전달력의 최대일수를 구하기 위한 메소드
	//			1월의 이전달력은 12월이 되어야 하기 때문에
	public int beforeDays(int year, int month) {
		int beforeDays = 0;
		
		if(month == 1) {
			beforeDays = 31;
		} else {
			beforeDays = getDayMonth(year, month -1);
		}
		
		return beforeDays;
	}
	
	//TODO 006 출력
	public void print_calendar(int year, int month) {
		System.out.printf("\t\t%d년도\t%d월\n", year, month);
		System.out.printf("일\t월\t화\t수\t목\t금\t토\n");
		//원하는 년도월의 첫번째 요일을 알고 있어야 출력
		int dayOfWeek = calDays(year, month, 1)%7;
		int dayOfMonth = getDayMonth(year, month);
		
		int beforeDayOfMonth = beforeDays(year,month);
		
//		//1시작 까지의 공백을 출력
//		for (int i = 0; i < dayOfWeek; i++) {
//			System.out.printf("%s\t","-");
//		}
		
		for (int i= beforeDayOfMonth - dayOfWeek+1; i <= beforeDayOfMonth; i++) {
			System.out.printf("%d\t",i);
		}
		
		for (int i = 1; i <= dayOfMonth; i++) {
			System.out.printf("%d\t",i);
			if((dayOfWeek+i)%7==0) {
				System.out.println();
			}
		}
		
		//다음달의 1일부터 나머지 공백을 채움
		int afterDays = 7- (dayOfWeek + dayOfMonth)%7;
		for (int i = 1; i <= afterDays; i++) {
			System.out.printf("%d\t",i);
			
		}
	}
	
	
	
	
}
