package com.min.api.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;

public class CalendarAPI_LocalDate {

	public void print_Calendar(int year, int month) {

		System.out.printf("\t\t%d년도\t%d월\n", year, month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");

		LocalDate firstDay = LocalDate.of(year, month, 1); // month를 연산 하지 않고 넣어도 된다

		int dayOfWeek = firstDay.getDayOfWeek().getValue() % 7;

		int dayOfMonth = firstDay.lengthOfMonth();

		LocalDate prevMonth = firstDay.minusMonths(1);
		int beforeOfMonth = prevMonth.lengthOfMonth();

		// 출력
		// 이전 달력 일수 출력
		for (int i = beforeOfMonth - dayOfWeek + 1; i <= beforeOfMonth; i++) {
			System.out.printf("%d\t", i);
		}

		// 달력 일 수 출력
		for (int i = 1; i <= dayOfMonth; i++) {
			System.out.printf("%d\t", i);
			if ((dayOfWeek + i) % 7 == 0) {
				System.out.println();
			}
		}

		// 달력 후 일수 출력
		int afterDays = 7 - (dayOfMonth + dayOfWeek) % 7;
		for (int i = 1; i <= afterDays; i++) {
			System.out.printf("%d\t", i);
		}

	}
}