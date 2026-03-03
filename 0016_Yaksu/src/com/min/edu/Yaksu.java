package com.min.edu;
public class Yaksu {
	
	
	/**
	 * 진약수의 합을 구하는 메소드
	 * @param num 원하는 진약수의 합을 원하는 수
	 */
	public void yaksu_sum(int num) {
		int cnt = 0;	//진약수의 갯수를 확인하는 누적 변수
		int sum = 0;	//진약수의 합의 결과
		for(int i=1; i<num; i++) {	//0은 약수의 대상이 아니기때문에 값으로 사용할 필요하 없다
			if(isCheck(num, i)) {
				cnt++;
				sum += i;
			}
		}
		System.out.printf("%d의 진약수의 개수는 %d / 합은 %d" , num, cnt, sum);
		
	}
	
	/**
	 * 
	 * @param num 숫자
	 * @param chkNum 숫자의 약수를 판단하는 입력 숫자
	 * @return true/약수이다, false/약수가 아니다
	 */
	public boolean isCheck(int num, int chkNum) {
		boolean isc = false;
		if(num%chkNum == 0) {
			isc = true;
		}
		return isc;
		
		
	}

}
