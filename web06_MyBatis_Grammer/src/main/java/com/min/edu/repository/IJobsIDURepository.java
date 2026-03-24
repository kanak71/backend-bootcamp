package com.min.edu.repository;

import java.util.Map;

import com.min.edu.dto.JobsDto;

public interface IJobsIDURepository {
	/*
	 * TODO 020 입력을 위한 insert
	 */
	
	public int insert01(JobsDto inDto);
	
	//TODO 021 삭제를 위한 delete
	public int delete01(Map<String, Object> inMap);
	
	//TODO 022 수정을 위한 update
	public int update01(JobsDto inDto);

}
