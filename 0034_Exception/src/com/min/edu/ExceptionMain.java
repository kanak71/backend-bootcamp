package com.min.edu;

public class ExceptionMain {
	public static void main(String[] args) {
		
//		//TODO 001_01 InputMisMatchException, ArithmaticException
//		Exception_Method_Step01 step01 = new Exception_Method_Step01();
//		step01.calculation();
		
//		//TODO 002_01 예외처리 완료 Try-catch
//		Exception_Method_Step02 step02 = new Exception_Method_Step02();
//		step02.calculation();
		
//		Exception_Method_Step03 step03 = new Exception_Method_Step03();
//		step03.calculation();
		
		//TODO 005_01 finally block : 예외 발생시에만 실행되는 영역(연산)
//		Exception_Method_Step05 step05 = new Exception_Method_Step05();
//		step05.calculation();
		
		//TODO 007_01 Checked Exception, throw/throws
		Exception_Method_Step07 step07 = new Exception_Method_Step07();
		try {
			step07.make();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
