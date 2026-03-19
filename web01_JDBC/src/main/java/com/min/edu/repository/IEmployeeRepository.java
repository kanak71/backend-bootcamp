package com.min.edu.repository;

import java.util.List;

import com.min.edu.dto.EmployeeDto;

//TODO 004 Script 파일에서 테스트한 쿼리의 실행을 위한 CRUD 기능의 추상 메소드 정의
public interface IEmployeeRepository {
	
	// 전체조회
	public List<EmployeeDto> getAllEmp();
	
	//상세조회
	public EmployeeDto getOneEmp(int empno);
	
	// 입력
	public int setEmp(EmployeeDto dto);
	
	//삭제
	public int delEmp(int empno);
	
	//수정
	public int updateEmp(String job, int empno);

}
