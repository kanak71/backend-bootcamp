package com.min.edu.model;

import java.util.List;

import com.min.edu.dto.AllDto;
import com.min.edu.dto.Team01Dto;

public interface IPlayerDao {
	
	/*
	 * 기존 단일 테이블 조회 방식과 같은 로직으로 처ㅣㄹ
	 * 하나의 DTO에 두개의 테이블 컬럼을 선언하고 getter/setter를 구성하여 매핑 할 수 있도록 한다
	 * * 컬럼의 개수가 너무 많은 경우 메모리의 복잡도가 증가된다. 권고사항에서는 5개 이하인 경우에는 한개의 DTO를 사용해라
	 */
	
	public List<AllDto> join01();
	
	/*
	 * 각 테이블에 매핑되어 있는 DTO를 각각 지정한다
	 * 부모-자식관계의 조인이 발생함에 따라 부모테이블에 자식테이블이 입력 될 수 있도록 멤버필드로 작성한다
	 * myBatis에서 해당 부모.자식 객체로 접근을 한다 ex)pDtos.player_name
	 * 		ㄴ OGNL(object graph, notation language)
	 * * 한개의 부모에 여러개의 자식이 포함되어야 하지만 부모의 row개수 만큼 된다
	 * 										myBatis일 때 일반으로 차이점
	 */
	public List<Team01Dto> join02();
	
	/*
	 * mybatis의 <collection>을 사용하여 DTO <resultMap>을 통해서 선언 후 연결
	 */
	public List<Team01Dto> join03();

}
