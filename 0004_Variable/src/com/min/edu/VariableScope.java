package com.min.edu;

//TODO 001 변수의 사용 범위 : local, instance, static
public class VariableScope {
	
	// ***클래스 내부의 영역
	
	// 멤버필드 영역(member field)
	public int instanceVariable; // 인스턴스 변수
	public static int staticVariable; // static 변수
	
	// 생성자 영역
	
	// 메소드 영역(method)
	public void localVariable() {
		int localVariable; // 선언
		//byte localVariable;	// 같은 변수명은 한 번만 사용할 수 있다
		
		
		//int instanceVariable; // 메모리에 사용되는 영역이 다르기 때문에 다른 변수로 바라본다 재선언이 가능
		// 만약에 영역이 다른 변수의 값은 변수가 있다면 무조건 local variable이 우선이 된다
		// 20번의 재선언이 되면서 method 내부에서 instanceVariable은 local variable의 역할을 한다
		// 선언만 되어 있고 초기화가 되어 있지 않다. 따라서 오류가 발생한다
		//System.out.println(instanceVariable); -> 오류가 난다
		
		//인스턴스 변수는 선언만 해도 자동으로 초기값으로 값을 입력해준다
		
		 localVariable = 100;
		 System.out.println(localVariable);
	}

}
