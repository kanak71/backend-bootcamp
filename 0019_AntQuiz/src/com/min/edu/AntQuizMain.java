package com.min.edu;

public class AntQuizMain {

	public static void main(String[] args) {
		AntQuiz ant = new AntQuiz();
//		String result = ant.andProcess("12");	//반환타입이 String이라 받아줘야 한다는데 이유를 모르겠다
//		System.out.println("11의 다음 개미수열은? : " + result);
		
		ant.antQuizIterator(4);

	}
	
	/*
	 * 성능측정 코드
	 * Runtime runtime = new Runtime(); //실시간 VM 메모리 객체
	 * runtime.gc(); //gc garbage collection 사용되지 않는 객체를 지워줌
	 * long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
	 * 
	 * 연산을 넣어 주세요
	 * long entTime = System.nanoTime();
	 * log memoryAfter = runtime.totalMemory() - runtime.freeMemory();
	 * 
	 * System.out.println("==성능측정==");
	 * System.out.println("실행시간 :" + (endTime - startTime) / 1_000_000.0);
	 * System.out.println("사용 메모리 : " + (memoryAfter - memoryBefore) /1024);
	 * 
	 */

}
