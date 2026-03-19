package com.min.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.min.edu.comm.Database;
import com.min.edu.dto.EmployeeDto;
import com.min.edu.repository.EmployeeRepositoryImpl;
import com.min.edu.repository.IEmployeeRepository;

public class JDBC_JUnitTest {

	//TODO 003 생성된 공통 모듈의 Driver로딩/연결 객체 테스트
//	@Test
//	public void createConnectionTest() throws SQLException {
//		Database db = new Database() {};
//		Connection conn = db.getConnection();
//		assertNotNull(conn);
//		
//	}
	
	//TODO 008 전체조회 getAllEmp 테스트
	
	private IEmployeeRepository repository;
	
	@Before 
	public void createRepository() {
		repository = new EmployeeRepositoryImpl();
	}
	
	
//	@Test
	public void getAllEmpTest() {
		List<EmployeeDto> lists = repository.getAllEmp();
		System.out.println(lists);
		assertNotEquals(0, lists.size());
	}
	
	//TODO 010 상세조회 getOneEmp테스트
	//@Test
	public void getOneEmpTest() {
		EmployeeDto dto = repository.getOneEmp(7698);
		System.out.println(dto);
		assertNotNull(dto);
	}
	
	//TODO 012 입력 setEmp 테스트
//	@Test
	public void setEmpTest() {
		EmployeeDto inDto = new EmployeeDto();
		inDto.setEname("victory");
		inDto.setDeptno(20);
		
		int cnt = repository.setEmp(inDto);
		assertEquals(1, cnt);
	}
	
	//TODO 014  delEmp 테스트
//	@Test
	public void delEmptest() {
		int empno = 7935;
		
		int cnt = repository.delEmp(empno);
		assertEquals(1, cnt);
	}
	
	//TODO 016 updateEmp 테스트
	@Test
	public void updateEmp() {
		String job ="IT";
		int empno = 7369;
		int cnt = repository.updateEmp(job, empno);
		assertEquals(1, cnt);
	}
	
	
	
	
	
	
	
	
	

}
