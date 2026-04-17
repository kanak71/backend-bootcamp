package com.min.edu.bean01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//TODO 001 기능의 결과를 반화하는 DTO -> POJO
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FunctionExecutionDto {
	
	private String msg;
	private String device;
	
	
}
