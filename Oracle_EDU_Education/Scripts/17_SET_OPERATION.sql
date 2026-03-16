-- SET OPERATION
-- JOIN은 컬럼이 같은 값이나 범위를 통해서 가로의 값을 비교하여 하나의 ROW로 만들어 냄 => 정규화 이전의 테이블로 만든다
-- SET OPERATION은 TABLE과 TABLE을 세로로 합치는 작업 => 컬럼의 타입과 개수
-- UNION, UNION ALL, MINUS, INTERSECT 

-- 타입 : 같은 컬럼에 다른 타입을 사용하면 안된다
--       컬럼의 갯수가 같아야 한다
-- **** 컬럼명은 선행의 SQL의 컬럼을 사용한다
-- **** ORDER BY 쿼리의 마지막에 한번만 사용할 수 있다

-- Q. 사원의 정보 + 축수선수 정보를 한페이로 출력
--    사원의정보(사원번호(NUMBER), 이름(VARCHAR), 업무(VARCHAR), 급여(NUMBER))
--    축구선수정보(아이디, 이름, 포지션, 팀) - 모두가 VARCHAR

SELECT TO_CHAR(e.EMPNO) , e.ENAME , e.JOB , TO_CHAR(e.SAL) 
	FROM EMP e 
--	ORDER BY 1
UNION
SELECT p.PLAYER_ID , p.PLAYER_NAME , p."POSITION" , p.TEAM_ID 
	FROM PLAYER p 
ORDER BY 1;


-- 주의점(UNION) : 1) 중복되는 ROW를 제거하고 출력 
--               2) 컬럼명은 선행 테이블의 컬럼명을 따라간다
--               3) 타입은 컬럼에 따라서 같은 타입으로 구성이 되어야한다
--               4) 출력되는 컬럼의 갯수는 선행과 후행이 같아야한다
--               5) ORDER BY 마지막에만 작성이 가능한다


--Q. 축구선수들의 정보중에서 K02와 K07의 선수들의 정보를 출력
SELECT *
	FROM PLAYER p 
	WHERE p.TEAM_ID IN ('K02','K07')
	ORDER BY p.TEAM_ID ; -- 100개 
	
SELECT p.TEAM_ID , p.PLAYER_NAME 
	FROM PLAYER p 
	WHERE p.TEAM_ID ='K02'
UNION
SELECT p.TEAM_ID , p.PLAYER_NAME 
	FROM PLAYER p
	WHERE p.TEAM_ID = 'K07'
ORDER BY TEAM_ID;


-- Q.중복되는 선수들을 찾아 보자
-- 1단계 : 전체인원
SELECT *
	FROM PLAYER p ; -- 483명

-- 2단계 : 이름+POSITION이 같은 선수
SELECT DISTINCT(p.PLAYER_NAME ), p."POSITION"  
	FROM PLAYER p ; -- 479명
	
-- 결론 : 이름과 포지션이 같은 선수 4명이 존재한다
-- 설명 : 내팀의 중복을 제외 하고 내선수만, 중복된 이름+포지션을 가진 선수, 모든 선수
-- 결론 : **** 결과의 출력은 SELECT절의 컬럼만을 대상으로 한다	

SELECT *
	FROM PLAYER p 
	WHERE p.TEAM_ID = 'K05'; -- 51명
SELECT *
	FROM PLAYER p 
	WHERE p."POSITION" = 'GK'; -- 43명
	

	
-- 89명  : K05팀에서는 GK 5명이다
SELECT *
	FROM PLAYER p 
	WHERE p.TEAM_ID = 'K05' -- 51명
UNION -- 51+43명 94명이 출력, K05이면서 GK인 선수는 중복으로 처리
SELECT *
	FROM PLAYER p 
	WHERE p."POSITION" = 'GK'; -- 43명
	
-- K05이면서 GK인 선수들만 조회
SELECT *
	FROM PLAYER p 
	WHERE p.TEAM_ID ='K05' AND p."POSITION" ='GK';
	
SELECT *
	FROM PLAYER p 
	WHERE p.TEAM_ID = 'K05'
INTERSECT 
SELECT *
	FROM PLAYER p 
	WHERE p."POSITION" = 'GK'; -- 5명
	
SELECT *
	FROM PLAYER p 
	WHERE p.TEAM_ID = 'K05'
MINUS 
SELECT *
	FROM PLAYER p 
	WHERE p."POSITION" = 'GK'; -- 46명
	
	
-- Q. 축구선수들 중에서 "포지션별 평균키"와 "팀별 평균키"를 조회
SELECT p."POSITION" , TRUNC(AVG(p.HEIGHT))
	FROM PLAYER p 
	WHERE p."POSITION" IS NOT NULL 	
	GROUP BY p."POSITION" 
UNION
SELECT p.TEAM_ID , TRUNC(AVG(p.HEIGHT))
	FROM PLAYER p 
	GROUP BY p.TEAM_ID ;
	
	
	
-- 요약정리 :
-- UNION : 같은 값의 SELECT된 ROW라면 제거하고 출력 89
-- UNION ALL : 중복은 제거하지 않고 출력 (K05(51) + (GK)43)
-- INTERSECT : 교차인원 5명
-- MINUS : 교차인원 제거하고 46명 (선행테이블 기준이다)
	
	
	
	
	
	
	
	
	
