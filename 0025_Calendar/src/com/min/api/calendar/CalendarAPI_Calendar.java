package com.min.api.calendar;

import java.util.Calendar;

public class CalendarAPI_Calendar {
	
	public void print_Calendar(int year, int month) {
		System.out.printf("\t\t%d년도\t%d월\n", year, month);
		System.out.printf("일\t월\t화\t수\t목\t금\t토\n");
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, 1);
		
		//앞의 공백
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		//최대 일수
		int dayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		//이전 달의 최대일수
		cal.set(year, month-2, 1);
		int beforeOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		//출력
		//이전 달력 일수 출력
		for (int i = beforeOfMonth - dayOfWeek + 1; i <= beforeOfMonth; i++) {
			System.out.printf("%d\t" ,i);
		}
		
		//달력 일 수 출력
		for (int i = 1; i <= dayOfMonth; i++) {
			System.out.printf("%d\t" ,i);
			if((dayOfWeek+i)%7 == 0) {
				System.out.println();
			}
		}
		
		//달력 후 일수 출력
		int afterDays = 7 - (dayOfMonth + dayOfWeek)%7;
		for (int i = 1; i <= afterDays; i++) {
			System.out.printf("%d\t" ,i);
		}
	}

}
