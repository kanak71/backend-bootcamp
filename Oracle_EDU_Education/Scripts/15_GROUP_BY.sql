-- GROUP BY 
-- FROM절에 조회된 결과를 그룹화하여 처리 할 수 있다
-- GROUP BY절로 생성된 그룹은 조건절 HAVING절으로 조건을 처리한다
--  ㄴ GROUP BY HAVING , HAVING GROUP BY : 시험에 순서가 바껴도 맞는 문법
-- *** GROUP BY 절로 생성된 SQL은 "GROUP BY에서 사용된 컬럼" 만 SELECT절 + 집계 함수

-- Q. 부서별평균(AVG) 급여를 알려주세요
SELECT AVG(SAL) 전체급여평균
	FROM EMP e ;

SELECT e.DEPTNO, TRUNC( AVG(SAL)) 부서별급여평균
	FROM EMP e 
	GROUP BY e.DEPTNO ;

-- HAVING절은 GROUP BY 의 조건절
-- ** WHERE은 전체테이블정보(FROM)의 조건절
-- Q. 팀별 가장 키가 큰 선수를 출력해 주세요 (단, 190이하는 제거해주세요)
SELECT p.TEAM_ID , MAX(p.HEIGHT)
	FROM PLAYER p 
	GROUP BY p.TEAM_ID ;

SELECT p.TEAM_ID , MAX(p.HEIGHT)
	FROM PLAYER p 
	GROUP BY p.TEAM_ID 
	HAVING MAX(p.HEIGHT) > 190
	ORDER BY 1;

-- HAVING은 GROUP BY 앞에 와도 된다
SELECT p.TEAM_ID , MAX(p.HEIGHT)
	FROM PLAYER p 
	HAVING MAX(p.HEIGHT) > 190
	GROUP BY p.TEAM_ID 
	ORDER BY 1;

-- 정리 : WHERE은 FROM절은 먼저 조건 정리 할 때
-- 각팀별 190 이상한 선수들 중에서 가장 큰 선수를 조회
SELECT p.TEAM_ID, MAX(p.HEIGHT ), AVG(p.HEIGHT), MIN(p.HEIGHT )
	FROM PLAYER p 
	WHERE p.HEIGHT >=190
	GROUP BY p.TEAM_ID ;


-- Q. 팀별 가장 키가큰 선수들을 조회, 조회된 선수의 정보 이름, 팀명, 등번호, 포지션 조회

-- 1단계 : 팀별 가장 키가큰 선수들 조회
SELECT p.TEAM_ID, MAX(p.HEIGHT)
	FROM PLAYER p 
	GROUP BY p.TEAM_ID ;

-- 2단계 
-- 이름, 팀명, 등번호, 포지션 
SELECT p.PLAYER_NAME , P.TEAM_ID , p.BACK_NO , p."POSITION"  
	FROM PLAYER p  JOIN (
						SELECT p.TEAM_ID, MAX(p.HEIGHT) MAXHEIGHT
							FROM PLAYER p 
							GROUP BY p.TEAM_ID) p2
	ON p.TEAM_ID = p2.TEAM_ID 
	AND p.HEIGHT = p2.MAXHEIGHT ;

-- 3단계 
SELECT p.PLAYER_NAME , P.TEAM_ID , t.TEAM_NAME , p.BACK_NO , p."POSITION"  
	FROM PLAYER p  JOIN (
						SELECT p.TEAM_ID, MAX(p.HEIGHT) MAXHEIGHT
							FROM PLAYER p 
							GROUP BY p.TEAM_ID) p2
	ON p.TEAM_ID = p2.TEAM_ID 
	AND p.HEIGHT = p2.MAXHEIGHT 
	JOIN TEAM t 
	ON p.TEAM_ID = t.TEAM_ID ;


-- 4단계 : IN 절을 통한 방법
SELECT p.PLAYER_NAME , P.TEAM_ID, t.TEAM_NAME  , p.BACK_NO , p."POSITION"  
	FROM PLAYER p JOIN TEAM t 
--	USING(TEAM_ID)
	ON p.TEAM_ID = t.TEAM_ID 
	WHERE (p.TEAM_ID , p.HEIGHT )  IN (
										SELECT p2.TEAM_ID, MAX(p2.HEIGHT)
											FROM PLAYER p2 
											GROUP BY p2.TEAM_ID 
										);
-- Q. 축구선수 중에서 포지션별 평균키 조회해 주세요 
SELECT p."POSITION", AVG(p.HEIGHT )
	FROM PLAYER p 
	GROUP BY p."POSITION" ;

-- 결론 : 먼저 데이터를 줄이고 작업을 하는게 빠르게 따라서 WHERE절에서 먼저 처리
SELECT p."POSITION", AVG(p.HEIGHT )
	FROM PLAYER p 
	WHERE p."POSITION" IS NOT NULL
	GROUP BY p."POSITION";

-- HAVING으로 처리 하는 방법
SELECT p."POSITION", AVG(p.HEIGHT )
	FROM PLAYER p 
	GROUP BY p."POSITION" 
	HAVING AVG(p.HEIGHT ) IS NOT NULL;

-- *** 시험 , HAVING은 단독으로 사용이 불가능하다
SELECT AVG(p.HEIGHT )
	FROM PLAYER p 
	HAVING p."POSITION" IS NOT NULL;




-- 추가사항
-- GROUP BY 사용할때 유의 사항

-- 1) NULL관련 : CONCAT(NULL,'A') --> 'A'
--    NULL은 연산(+ , - ,* , /)이 아니다. CONCAT이라고 한다
--    '' 와 NULL을 동일시 한다       
SELECT dc.DEPTNO || dc.DNAME ,  -- DNAME이 NULL 인경우 ''으로 변해서 처리 된다 
	   CONCAT(dc.DNAME ,'부서')
	FROM DEPT_COPY dc ;

-- 2) GROUP BY
--    TEAM테이블, STADIUM 테이블은 ID(PK-식별자) NAME(후보키 - PK는 아닌데 PK처럼 사용할 수 있는 것)
SELECT dc.DEPTNO , dc.DNAME
	FROM DEPT_COPY dc 
	GROUP BY (dc.DEPTNO, dc.DNAME) ;

-- 후보키는 이용한 GROUP BY 컬럼의 증가
-- 통계 정보를 만들어내는(소계, 총계), ROLLUP / CUBE -> 참여 순서하는 중요
SELECT t.TEAM_ID , t.TEAM_NAME , t.REGION_NAME 
	FROM TEAM t 
	GROUP BY (t.TEAM_ID , t.TEAM_NAME , t.REGION_NAME);


-- 비연관서브쿼리의 가로 세로 바꾸기
-- SAL_GRADE
-- 업무별 등급
SELECT JOB, COUNT(*)
	FROM EMP e JOIN SAL_GRADE sg 
	ON e.SAL BETWEEN SG.LOSAL  AND SG.HISAL 
    GROUP BY JOB;


SELECT JOB, COUNT(*),
	SUM(CASE SG.GRADE  WHEN 1 THEN SAL  END) "1등급",
	SUM(CASE  SG.GRADE WHEN 2 THEN SAL  END) "2등급",
	SUM(CASE  SG.GRADE WHEN 3 THEN SAL  END) "3등급",
	SUM(CASE  SG.GRADE WHEN 4 THEN SAL  END) "4등급",
	SUM(CASE  SG.GRADE WHEN 5 THEN SAL  END) "5등급"
	FROM EMP e JOIN SAL_GRADE sg 
	ON e.SAL BETWEEN SG.LOSAL  AND SG.HISAL 
    GROUP BY JOB;

SELECT *
	FROM SAL_GRADE sg ;



-- EXTRACT , TO_CHAR : 날짜의 형변환 함수
-- 결론 : EXTRACT 숫자 ex> 20260301 ->월 -> 1 , T0_CHAR ex> 20260301 -> 'MM' -> '01'
SELECT TO_CHAR(HIREDATE , 'MM') TOCHAR,
	   EXTRACT(MONTH FROM HIREDATE) NUM
	FROM EMP;

SELECT d.DEPTNO ,
	SUM(CASE TO_CHAR(HIREDATE, 'MM') WHEN '01' THEN 1 ELSE NULL END) "1월", -- TO_CHAR는 문자열 비교
	SUM(CASE TO_CHAR(HIREDATE, 'MM') WHEN '02' THEN 1 END) "2월", -- ELSE가 없을 경우는 자동으로 NULL 반환
	SUM(CASE EXTRACT(MONTH FROM HIREDATE) WHEN 3 THEN 1 END) "3월" -- EXTRACT를 숫자로 처리 THEN에서 숫자(3)으로 비교
	FROM DEPT d 
	GROUP BY d.DEPTNO ;















