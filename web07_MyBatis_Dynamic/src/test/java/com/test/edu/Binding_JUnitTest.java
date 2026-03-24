package com.test.edu;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.min.edu.dto.JobsVo;
import com.min.edu.model.BindingRepositoryImpl;
import com.min.edu.model.IBindingRepository;

public class Binding_JUnitTest {

	@Test
	public void binding01_test() {
		IBindingRepository repository = new BindingRepositoryImpl();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("column", "JOB_ID");
		map.put("value", "IT_PROG");
		List<JobsVo> lists =  repository.binding01(map);
		assertEquals(1, lists.size());
	}
	
	@Test
	public void binding02_test() {
		IBindingRepository repository = new BindingRepositoryImpl();
		List<JobsVo> lists = repository.binding02("AD");
		assertNotEquals(0, lists.size());
	}

}
