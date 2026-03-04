package com.min.edu;

import java.util.Objects;

/*
 * 정보를 담고 있는 객체
 */
public class UserDefinedClass {
	
	private String name = "홍길동";
	private int age = 34;
	
	//Hashcode를 오버라이드 해서 안에는 멤버필드 값으로 새로운 hashcode를 부여해 보도록 하겠다
	
	@Override
	public int hashCode() {
		return Objects.hash(age, name);	//각 hashcode를 합쳐
	}
	@Override
	public boolean equals(Object obj) {	//생성된 class가 같아야지만 비교 대상이 되기 개문에 확인하는 작업
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDefinedClass other = (UserDefinedClass) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
	
	
	
}
