package com.min.edu.pa;

//TODO 101 Parameter란? 매개변수, 메소드를 실행시키기 위한 필수 값을 전달받아 가지고있는 변수
public class Parameter_Argument {
	
	/**
	 * @author 82108
	 * @since 2026.02.26
	 * make_method는 전달받은 값을 "당신의 이름은?"을 붙여서 출력해주는 메소드
	 * @param String 타입의 값을 필요로 한다
	 */
	
	public void make_method(String name) {	//name이 Parameter다
		//name에 따라서 출력된 값이 변화한다
		System.out.println("당신의 이름은?" + name);	//외부에서 전달받은 name을 변수를 사용하여 출력
	}

}
