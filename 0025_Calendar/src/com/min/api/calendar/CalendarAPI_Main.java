package com.min.api.calendar;

import java.util.Calendar;

/*
 * API의 선정기준
 * 	: method형 달력은 요구분석 코드를 가지고 작성 => 라이브러리를 개발했다
 * 	: 1. 많이 사용하는 라이브러리를 선정한다 => 호환성 때문에
 * 	  2. 취약점이 적은 라이브러리를 선정한다 => 해킹코드에 취약하다 때문에 해킹에 방어하기 위해서
 * 결론 : 
 * 	1. java.util.Calendar , java.util.LocalDate
 *  2. Calender는 호환성이 좋다, java8까지는 많이 사용했던 객체
 * 		LocalDate는 java 8+ 이상부터는 권고사항으로 되어 있다
 * 변경된 이유 : 
 *  *** 달력을 계산할 때 momth를 입력할 때는 -1, 출력할때는 +1, Array이기 때문에 문제가 될 필요가 있다
 *  	LocalDate는 Calendar에서 cal.set(2026, 3-1, 1) 방식을 쉽게 cal.set(2026, 3, 1)
 */
public class CalendarAPI_Main {

	/*
	 * 정리 : calendar API와 초기값을 많이 입력해야 하는 클래스는 인터페이스를 구현해야 한다
	 * 		달력은 지역, 시간 등의 설정에 의해서 변경된다
	 * 		기본값으로 사용한다(System에 있는 정보를 가져온다) Calendar.getInstance(); 존재하게 된다
	 * 결론 : 아니다 나는 그냥 OS에 의존되어 있는 클래스를 사용하고 싶다
	 * 		미리 구현해놨다
	 * 		GregorianCalendar cal = new GregorianCalendar
	 */
	public static void main(String[] args) {
//		//TODO 101 Calendar API 기본 사용방법
//		Calendar cal = Calendar.getInstance();
//		//필요한 정보의 값을 넣어줌녀 해당 메소드를 실행시켜서 값을 반환해줌
//		System.out.println(cal.get(Calendar.YEAR) + "현재년도");
//		
//		//세팅 : 달력구해야한다. 근데 현재 달력만 원하는게 아니라 특정년월 setting 해준다
//		cal.set(2026, 1-1, 1);	//month 입력 시 -1
//		System.out.println(cal.get(Calendar.DAY_OF_WEEK) + "입력된 요일");
//		System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH) + "최대일수");
	
//	CalendarAPI_Calendar calAPI_Calendar = new CalendarAPI_Calendar();
//	calAPI_Calendar.print_Calendar(2026, 4);
	
	CalendarAPI_LocalDate calAPI_Local = new CalendarAPI_LocalDate();
	calAPI_Local.print_Calendar(2026, 4);

	}

}
