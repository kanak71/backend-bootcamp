package com.min.edu.dto;

import java.util.Objects;

//사용자 정보를 담을 수 있는(수신-request, 응답-response)
public class InfoDto {
	
	private String name;
	private int age;
	private String address;
	
	//멤버필드를 직접 접근하는 것이 아닌
	//메소드를 통해서 멤버필드를 제어한다 getter/setter 메소드 작성
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	//비교는 같은 곳에서 만들어져야 비교한다. 타입이 같느냐
	@Override
	public int hashCode() {
		return Objects.hash(address, age, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InfoDto other = (InfoDto) obj;
		return Objects.equals(address, other.address) && age == other.age && Objects.equals(name, other.name);
	}
	
	
	
	

}
