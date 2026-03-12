-- 정의 : NULL은 입력되어진 미지의 값
-- 주의점 : 판단, 연산, CONCAT
-- 고려사항 : RDBMS에 따라서 특징

--ORACLE, MYSQL(mariaDB), POSTGESQL => 벤더사(vendor)
-- 1) 결과 : NULL과 연산의 모든 결과는 NULL
-- Q. 모든 직원에게 100씩 보너스를 지급하고싶다
SELECT ENAME, SAL, COMM 
	FROM EMP;
	
SELECT ENAME, SAL, NVL(COMM,0) + 100 보너스, COMM 
	FROM EMP;

--2) 결과 : NULL과 CONCAT은 없는 값으로 치환하여 만들어진다
-- ORACLE에선 CONCAT() 함수, ||
-- 다른 벤더사 +

SELECT p.PLAYER_NAME , p.NICKNAME , p.NICKNAME ||'님' 문자CONCAT
	FROM PLAYER p
	WHERE p.NICKNAME  IS NOT NULL;	--NULL은 비교연산의 결과는 FALSE이기 때문에 NUL관련 SQL연산자를 사용해야 한다
	
SELECT p.PLAYER_NAME , p.NICKNAME , CONCAT(p.NICKNAME ,'님') 문자CONCAT
	FROM PLAYER p
	WHERE p.NICKNAME  IS NOT NULL;

--3) 결론 : NULL과의 비교연산은 모두 FALSE
SELECT *
	FROM EMP
	WHERE COMM = NULL;	--NULL을 비교연산 FALSE => 따라서 FALSE이기 때문에 => 공집합으로 처리된다
	
	SELECT *
	FROM EMP
	WHERE COMM > 1;
	
--NULL은 처리하는 SQL 연산자가 존재한다 IS, IS NOT
	
SELECT *
	FROM EMP 
	WHERE COMM IS NOT NULL;

--'', NULL, 'NULL' 차이점
-- ''도 NULL
-- NULL은 NULL
--'NULL'은 값이다 : DB에서 값은 숫자든 문자든 날짜든 모두 '값' 넣어서 처리해주세요
SELECT '', NULL, 'NULL'
	FROM DUAL;
	
--*** NULL을 위한 IS 연산자 사용 주의사항
-- 맞는 예)
SELECT *
	FROM EMP e
	WHERE COMM IS NULL;
	
SELECT *
	FROM EMP e
	WHERE COMM IS NOT NULL;

SELECT *
	FROM EMP e
	WHERE NOT COMM IS NULL;

-- 잘못된 문법
SELECT *
	FROM EMP e
	WHERE NOT COMM = NULL;
SELECT *
	FROM EMP e
	WHERE COMM NOT IS NULL;

--ROWNUM
--정의 : ROWNUM은 FROM절의 순서대로 읽어서 번호를 작성해준다
--결론 : 1이 생성되지 않은 다음 값은 출력되지 않는다
--고전쿼리 : ORACLE - 페이징처리 -> OFFSET
--		MYSQL, POSTGESQL - LIMIT
--		JPA - JpaRepository -> Pageable
--		JAVA -> DTO객체, view -> javascript로 처리하여 << <1 2 3 4 5> >>
--문제점 : ***FROM절에 입력되어 있는 순서대로 나오면서 번호를 처리한다

SELECT *
	FROM EMP e
	WHERE ROWNUM <5;

--앞번호가 없으면 다음 번호는 생성하지 못한다
SELECT *
	FROM EMP e
	WHERE ROWNUM = 2;	--아무것도 나오지 않는다
	
-- 정리 : ROWNUM은 Database에 입력되어 있는 순서대로 출력
-- Q. 급여가 높은 순서대로 5명을 조회해 주세요 -> 불가능
-- 해결방법 : SubQuery를 사용해 데이터를 재정리 한 후 FROM절로 사용 : Inline view
--*************************
-- *****중요한것
-- 퀴리문은 RDBNS가 읽어내는 순서가 있다
-- 3번 SELECT 절 : 출력되는 컬럼을 작성
-- 1번 FROM 절 : DB에 물리적으로 저장되어 있는 데이터 불러오는 곳
-- 2번 WHERE 절 : FROM절의 데이터를 조건을 처리
	
SELECT *
	FROM EMP e
	WHERE SAL IS NOT NULL
	ORDER BY SAL DESC;	--가장 높은 사원의 급여가 5000이네
	
-- Q. 급여가 높은 순서대로 3명
SELECT *
	FROM (SELECT *
		FROM EMP e
		WHERE SAL IS NOT NULL
		ORDER BY SAL DESC)
	WHERE ROWNUM < 4;

SELECT *
	FROM EMP e
	WHERE ROWNUM <4;	--얘는 다름. SQL 순서대로 3개 출력됨

-- 3) 페이징 : 최신순(날짜 : DESC) 으로 각 묶음(3묶음 그룹)
-- 			10명 -> ORDER BY 날짜 DESC -> 번호 ROWNUM -> 3(1~3) 3(4~6) 3(7~9) 1(10)
	
SELECT ROWNUM RN, ENAME, EMPNO , HIREDATE , SAL
	FROM(SELECT e.EMPNO , e.EMPNO , e.HIREDATE , e.SAL
			FROM EMP e 
			ORDER BY e.HIREDATE DESC)
	WHERE RN BETWEEN 1 AND 3;
		


	
	
	
	