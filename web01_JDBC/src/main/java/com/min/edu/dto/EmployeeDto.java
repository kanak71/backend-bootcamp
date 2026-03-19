package com.min.edu.dto;


//TODO 004 쿼리문의 결과와 입력시 사용하는 DTO 객체
public class EmployeeDto {
	
	
	private int empno;
	private String ename;
	private String job;
	private String hdate;
	private int deptno;
	private String dname;
	
	public EmployeeDto() {
		
	}
	//입력때 사용하는 생성자 오버로딩
	public EmployeeDto(String ename, String hdate, int deptno) {
		super();
		this.ename = ename;
		this.hdate = hdate;
		this.deptno = deptno;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getHdate() {
		return hdate;
	}
	public void setHdate(String hdate) {
		this.hdate = hdate;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "EmployeeDto [empno=" + empno + ", ename=" + ename + ", job=" + job + ", hdate=" + hdate + ", deptno="
				+ deptno + ", dname=" + dname + "]";
	}
	
	

}
