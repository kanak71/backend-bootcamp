-- 집계 함수
-- SUM , AVG

--Q. 같은 메니저를 두고 있는 사원들의 급여의 합을 구해보자
SELECT *
	FROM EMP e ;

-- 1단계 같은 메니저이기 때문에 GROUP BY을 통해서 MGR를 처리 하면 된다
-- 주의점 : GROUP BY 함수는 집계 혹은 GROUP BY에 사용된 컬럼만 사용가능하다
SELECT MGR, SUM(SAL)
	FROM EMP e 
	GROUP BY MGR;

-- 2단계 LEFT OUERT JOIN을 통해서 MGR 의 정보를 출력
SELECT e.EMPNO 사원번호, e.MGR 메니저번호, e2.SUMSAL 
	FROM EMP e  LEFT JOIN (
							SELECT MGR, SUM(SAL) SUMSAL
								FROM EMP e 
								GROUP BY MGR
							) e2
	ON e.MGR = e2.MGR 
	ORDER BY 메니저번호;


-- 3단계 연관서브쿼리
SELECT e.EMPNO 사원번호, E.MGR 메니저번호,
	(
		SELECT SUM(e2.SAL)
			FROM EMP e2 
			WHERE e.MGR = e2.MGR 
	) 급여합
	FROM EMP e; 

-------------------------------------------------------------------------------
/*
 * 현재 ROW를 기준으로 이전의 모든 값을 범위로한다
 *   => ROWS UNBOUNDED PRECEDING 
 * 
 * WINDOWING 절은 ORDER BY에 의해서 동작된다
 * WINDOWING 절의 Default 값은 RANGE|ROWS UNBOUNDED PRECEDING
 * 
 * RANGE는 ROWS와는 다르게 같은 값이라면 같은 계산으로 처리함
 *   ROWS를 한줄을 기준으로 처리 하기 때문에 정대 중복은 있을 수 없다. 할줄 씩 계산이 가능하다
 */


-- ROWS 기준 vs RANGE 기준
-- 설명 : SUM()OVER() 를 누적 RANGE vs ROWS
SELECT EMPNO 사원번호, e.MGR 메니저번호, SAL,
	SUM(SAL) OVER(PARTITION BY DEPTNO ORDER BY SAL
				  ROWS UNBOUNDED PRECEDING) ROWS_SUM,
	SUM(SAL) OVER(PARTITION BY DEPTNO ORDER BY SAL
				  RANGE UNBOUNDED PRECEDING) RANGE_SUM			  
	FROM EMP e 
	WHERE e.DEPTNO ='20';

-- 결과
/*
 * ROWS
 * 7369	7902	800	800
	7876	7788	1100	1900
	7566	7839	2975	4875
	7902	7566	3000	7875	<== ROWS 기준이기 때문에 800+1100+2975+3000
	7788	7566	3000	10875	<== ROWS 기준이기 때문에 800+1100+2975+3000+3000
 * 
 * RANGE 결과
 * 	7566	7839	2975		4875
	7902	7566	3000		10875   <== 같은 값이기 때문에 같은 3000+3000으로 처리 한다
	7788	7566	3000		10875   <== 같은 값이기 때문에 같은 3000+3000으로 처리 한다
 */


-- Q. MAX / MIN 
--    같은 메니저를 두고 있는 사원들이 급여중 최대/최소 급여
SELECT EMPNO 사원번호, e.MGR 메니저번호, SAL 급여,
	MAX(SAL) OVER(PARTITION BY e.DEPTNO) 최대급여,
	MIN(SAL) OVER(PARTITION BY DEPTNO) 최소급여,
	MAX(SAL) OVER(PARTITION BY e.DEPTNO ORDER BY SAL ROWS UNBOUNDED PRECEDING) 최대급여_오름차순정리,
	MAX(SAL) OVER(PARTITION BY e.DEPTNO ORDER BY SAL ROWS BETWEEN CURRENT ROW AND UNBOUNDED FOLLOWING) 최대급여_범위,
	MIN(SAL) OVER(PARTITION BY e.DEPTNO ORDER BY SAL ROWS UNBOUNDED PRECEDING) 최소급여 --오름차순 정렬이 되어 있기때문
	FROM EMP e 
	WHERE e.DEPTNO ='20';

-- 전체평균 - EMP의 전체
SELECT e.EMPNO , MGR, AVG(SAL) OVER() -- 전체 급여의 평균
	FROM EMP e ;

SELECT e.EMPNO , MGR, (SELECT AVG(SAL) FROM EMP)
	FROM EMP e ;

-- SAL에 ORDER BY를 통해서 범위의 평균 ROWS|RANGE 
SELECT e.EMPNO , MGR, SAL,
							AVG(SAL) OVER(PARTITION BY MGR ORDER BY SAL DESC) -- RANGE
	FROM EMP e 
	WHERE MGR ='7698';

SELECT e.EMPNO , MGR, SAL,
							AVG(SAL) OVER(PARTITION BY MGR ORDER BY SAL DESC ROWS UNBOUNDED PRECEDING) -- ROW
	FROM EMP e 
	WHERE MGR ='7698';

-- 자신을 기준으로 ROW의 개수를 선택 EX) 앞1 > 나 > 뒤1
-- 자신을 기준으로 RANGE으 값을 선택  EX) 500(1500) > 나(1000) > 500(500)
SELECT e.EMPNO , MGR, SAL,
							AVG(SAL) OVER(ORDER BY SAL ROWS BETWEEN 1 PRECEDING AND 1 FOLLOWING)
	FROM EMP e 
	WHERE MGR ='7698';

SELECT e.EMPNO , MGR, SAL,
							AVG(SAL) OVER(ORDER BY SAL RANGE BETWEEN 1 PRECEDING AND 1 FOLLOWING)
	FROM EMP e 
	WHERE MGR ='7698';

/*
 * 	ROWS 기준(앞뒤 1ROW씩 계산)		평균
 * 	A 950						(A+B)/2
	B 1250						(A+B(나)+C)/3
	C 1250		
	D 1500		
	E 1600						(D +E(나))/2
	
	RANGE 기준(값 +1, -1범위계산)	평균
 * 	A 950						949 ~ 951 : 나 950
	B 1250						1249 ~ 1251 : (A+B)/2 1250
	C 1250		
	D 1500		
	E 1600						1599 ~ 1601 : 나 1600
 * 
 */

-- 앞의 값이 +100 ~ -100 으로 RANGE로 처리해 보겠다
SELECT e.EMPNO , MGR, SAL,
							AVG(SAL) OVER(ORDER BY SAL RANGE BETWEEN 100 PRECEDING AND 100 FOLLOWING)
	FROM EMP e 
	WHERE MGR ='7698';
-- 분석
/*
 *  SAL 	범위(-100~+100)
 * 	950		850 ~ 1050		950
	1250	1125 ~ 1350	 	(1250 +1250) /2 = 1250
	1250	1125 ~ 1350		(1250 +1250) /2 = 1250
	1500	1400 ~ 1600		(1500 + 1600)/2 = 1550
	1600	1500 ~ 1700		(1500 + 1600)/2 = 1550
 */


-- COUNT 
-- RANGE 값의 범위 n-@ < N < n+@ 사이에 값이 있다면 선택하여 집계 하겠다
-- ROW 현재 나의 줄로 부터 앞+n < CURRENT ROW < 뒤+n 사이의 ROW를 선택하여 집계 하겠다

-- 분석
/*
 *  SAL 	범위(-200~+200)	범위에 있는 (ROW)갯수
 * 	950		750 ~ 1150			1(자신)
	1250	1050 ~ 1450	 		2개
	1250	1025 ~ 1450			2개
	1500	1300 ~ 1700			2개
	1600	1400 ~ 1800			2개
 */

SELECT SAL, 
			COUNT(*) OVER(ORDER BY SAL RANGE BETWEEN 200 PRECEDING AND 200 FOLLOWING) "범위 개수"
	FROM EMP e 
	WHERE MGR = '7698';










