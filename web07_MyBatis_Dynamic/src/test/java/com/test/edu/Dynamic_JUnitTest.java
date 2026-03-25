package com.test.edu;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.min.edu.dto.JobsVo;
import com.min.edu.dto.UserInfoVo;
import com.min.edu.model.DynamicDaoImpl;
import com.min.edu.model.IDynamicDao;

public class Dynamic_JUnitTest {
	
	private IDynamicDao dao;
	
	@Before
	public void createDao() {
		dao = new DynamicDaoImpl();
	}

//	@Test
	public void getJobIf_test() {
		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("job_id", "IT_PROG");
//		List<JobsVo> lists = dao.getJobIf(map);
//		assertEquals(0, lists.size());
//		값을 입력하거나 비교할때는 반드시 null을 먼저 체크해 줘야한다
		
		map.put("job_id", "");	//"" or null
		List<JobsVo> listsNull = dao.getJobIf(map);
		assertEquals(0, listsNull.size());
	}
	
//	@Test
	public void getJobList_test() {
		String[] ids = {"AD_PRES"};
		List<String> seqs = Arrays.asList(ids);
		List<JobsVo> lists = dao.getJobList(seqs);
		assertNotEquals(0, lists.size());
	}
	
//	@Test
	public void getJobMap_test() {
		String[] ids = {"AD_PRES"};
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("ids", ids);
		List<JobsVo> lists = dao.getJobMap(map);
		assertNotEquals(0, lists.size());
	}
	
//	@Test
	public void getJobChoose_test() {
		JobsVo vo = new JobsVo();
		
//		vo.setJob_id("IT_PROG");
		vo.setJob_title("Developtment"); //두개의 값이 있을 경우 먼저 선택된 JOB_ID가 실행됨
		List<JobsVo> lists = dao.getJobChoose(vo);
		System.out.println(lists);
	}
	
	
//	@Test
	public void getJobTrim_test() {
		JobsVo vo = new JobsVo();
		vo.setJob_id("IT_PROG");
		vo.setJob_title("Developtment");
		
		List<JobsVo> lists = dao.getJobTrim(vo);
		System.out.println(lists);
	}
	
//	@Test
	public void jobUpdateSet_test() {
		JobsVo vo = new JobsVo();
		vo.setJob_id("AD_PRES");
		vo.setJob_title("Developtment");
		int cnt = dao.jobUpdateSet(vo);
		assertEquals(1, cnt);
	}
	
	@Test
	public void insertUserINfoList_test() {
		UserInfoVo vo1 = new UserInfoVo().builder()
						.name("가국")
						.tel("115")
						.build();
		UserInfoVo vo2 = new UserInfoVo().builder()
				.name("나국")
				.tel("115")
				.build();
		UserInfoVo vo3 = new UserInfoVo().builder()
				.name("다국")
				.tel("115")
				.build();
		
		List<UserInfoVo> insertVo = List.of(vo1, vo2, vo3);
		int cnt = dao.insertUserInfoList(insertVo);
		assertEquals(3, cnt);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
