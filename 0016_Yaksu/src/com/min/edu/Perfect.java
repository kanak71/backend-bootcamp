package com.min.edu;

//TODO 002 완전수 : 진약수의 합이 입력되는 숫자와 같은 것
public class Perfect {
	
	/**
	 * 입력된 범위에 있는 완전수를 출력하는 메소드
	 * @param area 범위
	 */
	public void perfectNum(int area) {
		for(int i=2; i<=area; i++) {	//범위까지 범위를 포함하고, 1은 완전수 이기때문에 포함하지 않는다
			if(i == yaksu_Sum(i)) {
				System.out.println(i +"는 완전수로 판단됨");
				
			}
		}
	}
	
	
	//입력받은 숫자의 진약수의 합을 반환하는 메소드
	private int yaksu_Sum(int num) {
		int sum = 0;
		for(int i=1; i<num; i++ ) {
			if(isCheck(num, i)) {
				sum += i;
			}
		}
		
		return sum;
	}
	
	
	//접근제한을 private로 만들어서 외부에서(new) 실행시키지 못하게 만듦
	//내부에서 연산에 필요한 작업이기 때문에 외부에 노출할 필요가 없다
	private boolean isCheck(int num, int chkNum) {
		boolean isc = false;
		if(num%chkNum == 0) {
			isc =true;	//true가 반환되면 약수이다
		}
		return isc;
		
	}

}
