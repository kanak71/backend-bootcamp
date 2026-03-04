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
}
