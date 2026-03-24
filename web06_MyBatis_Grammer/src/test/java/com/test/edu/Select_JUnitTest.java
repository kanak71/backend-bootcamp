package com.test.edu;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.min.edu.dto.JobsDto;
import com.min.edu.repository.IJobsSelectRepository;
import com.min.edu.repository.JobsSelectRepository;

public class Select_JUnitTest {

	private IJobsSelectRepository selectRepository;
	
	@Before
	public void createRepository() {
		selectRepository = new JobsSelectRepository();
	}
	
	//TODO 01202 테스트
//	@Test
	public void select01_test() {
		int result = selectRepository.select01("PR_REP");
		assertNotEquals(0, result);
	}
	
	//TODO 01302 테스트
//	@Test
	public void select02_test() {
		JobsDto result = selectRepository.select02("PR_REP");
		assertNotNull("조회결과 없음", result);
	}
	
	//TODO 01402 테스트
//	@Test
	public void select03_test() {
		JobsDto result = selectRepository.select03("PR_REP");
		assertNotNull(result);
	}
	
	//TODO 01502 테스트
//	@Test
	public void select04_test() {
		Map<String, JobsDto> jobsMap = selectRepository.select04("IT_PROG");
		//1) 결과의 개수를 출력
		System.out.println(jobsMap.size());
		//2) Map의 결과를 호출하기 위해서 Key를 get 해본다
		System.out.println(jobsMap.get("IT_PROG"));
		//3) Map<String, Object> 형태를 MyBatis의 문법
		//	실질적으로 Map<String, Map<>>의 형태로 되어 있다
//		JobsDto dto = jobsMap.get("IT_PROG");
//		System.out.println(dto);
		
		Map<String, Object> mapDto = (Map<String, Object>) jobsMap.get("IT_PROG");
		System.out.println("&&" + mapDto);
		
		
		assertNotEquals(0, jobsMap.size());
	}
	
	//TODO 01602 테스트
////	@Test
//	public void select05_test() {
//		JobsDto inDto = new JobsDto();
//		inDto.setJob_id("IT_PROG");
//		inDto.setJob_title("Programmer_");
//			
//		JobsDto outDto = selectRepository.select05(inDto);
//		System.out.println(outDto); //*****
//		assertNotNull(outDto);
//			
//	}
	
	//TODO 01702 select06 테스트
	//결과가 여러개는 List로, 결과가 없다면 List의 size()가 0
	
//	@Test
	public void select06_test() {
		List<JobsDto> lists = selectRepository.select06();
		assertNotEquals(0, lists.size());
	}
	
	//TODO 01802 select07 테스트
	// ** 여러개의 값의 전달은 Map의 {key:value}를 통해서 전달한다
	// ** Null의  반환을 하지 않기 위해서 selectList를 통해서 size()를 판단하겟다
	//	ex) 결과가 없다면 zise()는 0
	//		결과가 있다면 size()는 n
	//	assertNotEquals를 통해서 개수를 판단한다
	
//	@Test
	public void select07_test() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "IT_PROG");
		map.put("title", "Programmer_");
		List<JobsDto> lists = selectRepository.select07(map);
		System.out.println("결과 : " + lists.size());
		System.out.println("출력 : " + lists.get(0));
		assertNotEquals(0, lists.size());
	}
	
	//TODO 01902 select08 테스트
	// markup 문법을 문자로 처리하는 CDATA 묶어서 한다
	@Test
	public void select08_test() {
		List<JobsDto> lists = selectRepository.select08(10000);
		assertNotEquals(0, lists.size());
	}
	
	

}
