package com.min.edu;

//if문을 통해서 변하는 값을 변경하여 작업을 해보자
public class Diamond_If {
	
	private int j2=0;	//변화를 주는 값
	
	public void dia_if(int stage) {
		//1) 입력받은 stage의 중간값을 계산
		int mid = stage/2;
		
		for (int i = 0; i < stage; i++) { //층수의 for문
			
			
			for (int j = 0; j < mid -j2; j++) {
				System.out.print(" ");
			}
			
			for (int j = 0; j < 2*j2+1; j++) {
				System.out.print("★");
			}
			
			//2) if를 통해서 층수의 중간을 판단하여 증감을 만들어낸다
//			if(i<mid) {
//				j2++;
//			} else {
//				j2--;
//			}
			
			//기능의 분리를 위해 메소드로 작성 후 실행
			check_stage(i, mid);
			
			System.out.println();
		}
	}
	
	/**
	 * int i는 현재 진행되고 있는 층 수
	 * int mid는 전체 층수의 가운데 값
	 */
	private void check_stage(int i, int mid) {
		if(i<mid) {
			j2++;	//j2 = j2+1;	j2+=1;
		} else {
			j2--;	//j2 = j2-1;	j2-=1;
		}
	}

}
