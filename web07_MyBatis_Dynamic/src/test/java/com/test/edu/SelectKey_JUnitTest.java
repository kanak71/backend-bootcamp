package com.test.edu;

import static org.junit.Assert.*;

import org.junit.Test;

import com.min.edu.dto.UserInfoVo;
import com.min.edu.service.UserInfoService;

public class SelectKey_JUnitTest {

	@Test
	public void test() {
		UserInfoService service = new UserInfoService();
		UserInfoVo vo = new UserInfoVo().builder()
							.name("화성")
							.tel("004")
							.build();
		UserInfoVo result = service.insertAndSelect(vo);
		System.out.println(result);
		assertNotNull(result);
	}

}
