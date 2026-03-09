package com.min.edu;

//TODO 003 기존방식과, DTO(은닉화 객체), 생성자 오버로딩의 활용 방법
public class NM_Main {
	public static void main(String[] args) {
		//객체 두 개 생성
		//정리 : 확인해야 할 점. default가 없다. 반드시 오버로딩된 생성자만 사용 가능하다
		ValueNM nm1 = new ValueNM(10, 10);
		ValueNM nm2 = new ValueNM(100, 1000);
		
		//정리 : 현재 은닉화되어 있는 ValueNM은 getter와 setter를 가지고 있다
		//		필요할때 만들어 주는 것입니다
		//		: 확인사항 - 멤버필드가 private이니깐 직접 접근이 되지 않는다. 따라서 getter(가져올 때), setter(입력할 때)를 사용해야 한다
		System.out.println(nm1.getN());
		System.out.println(nm1.getM());
		
		//결론 : setter도 있네, 지금 치신 코드는 잘못된 코드이다
		//		1) 은닉화는 입력만 되거나 출력만 되는 것
		//		2) 		생성자를 통해서 입력만 되고, 출력만 되는 것
		//		3) 데이터의 이동을 위해서(request, response), getter/setter를 두개 다 만듦
		
		ValueNM resultNM = Object_Calculation.add(nm1, nm2);
		System.out.println(resultNM); //값이 안나오고 객체의 형태만 출력, 부모의 toString(), getClass().getName()@16진수Hashcode
		
		System.out.println("---연산된 결과---");
		System.out.println(resultNM.getN());
		System.out.println(resultNM.getM());
		
	}

}
