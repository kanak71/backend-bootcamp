package com.min.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//TODO 002 JOBS 테이블과 연결되는 DTO 객체를 생성
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JobsVo {

	private String job_id;
	private String job_title;
	private int min_salary;
	private int max_salary;

}
