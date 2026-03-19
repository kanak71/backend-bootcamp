package com.min.edu.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//TODO 003 JDBC에서 공통으로 사용하게 된 기능(1단계 2단계 6단계
public abstract class Database {
	
	//생성자를 통해서 부모가 초기화 될 때 자동으로 Driver를 연결
	public Database() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1단계 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("1단계 드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	// 드라이버를 통해서 접속 정보를 가지고 있는 객체 반환
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username ="EDU";
		String password = "EDU";
		conn = DriverManager.getConnection(url, username, password);
		return conn;
	}
	
	// 연결된 접속을 닫아주는 작업
	public void closed(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
			System.out.println("6단계 닫기 성공");
		} catch (SQLException e) {
			System.out.println("6단계 닫기 실패");
			e.printStackTrace();
		}
		
	}

}
