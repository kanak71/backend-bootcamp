package com.min.edu;

import java.io.FileNotFoundException;
import java.io.FileReader;

/*
 * TODO 006 try ~ with ~ resource
 * 
 * 기존 방식의 불편한 점
 * 1) try 연산을 작성
 * 2) catch 연산의 예외가 발생했을 경우 실행
 * 3) finally 연산이 성공하던 실패하던 무조건 동작하는 기능
 * 
 * ex) 외부 (서드파티 - DB접속, 파일읽기...)를 사용했을 경우 닫아줘야 한다
 * 	finally로 성공/실패하든 무조건 닫아주는 기능 작성
 * 문제를 해결 : 자동으로 닫아주도록 만들자
 */

public class Exception_Method_Step06 {
	//파일을 읽는 기능
	//java7에서 나온 문법
	
	int n = 0;
	public void reader() {
		try(FileReader file = new FileReader("missing.txt")) {
			n++;
		}catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}catch (Exception e) {
			e.printStackTrace();	//역추적하여 발생된 예외를 분석해서 출력
		}
		
		
		
		//--------------------------------------------
		try(FileReader file1 = new FileReader("missing.txt");
			FileReader file2 = new FileReader("missing.txt");	) {
			n++;
		}catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}catch (Exception e) {
			e.printStackTrace();	//역추적하여 발생된 예외를 분석해서 출력
		}
	
	
	
	//--------------------------------------------------
	//java 9+ 이상부터는 외부에서 변수를 만들어 선언된 객체를 사용할 수 있도록 변경
		FileReader file3 = new FileReader("missing.txt");
		FileReader file4 = new FileReader("missing.txt");
		
		try(file3; file4) {
			
		}catch (Exception e) {
			
		}
		
		
		
		
	}
}
