package com.min.edu;

/*
 * TODO 007 Checked Exception
 * 정의 : 반드시 예외처리를 해야지만 코드가 작성되는 코드를 이야기한다
 * 		개발자가 반드시 확인해야 한다. 강제적으로 예외(try~catch)를 해줘야 하는 코드
 * 		<=>Runtime Exception
 * 		ex) 파일 읽기, DB연결...
 * 			java.io.*, java.net.*, java.sql.*
 * 결론 : Checked Exception은 반드시 코드에 예외처리 코드를 포함해야 한다
 * 
 * 키워드 : throw, throws
 */
public class Exception_Method_Step07 {
	
	//정의 : throw와 throws를 통해서 예외처리 메시지를 전달하여 원하는 메시지를 처리한다
	//		throws가 된 메소드를 사요할 때 반드시 예외처리 해줘야 한다
	//		사용기능 : @ControllerAdvice
	
	//예외발생 가능 메소드 : 사용(호츨)하는 코드에서는 반드시 try~catch 해줘 
	public void make() throws Exception {
//		//예외처리가 완료된 코드
//		try {
//			int n = 10;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		throw new Exception("사용자 예외 처리");
		
		
	}

}
