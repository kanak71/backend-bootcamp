-- CASE 표현식
-- IF문, Switch~Case문을 만들어 낼 수 있다
-- 사용 : 요구분석 "~~별"로 나오면 CASE문 혹은 GROUP BY문
--		 년도별 + 팀별 평균 점수 : GROUP BY문 + CASE문 사용해서 해결
--		2) 가로의 데이터를 세로로 변경할 때 : CASE문 + PIVOT

-- 표현식 : 
-- 1. search case문 - 범위 IF문
-- 2. simple case문 - 1:1 Switch문 => Oracle에서는 decode로 변환이 가능

-- 문법 :
-- CASE WHEN THEN ELSE END : 참일때 THEN 거짓일때 ELSE
-- CASE WHEN THEN END : 참일때 THEN, NULL 반환

-- Q. Simple Case : 1:1 일 때
--		부서정보에서 부서위치를 동부, 서부, 중부로 구분

SELECT d.DEPTNO , d.DNAME , d.LOC,
	CASE d.LOC 
		WHEN 'NEW YORK' THEN 'EAST'
		WHEN 'DALLAS' THEN 'CENTER'
		ELSE 'WEST'
	END 구분
FROM DEPT d;

-- SEARCHED CASE 문
SELECT d.DEPTNO , d.DNAME , d.LOC, 	
	CASE 
		WHEN d.LOC = 'NEW YORK' THEN 'EAST' 
		WHEN d.LOC = 'DALLAS' THEN 'WEST' 
		END
	FROM DEPT d;

-- SEARCHED CASE문 + IN절 혼합
SELECT LOC,
	CASE 
		WHEN LOC IN('DALLA', 'BOSTON') THEN 'WEST'
		ELSE 'ETC'	--ELSE문을 작성하지 않으면 NULL로 반환됩니다
		END AS 구분
	FROM DEPT d;

SELECT LOC,
	NVL(CASE 
		WHEN LOC IN('DALLA', 'BOSTON') THEN 'WEST'
		ELSE 'ETC'	--ELSE문을 작성하지 않으면 NULL로 반환됩니다
		END , '몰라요')
		AS 구분
	FROM DEPT d;

--Simple Case문 --> ORACLE에서만 DECODE로 사용할 수 있다
-- DECODE(대상컬럼, 값, 참, 값, 참, 거짓)
SELECT d.DEPTNO , d.DNAME , d.LOC, 	
	CASE 
		WHEN d.LOC = 'NEW YORK' THEN 'EAST' 
		WHEN d.LOC = 'DALLAS' THEN 'WEST' 
		END
	FROM DEPT d;

SELECT LOC,
	DECODE(LOC, 'NEW YORK', 'EAST', 'DALLAS', 'WEST', 'ETC'),
	DECODE(LOC, 'NEW YORK', 'EAST', 'DALLAS', 'WEST')
	FROM DEPT d;

-- Q. 사원정보 테이블에서 급여가 3000이상이면 HIGH, 1000이상이면 MID, 1000 미만이면 LOW
SELECT SAL,
	CASE 
		WHEN SAL >= 3000 THEN 'HIGH'
		WHEN SAL >= 1000 THEN 'MID'
		WHEN SAL < 1000 THEN 'LOW'
		ELSE 'NOT'	--NULL로 ELSE에서 처리한다. 비교연산이라면 IS, IS NOT
		END AS 구분
	FROM EMP;

-- Q. 시험에서만 나오는 문제
-- 정리 : CASE문 잘 작성, 중첩 CASE문
-- Q. 사원정보중에서 급여가 2000이라면 보너스를 1000, 1000 이상이라면 500을 1000 미만이라면 0으로
SELECT SAL, COMM,
	NVL(COMM,0),
	NVL(COMM,0) + 
					CASE 
						WHEN SAL >= 2000 THEN 1000
						WHEN SAL >= 1000 THEN 500
						ELSE 0
					END AS "보너스 증가 금액"
	FROM EMP;

-- 중첩 케이스문
SELECT ENAME, SAL,
	CASE 
		WHEN SAL >= 2000 THEN 'HIGH'
		ELSE
				CASE 
					WHEN SAL >= 1000 THEN 'MID'
					ELSE 'LOW'
				END
		END AS 보너스
	FROM EMP;













