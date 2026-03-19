package com.min.edu.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.min.edu.comm.Database;
import com.min.edu.dto.EmployeeDto;

//TODO 006 정의된 Emp 테이블의 CRUD 기능을 구현하는 클래스
// Database 공통모듈(1, 2, 6 단계)
// IEmployeeRepository CRUD의 기능을 정의해놓은 interface
public class EmployeeRepositoryImpl extends Database implements IEmployeeRepository {

	//TODO 007 전체조회, 1단계 2단계 부모			          6단계
	//		구현해야 될것	           3단계 ~ 5단계 작성(구현)
	
	@Override
	public List<EmployeeDto> getAllEmp() {
		List<EmployeeDto> lists = new ArrayList<EmployeeDto>();
		//1단계 부모가 해준다
		//2단계는 부모가 가지고있다
		String sql = "SELECT e.EMPNO, e.ENAME , e.JOB , TO_CHAR(e.HIREDATE, 'YYYY-MM-DD') HDATE, e.DEPTNO"
				+ "	FROM EMP e"
				+ "	ORDER BY e.HIREDATE DESC";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			System.out.println("2단계 커넥션 연결 성공");
			
			pstmt = conn.prepareStatement(sql);
			System.out.println("3단계 쿼리준비 성공");
			
			rs = pstmt.executeQuery();
			System.out.println("4단계 쿼리실행 성공");
			
			while(rs.next()) {	//객체가 있는지 여부를 판단
				EmployeeDto dto = new EmployeeDto();
				dto.setEmpno(rs.getInt("EMPNO"));
				dto.setEname(rs.getString("ENAME"));
				dto.setJob(rs.getString("JOB"));
				dto.setHdate(rs.getString("HDATE"));
				dto.setDeptno(rs.getInt("DEPTNO"));
				lists.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println("getAllEmp 전체조회 실패");
			e.printStackTrace();
		} finally {
			closed(rs, pstmt, conn);
		}
		
		return lists;
	}

	//TODO 009 상세조회를 getOneEMp
	@Override
	public EmployeeDto getOneEmp(int empno) {
		EmployeeDto dto = new EmployeeDto();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT e.EMPNO, e.ENAME , e.JOB , TO_CHAR(e.HIREDATE, 'YYYY-MM-DD') HDATE, DEPTNO, d.DNAME"
				+ "	FROM EMP e JOIN DEPT d"
				+ "	USING(DEPTNO)"
				+ "	WHERE EMPNO = ?";
		
		try {
			conn = getConnection();
			System.out.println("2단계 커넥션 연결 성공");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			System.out.println("3단계 쿼리준비 성공");
			
			rs = pstmt.executeQuery();
			System.out.println("4단계 쿼리실행 성공");
			
			while(rs.next()) {
				dto.setEmpno(rs.getInt("EMPNO"));
				dto.setEname(rs.getString("ENAME"));
				dto.setJob(rs.getString("JOB"));
				dto.setHdate(rs.getString("HDATE"));
				dto.setDeptno(rs.getInt("DEPTNO"));
				dto.setDname(rs.getString("DNAME"));
			}
			System.out.println("5단계 결과값 받기 성공");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closed(rs, pstmt, conn);
		}
		
		return dto;
	}

	//TODO 011 setEmp dto로 입력받아 ENAME, DEPTNO를 전달함
	@Override
	public int setEmp(EmployeeDto dto) {
		int chk = 0;
		
		String sql = "INSERT INTO EMP (EMPNO, ENAME, HIREDATE, "
				+ "				DEPTNO)"
				+ "		VALUES( (SELECT MAX(EMPNO)+1 FROM EMP ),"
				+ "		?, SYSDATE, ? )";
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			System.out.println("2단계 성공");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEname());
			pstmt.setInt(2, dto.getDeptno());
			System.out.println("3단계 성공");
			
			// insert / update / delete는 실행하는 executeUpdate()이다
			chk = pstmt.executeUpdate();
			System.out.println("4단계 성공");
			
			System.out.println("insert/delete/update는 성공한 row의 개수를 가져온다");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closed(rs, pstmt, conn);
		}
		
		return chk;
	}

	//TODO 013 삭제
	@Override
	public int delEmp(int empno) {
		
		int chk = 0;
		String sql = "DELETE FROM EMP WHERE EMPNO = ?";
				
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			System.out.println("2단계 성공");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			System.out.println("3단계 성공");
			
			chk = pstmt.executeUpdate();
			System.out.println("4단계 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closed(rs,pstmt, conn);
		}	
		
		return chk;
	}
	//TODO 015 수정 argument를 두개 입력받는다
	@Override
	public int updateEmp(String job, int empno) {
		int chk = 0;
		
		String sql = "UPDATE EMP e SET JOB = ?"
				+ "	WHERE EMPNO = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			System.out.println("2단계 성공");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, job);
			pstmt.setInt(2, empno);
			System.out.println("3단계 성공");
			
			chk = pstmt.executeUpdate();
			System.out.println("4단계 성공");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closed(rs, pstmt, conn);
		}
		
		return chk;
	}

}
