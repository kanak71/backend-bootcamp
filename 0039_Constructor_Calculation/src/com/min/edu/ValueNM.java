package com.min.edu;

//TODO 001 두개 멤버필드를 가지고 있고, 입력과 호출이 가능한 클래스
//		입력은 생성자를 통해서 입력, setter 메소드를 통해서 입력하는 것
//결론 : DTO객체를 만들겠다 : Encapsulation 은닉화 객체 - 데이터의 보호를 위해서 사용
public class ValueNM {
	
	//1) 멤버필드를 private 작성 : 외부에서 접근이 불가능하다
	private double m;
	private double n;
	
	//---------------------- 생성자 오버로딩
	//멤버필드를 통해서 객체 생성시에만 입력 할 수 있도록 하는 생성자
	// 주의점 : 생성자 Overloading을 하면 default 생성자는 사라진다. 필요시 명시적으로 작성해 줘야 한다
	
	public ValueNM(double m, double n) {
		super();
		this.m = m;
		this.n = n;
	}
	
	public double getM() {
		return m;
	}
	public void setM(double m) {
		this.m = m;
	}
	public double getN() {
		return n;
	}
	public void setN(double n) {
		this.n = n;
	}
	
	//2) 접근 가능 멤버 메소드를 작성한다
	// ㄴ 입력만 되는 set으로 시작되는 메소드, Setter 메솓,
	// ㄴ 값을 가져갈 수 있는 get으로 시작하는 메소드, Getter 메소드
	
	

}
