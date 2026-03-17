-- 비율함수
-- RATIO_TO_REPORT : 전체값에서 차지하고 있는 비율
-- PERCENT_RANK : 처음(0)과 끝(1) 위치
-- CUME_DIST : 개수의 비율

-- ** 주의점 : 같은 값을 가지고 있다면 결과가 중복되어서 나온다
-- 1) RATIO_TO_REPORT : 둘리 3000만원, 도우너 2000만원, 또치 1000만원 = 전체 급여 6000만원
--						3000/6000, 2000/6000, 1000/6000
-- 결론 : 전체 값에서 자신의 값이 차지하고 있는 비율
SELECT ENAME, SAL,
	TRUNC (RATIO_TO_REPORT(SAL) OVER(),3) * 100 비율
	FROM EMP e
	WHERE e.DEPTNO = '20';

-- 주의점 : 같은 값의 RANK라면 같은 비율의 값을 가진다
-- 2) PERCENT_RANK

SELECT ENAME, SAL,
	PERCENT_RANK() OVER(ORDER BY SAL)
	FROM EMP
	WHERE DEPTNO = '20';

-- 주의점 : 같은 값은 같은 비율의 다음값을 출력한다
/*
 * 	FORD	3000	1		0.4
	SCOTT	3000	1		0.4
	JONES	2975	0.6		0.6
	ADAMS	1100	0.4		0.8
	SMITH	800		0.2		1
	-- CUME_DIST는 5개의 값이라면 0.2 비율을 가지고 있다
	-- 순서대로           1 > 0.8 > 0.6 > 0.4 > 0.2 
	-- 중복되는 값이 있다면 1 > 1    > 0.6 > 0.4 > 0.2 
 */
-- 3) CUME_DIST
-- 개수의 비율
SELECT ENAME, SAL,
	CUME_DIST() OVER(ORDER BY SAL) 오름차순, 
	CUME_DIST() OVER(ORDER BY SAL DESC) 내림차순
	FROM EMP e 
	WHERE e.DEPTNO =20;









