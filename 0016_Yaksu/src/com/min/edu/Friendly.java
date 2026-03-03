package com.min.edu;

//TODO 003 친화수 220의 진약수합 284, 284의 진약수합 220
//변수 : 변수는 변하는 수를 이야기한다
// 		변수는 대입연산을 통해서 입력되면 재입력되기 전까지 그 값을 유지한다
//
/*
 * int a = 220;
 * int b = yaksu_sum(a); //284
 * int c = yaksu_sum(b) ; //284 => 220;
 * 그렇다면 a(220)와 c(220)이 같다면 a와 b는 친화수라고 할 수 있다
 */
public class Friendly {
	
	public void friendlyNum(int area) {
		for (int i = 2; i <= area; i++) {
			int tmp = i;
			int aSum = yaksu_sum(tmp);
			int bSum = yaksu_sum(aSum);
			
			if(tmp < aSum && tmp == bSum) {
				System.out.printf("%d와 %d는 친화수로 판단됨 \n", tmp, aSum);
				
			}
		}
	}
	
	//3항연산자
	//간단한 판단문에서 사용하는 연산자
	//반환값 = 판단문 ? 참인결과 : 거짓결과
	
	/*
	 * int n=0;
	 * if(판단문) {
	 * }else{
	 * }
	 */
	
	//사용되는 필수 조건
	//if문은 	반환타입이 없어도 됨, 하지만 3항연산자는 반드시 반환타입이 있어야 한다
	
	private boolean iscCheck(int num, int chkNum) {
		//boolean isc = (num%chkNum == 0) ? true:false;
		//return isc;
		return (num%chkNum == 0) ? true:false;
	}
	
	//접근제한자의 private는 class 내부에서만 사용이 가능하고 외부에 노출되지 않는다
	//연산이나 로직처리를 위해서 사용하게 된다. //API주석도 노출되지 않는다
	private int yaksu_sum(int num) {
		int sum = 0;
		for(int i=1; i<num; i++) {
			if(iscCheck(num, i)) {
				sum += i;	//sum = sum+i 대입연산자 기준으로 오른쪽이 먼저 실행되고 대입이 이뤄짐
			}
		}
		
		return sum;
	}

}
