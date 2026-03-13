-- JOIN은 ANSI/ISO 표준에서 Standard join
-- INNER JOIN : ON, USING
--				NATURAL
-- OUTER JOIN
-- CROSS JOIN

-- JOIN은 참여하는 FROM절의 순서에 따라서 "선행/후행 테이블"이라 지칭한다
-- JOIN은 반드시 두개의 테이블간 발생한다
-- JOIN은 같은 컬럼명, 같은 타입 - 반드시는 아니다
-- *** USING은 참여하는 컬럼이 맨 앞에 한 번 나온다
-- *** USING은 ALIAS 사용하면 안된다

SELECT *
	FROM EMP e JOIN DEPT d
	ON e.DEPTNO = d.DEPTNO;

SELECT *
	FROM DEPT d JOIN EMP e
	ON e.DEPTNO = d.DEPTNO ;

-- NATURAL JOIN 조인이 될 수 있는 컬럼을 자동으로 찾아서 조인하고 결과를 반환
-- USING과 같지만 만약에
--					** 컬럼명과 값이 같은 컬럼이 여러개라면 AND로 묶어서 결과가 달라진다

-- 테이블 복사 CTAS : 
CREATE TABLE DEPT_COPY AS SELECT * FROM DEPT;

SELECT *
	FROM DEPT_COPY;

SELECT *
	FROM DEPT d JOIN DEPT_COPY dc 
	ON D.DEPTNO = DC.DEPTNO;

SELECT *
	FROM DEPT d JOIN DEPT_COPY dc
	USING (DEPTNO);


-- 1) 10 = 10
-- 2) 10ACCOUNTING = 10ACCOUNGING
SELECT *
	FROM DEPT d JOIN DEPT_COPY dc 
	ON D.DEPTNO = DC.DEPTNO
	AND D.DNAME = DC.DNAME;

SELECT *
	FROM DEPT d JOIN DEPT_COPY dc 
	USING(DEPTNO, DNAME);

SELECT *
	FROM DEPT d NATURAL JOIN DEPT_COPY dc
	USING(DEPTNO, DNAME);

SELECT *
	FROM DEPT d JOIN DEPT_COPY dc
	USING(DEPTNO, DNAME, LOC);

-- Q. 일정테이블에서 원정팀(AWAYTEAM_ID)의 이름과 홈팀(HOMETEAM_ID)의 이름을 조회
-- 테이블 : SCHEDULE, TEAM
-- 컬럼 : HOMETEAM_ID - TEAM_ID
--		 AWAYTEAM_ID - TEAM_ID
-- 컬럼 : TEAM(TEAM_NAME)

SELECT s.AWAYTEAM_ID , t2.TEAM_NAME 원정팀, s.HOMETEAM_ID , t.TEAM_NAME 홈팀
	FROM SCHEDULE s JOIN TEAM t 
	ON s.HOMETEAM_ID  = t.TEAM_ID
	JOIN TEAM t2
	ON s.AWAYTEAM_ID = t2.TEAM_ID ;

-- Q. 일정테이블에서 원정팀의 이름과 홈팀의 이름을 조회
--	  홈팀과 원정팀의 경기에서 홈팀이 이긴 경우 '홈팀승리'를 출력,
--	  홈팀과 원정팀의 경기에서 원정팀이 이긴 경우 '원정팀승리'

		
-- Q. 일정테이블에서 원정팀의 이름과 홈팀의 이름을 조회
--	  홈팀과 원정팀의 경기에서 홈팀이 이긴 경우 '홈팀승리'를 출력,
--	  홈팀과 원정팀의 경기에서 원정팀이 이긴 경우 '원정팀승리'
-- 	 3점차이 이상일 경우
SELECT s.HOMETEAM_ID, t.TEAM_NAME AS 홈팀명,
		s.AWAYTEAM_ID, t.TEAM_NAME AS 원정팀,
		CASE 
			WHEN s.HOME_SCORE = s.AWAY_SCORE THEN '무승부'
			WHEN SIGN(s.HOME_SCORE - s.AWAY_SCORE) = -1 THEN '원정팀 승리'	--SING 음수(-1) 0(1) 양수(1)
			ELSE '홈팀 승리'
		END AS 경기결과,
		s.HOME_SCORE, s.AWAY_SCORE 
	FROM SCHEDULE s JOIN TEAM t
	ON s.HOMETEAM_ID = t.TEAM_ID
	JOIN TEAM t2
	ON s.AWAYTEAM_ID = t2.TEAM_ID
	--WHERE (s.HOME_SCORE  - s.AWAY_SCORE ) > 3;
	WHERE HOME_SCORE IS NOT NULL	--튜닝때문에 : 계산의 개수를 줄이기 위해서
	AND ABS(s.HOME_SCORE  - s.AWAY_SCORE) >3;	--결과를 편하게 계산하기 위해서

-- NULL이 JOIN이 될까?
-- 결과는 ON절, WHERE절 이던 컬럼 비교연산
-- NULL은 비교연산 무조건 다 FALSE
	
UPDATE DEPT_COPY dc SET DNAME = NULL
	WHERE dc.DEPTNO IN(30,40);

SELECT *
	FROM DEPT;
SELECT *
	FROM DEPT_COPY dc;

-- Q. DNAME NULL인 DNAME으로 조인(EQUI-JOIN)을 해보자
SELECT *
	FROM DEPT d JOIN DEPT_COPY dc
	ON d.DNAME = DC.DNAME 
	
CREATE TABLE DEPT_COPY2 AS SELECT * FROM DEPT_COPY;

SELECT *
	FROM DEPT_COPY dc
UNION ALL 
SELECT *
	FROM DEPT_COPY2 dc;

-- 결론 : NULL은 조인의 대상이 될 수 없다
SELECT *
	FROM DEPT_COPY dc JOIN DEPT_COPY2 dc2
	ON DC.DNAME = DC2.DNAME;
	
-- NATURAL JOIN
SELECT *
	FROM DEPT_COPY dc NATURAL JOIN DEPT_COPY2 dc2;

-- CATESIAN PRODUCT : 다차원 조인
-- DEPT_COPY 4, DEPT_COPY2 4 = 16개
-- JOIN의 대상이 ROW*ROW가 대상이 되기 때문에
SELECT *
	FROM DEPT_COPY dc CROSS JOIN DEPT_COPY2 dc2;













