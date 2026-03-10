package com.min.edu._JUnit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JUnitTest {

	// @Test 어노테이션이 테스트 단위
	@Test
	@DisplayName("더하기 테스트")
	void test() {
		Calculator cal = new Calculator();
		//확인작업 assertXXXXXX
		assertEquals(5, cal.add(2, 3));	//2와 3을 넣으면 5가 나오는걸 테스트하겠다
	}
	
	@Test
	@DisplayName("마이너스 테스트")
	public void test01() {
		Calculator cal = new Calculator();
		int n = cal.minus(10, 10);
		assertEquals(0, n);
	}

}
