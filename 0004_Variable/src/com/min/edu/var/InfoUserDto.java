package com.min.edu.var;

//TODO 003 데이터 전송을 위한 DTO 객체
//		: 데이터를 묶음으로 가지고 다닐 수 있는 객체
//		: 반환타입 반드시 한 개, 반환을 여러개 하고 싶다면 DTO를 사용해야 한다

//클래스이기 때문에 여러 번 생성할 수 있다(객체를 만들 수 있다 new)
public class InfoUserDto {
	
	//멤버필드 영역
	//접근제한자 !!!
	// 1) 멤버필드는 new를 통해서 객체가 생성되면 선언만 되어 있을 경우 단 1회 선언된 타입으로 초기화된다
	// 외부에서 사용하기 위해서 instance 변수는 반드시 new 해야 된다 //heap 영역에 위치함
	
	public String name;
	public String hobby;
	
	//static 변수 //method Area 위치함
	public static String etc;	//호출방식은 클래스명.
	
	
	
	//메소드
	//파라미터와 아규먼트 -> make하는 메소드를 실행시키려면 반드시 int 값을 넣어줘야한다
	//파라미터는 lacal variable로 인식한다
	public void make(int n) {	
		int i=0;
		
		for(int j=0; j<5; j++) {	//for문 내부에서 int j : local variable 외부로 못가져간다
			System.out.println("for문 j : " + (n + j)); //concatenation 문자열과 값이 합쳐지면 무조건 하나의 문자열로 만들어진다
											  // =? "for문 j : 1"
			
		}
		
		//멤버필드있는 변수를 가져옴
		System.out.println(this.name);	//명확하게 내가 가지고 있는 멤버필드의 변수다 this
		System.out.println(this.hobby); //내 클래스에 내 변수
		System.out.println(etc);	//static은 가독성을 위해서 기울어진 글자로 표기된다
		
		
		
		
	}
	
	

}
