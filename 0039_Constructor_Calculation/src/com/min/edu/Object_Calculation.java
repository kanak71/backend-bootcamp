package com.min.edu;

//TODO 002 객체를 입력받아 연산을 한 후에 객체를 반환하는 메소드
public class Object_Calculation {
	
	//값(ValueNM n, m)을 가진 객체, 두개를 입력받아
	//각 객체에 입력되어 있는 n:n, m:m 값을 더하여
	//더한 결과를 ValueNM으로 반환하는 메소드
	public static ValueNM add(ValueNM nm1, ValueNM nm2) {
		return new ValueNM(nm1.getN()+nm2.getN(), nm1.getM()+nm1.getM());
		
	}

}
