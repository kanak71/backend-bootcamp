package com.min.edu.compare;

/*
 * String과 new String()의 비교
 */

public class StringCompare {
	
	public static void main(String[] args) {
		int a = 10;
		int b = 10;
		//a와 b는 기본타입, 같은 타입, 같은 값을 가지고 있다
		boolean check = (a == b);	//비교연산자, 기본타입, 값과 타입을 비교한다. 따라서 지금은 true
		System.out.println("기본타입의 비교는 값과 타입이다 : " + check);
		
		int[] a1 = {1, 2, 3};
		int[] b1 = {1, 2, 3};
			
		System.out.println(a1==b1);	//false가 뜬다 -> 참조타입은 주소를 비교하기 때문
		
		System.out.println("=".repeat(20));
		
		String str1 = "Happy";	//Happy라는 글자를 가진 참조타입
		String str2 = str1;	//참조타입은 주소를 전달
		
		String str3 = "Happy";	//Happy라는 글자를 참조타입
		String str4 = new String("Happy");	//new를 통해서 String 객체를 생성
		
		String str5 = "Hap" + "py";	//연산
			
		String tmp1 = "Hap";	//Hap 객체를 만듦
		String tmp2 = "py";		//py 객체를 만듦
		String str6 = tmp1 + tmp2; //참조타입은 연산
		
		//TODO 001 결과 : String의 리터럴 연산은 같은 값을 가진다
		System.out.println("Happy를 한번에 생성한 객체 vs Hap/py를 연산을 통해 생성한 객체 비교");
		System.out.println(str1 == str5);
		
		//TODO 002 결과 : String 각 객체를 연산하면 새로운 객체가 만들어진다
		//				 String의 객체를 연산하면 new String이 된다
		System.out.println("Happy를 한번에 생성한 객체 vs 객체Hap 객체py를 연산을 통해 생성한 객체 비교");
		System.out.println(str1 == str6);
		
		//TODO 003 결과 : new를 통해 반드시 새로운 주소(reference)가 부여된다. false
		System.out.println("리터럴을 입력한 String과 vs new를 통해서 생성한 String");
		System.out.println(str1 == str4);	//참조타입은 주소를 비교하기 때문에
		
		//TODO 004 결과 : 참조타입은 주소를 넘겨주기 때문에 대입연산자는 같다라고 판단한다
		System.out.println("대입연산자를 통해서 참조타입의 주소를 넘겨줌");
		System.out.println(str1 == str2); 
		
		//TODO 005 결과 : new를 하지 않은 같은 값의 String 비교할 경우 같음
		System.out.println("생성과 생성된 String을 비교하면 같다로 나온다");
		System.out.println(str1 == str3);
		
		System.out.println("=".repeat(20));
		
		//VM(virtual machine)에 있는 메모리의 주소는 출력할 수 없다. 메모리가 어디에 할당될 지 모르기 때문에
		//하지만 hascode는 고유값이기 때문에 출력 및 확인이 가능하다
		//java.lang.object; 최상위 부모, 모든 java object를 통해서 생성된, object를 객체의 hashcode를 출력해 주는 기능을 가지고 있다
		//java.lang.object에 있는 hashcode이다.
		
		//String은 객체를 생성하던 new를 생성하던 주소가 다르지 안에 있는 값이 같다면 같은 hashcode를 사용할 수 있다
		System.out.println("str1"+ str1.hashCode());
		System.out.println("str2"+ str2.hashCode());
		System.out.println("str3"+ str3.hashCode());
		System.out.println("str4"+ str4.hashCode());
		System.out.println("str5"+ str5.hashCode());
		                         
	}                                  

}
