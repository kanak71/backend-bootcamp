package com.min.edu.anno03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//TODO 010 주입을 받는 방법에 대해서 설명하는 Bean 클래스
@Slf4j
@Service
//@RequiredArgsConstructor	//자동으로 필요한 객체가 주입된다. 타입이 하나니깐
public class UserServiceImpl implements IUserService {
	
	//1. 생성자 주입
	//final을 처음 class가 생성될 때 값이 초기화 되어야한다
	//멤버필드가 final로 선언되어 있다는 것은 "반드시 생성자를 통해서 입력"하겠다
//	private final UserDto dto; 
	
//	//2. 필드(멤버필드) 주입
//	@Autowired
//	@Qualifier("userDto")
//	private UserDto userDto;
	
	//3. Setter 주입
	private UserDto dtoSetter;
	
	@Autowired
	@Qualifier("userDto")
	public void setDtoSetter(UserDto dtoSetter) {
		this.dtoSetter = dtoSetter;
	}
	
	
	@Override
	public void addUser() {
		

	}


}
