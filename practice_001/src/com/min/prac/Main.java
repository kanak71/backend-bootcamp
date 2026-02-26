package com.min.prac;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력: ");
		int n = sc.nextInt();
		
		Divisors dv = new Divisors();
		
		//1번문제
		int sum = dv.DivisorSum(n);
		System.out.println("1번 문제 : " + sum);
		
		//2번문제
		if(n == dv.DivisorSum(n)) {
			System.out.println("완전수입니다");
		} else {
			System.out.println("완전수가 아닙니다");
		}
		
		//3번문제
		int count = 0;
		
		for(int i=1; i<=10000; i++) {
			
			int sum1 = dv.DivisorSum(i);
			int sum2 = dv.DivisorSum(sum1);
			
			if(i == sum2 && i != sum1) {
				System.out.println(i + "와" + sum1 + "은 친화수");
				count++;
			}
		}
		System.out.println("친화수 개수 : " + count/2);
		
	}

}
