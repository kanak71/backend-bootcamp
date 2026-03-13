-- JOIN(INNER JOIN)
-- 테이블을 정규화 이전의 테이블로 다시 구성하는 방법
-- VIEW 테이블(DB에 물리적으로 구성이 되어 있지 않지만 가상으로 만들어진 테이블)
-- *** VIEW 테이블을 생성할려면 반드시 GRANT 권한부여 받아야 한다(CREATE VIEW)

-- 정의 : 가상으로 만들어진 테이블을 정리하여 가지고 있는 테이블
--		 사용되고 있는 테이블이 변경되면 영향을 받는다
CREATE VIEW PLAYER_VIEW
	AS SELECT p.PLAYER_ID, p.PLAYER_NAME, TEAM_ID
		FROM PLAYER p;

SELECT *
	FROM PLAYER_VIEW;

-- JOIN(조인 - INNER JOIN)
-- 1) 등가조인(Equi) : 1:1로 연결되는 것
--			  FK/PK관계 발생하는 것 - FK컬럼과 PK컬럼 이름이 같지 않아요 하지만 타입은 같아야 한다
-- 			  반드시 FK와 PK관계에서 발생하는 것은 아니다
--			  예시> TEAM(TEAM_ID) - SCHEDULE(HONETEAM_ID, AWAYTEAM_ID)
-- 2) 비등가조인(NoN-Equi) : 범위를 가지고 있는 연관관계

-- 문법
-- [INNER] JOIN : ANSI/ISO 표준
-- STANDARD JOIN : INNER JOIN
--					ㄴON절, USING절

-- 3) NATURAL JOIN
-- 4) OUTER JOIN
--	 ㄴ LEFT [OUTER] JOIN, RIGHT [OUTER] JOIN, ORACLE만 있는 (FULL [OUTER] JOIN)
-- 5) CARTESIAN PRODUCT : CROSS JOIN

-- CARTESIAN PRODUCT : 무작위 조인
SELECT *
	FROM EMP;	--14개
SELECT *
	FROM DEPT; 	--4개
SELECT *
	FROM EMP, DEPT; --56개
	
SELECT *
	FROM EMP CROSS JOIN DEPT;	--CROSS JOIN
	
-- 조인은 조인되는 기준 컬럼이 있어야 한다
-- FROM 절 조인 : WHERE 절
-- INNER JOIN 절 : ON절
-- ㄴ** JOIN을 사용할 때 반드시 ON절 혹은 USING절
-- 유의사항 : * 출력하면 모든 컬럼이 나온다
--			  중복되는 부적적한 열유형, 명확하게 어느 테이블 뭐 다 작성, FROM절 ALIAS 필수
	
SELECT *
	FROM EMP e JOIN DEPT d;	--문법오류 발생

SELECT *
	FROM EMP e JOIN DEPT d
	ON e.DEPTNO = d.DEPTNO;	--결과는 자식의 ROW만큼 나온다
	
SELECT *
	FROM EMP e, DEPT d
	WHERE e.DEPTNO = d.DEPTNO;

SELECT *
	FROM EMP e JOIN DEPT d
	USING(DEPTNO);

-- 3) INNER JOIN에서 JOIN의 대상을 작성
-- 예외상황 : FROM 조인에서는 WHERE 절에 작성
-- ON과
--	ㄴ 장점 : 각 테이블의 컬럼명이 달라도 가능하다
--	ㄴ 단점 : 와일드카드를 통해서 출력하면 중복되는 컬럼이 나온다, 반드시 FROM절 ALIAS를 사용해야 한다
-- USING
--	ㄴ 장점 : 간결한 코드, 참여하는 조인 컬럼 맨앞에 한번만 나온다
--	ㄴ 단점 : 컬럼명이 같을 때만 사용이 가능하다


--Q. 선수테이블 조회 팀명도 같이 조회하고 싶다
-- 테이블은 : PLAYER, TEAM
-- 관계 : PLAYER(자식), TEAM(부모)
-- 관계서술 : PLAYER는 한 개의 TEAM에 소속된다
-- 		  	TEAM은 여러개의 PLAYER를 가질 수 있다
-- FK-PK : TEAM_ID를 통해서 관계 처리되어 있다

SELECT *
	FROM PLAYER p;
SELECT *
	FROM TEAM t;

-- 주의 : JOIN을 했을 때 하나의 컬럼은 ALIAS를 사용하지 않아도 된다 - 사용한다가 권고사항
--		 ON절은 반드시 사용되는 컬럼이 중복해서 나오기 때문에 반드시 ALIAS를 사용해야 한다
SELECT *
	FROM PLAYER p JOIN TEAM t
	ON p.TEAM_ID  = t.TEAM_ID;
	
-- * 사용했을 경우 맨 앞에 사용되는 컬럼이 단 한 번 나온다
SELECT *
	FROM PLAYER p JOIN TEAM t
	USING(TEAM_ID); 	--반드시 ALIAS없이 사용해 주세요
	

-- FROM 절 조인
SELECT *
	FROM PLAYER p, TEAM t
	WHERE p.TEAM_ID = t.TEAM_ID;

-- 비등가조인
-- 값의 범위를 가지고 있을 때
-- Q. SAL이 1000이상 2000미만 999출력, 아니면 111출력
-- 실무 : 입사년월일 - 상반기, 하반기
SELECT SAL,
	CASE
		WHEN SAL >= 1000 AND SAL < 2000 THEN 999
		ELSE 111
	END AS 비고
	FROM EMP e;

-- 비등가조인 : 테이블들간의 관계 - 비교대상이 있어야 한다
CREATE TABLE SAL_GRADE(
	GRADE NUMBER,
	LOSAL NUMBER,
	HISAL NUMBER
);

INSERT INTO SAL_GRADE(GRADE, LOSAL, HISAL)
	SELECT 1, 700, 1200 FROM DUAL
	UNION ALL
	SELECT 2, 1201, 1400 FROM DUAL
	UNION ALL
	SELECT 3, 1401, 2000 FROM DUAL
	UNION ALL
	SELECT 4, 2001, 9999 FROM DUAL;

SELECT *
	FROM SAL_GRADE sg;

-- Q. 사원정보테이블에서 각 사원의 급여정보를 SAL_GRADE를 통해서 등급을 구분해주세요
SELECT e.ENAME , e.SAL , sg.GRADE 
	FROM EMP e, SAL_GRADE sg
	WHERE e.SAL BETWEEN sg.LOSAL AND sg.HISAL;
	
	
	
	
	
	
	
	
	
	
