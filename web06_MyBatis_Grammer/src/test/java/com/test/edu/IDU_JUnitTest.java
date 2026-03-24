package com.test.edu;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.min.edu.dto.JobsDto;
import com.min.edu.repository.IJobsIDURepository;
import com.min.edu.repository.JobsIDURepositoryImpl;

public class IDU_JUnitTest {
	
	private IJobsIDURepository repository;
	
	@Before
	public void createRepository() {
		repository = new JobsIDURepositoryImpl();
	}
	
	
	//TODO 02002 insert01 테스트
//	@Test
	public void insert01_test() {
		JobsDto inDto = new JobsDto("IT","DEV",5000,5000);
		int cnt = repository.insert01(inDto);
		//성공한 row의 개수를 반환
		assertEquals(1,cnt);
	}
	
	//TODO 02102 delete01 테스트
//	@Test
	public void delete01_test() {
		Map<String, Object> inMap = new HashMap<String, Object>();
		inMap.put("id", "IT");
		int cnt = repository.delete01(inMap);
		assertEquals(1, cnt);
		
	}
	
	//TODO 02202 update01 테스트
	/*
	 * mapper의 tag는 의미를 부여하지 않는다.
	 * insert/update/delete는 resultType/resultMap을 작성할 수 없다
	 */
	@Test
	public void update01_test() {
		JobsDto inDto = new JobsDto("IT_PROG", "Developtment", 0, 0);
		int cnt = repository.update01(inDto);
		assertEquals(1, cnt);
	}
	
	
	
	
	
	
	

}
