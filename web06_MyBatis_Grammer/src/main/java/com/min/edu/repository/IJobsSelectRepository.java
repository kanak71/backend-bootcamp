package com.min.edu.repository;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.JobsDto;

public interface IJobsSelectRepository {
	
	/*
	 * TODO 012 기본타입을 이용한 Parameter의 전달과 결과값 받기
	 */
	public Integer select01(String id);	//가능하면 id와동일하게 사용??
	
	//TODO 013 기본타입을 이용한 Parameter의 전달과 DTO로 결과값 받기
	
	public JobsDto select02(String job_id);
	
	//TODO 014 컬럼명이 다른경우 <ResultMap>을 사용하여 결과값 받기
	
	public JobsDto select03(String job_id);
	
	//TODO 015 결과를 JAVA의 JCF 객체인 java.util.Map으로 결과값 받기
	
	public Map<String, JobsDto> select04(String job_id);
	
	//TODO 016 입력되는 값을 여러개 전달하기 위해서 DTO 객체로 전달한다
	//			DTO 객체의 getter를 통해서 전달된다
	
	public JobsDto select05(JobsDto inDto);
	
	//TODO 017 결과를 여러개를 받기 위해서 myBatis의 selectList()로 실행한다
	public List<JobsDto> select06();
	
	//TODO 018 Parameter를 여러개 전달하기 위해서 java.util.Map 객체로 전달한다
	public List<JobsDto> select07(Map<String, Object> map);
	
	//TODO 019 SQL문의 <(미만)과 같은 HTML 문법을 문자로 인식시키는 CDATA 처리
	public List<JobsDto> select08(Object obj);
	
	

}
