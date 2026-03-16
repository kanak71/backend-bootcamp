-- 서브쿼리(Sub-Query)
-- 쿼리(main)안에 ()안에 또 다른 쿼리가 실행되는 형태

-- 1. 스칼라 서브쿼리(scala sub-query)
--	 사용 : SELECT. WHERE, HAVING, ORDER BY, INSERT, UPDATE
-- 2. 인라인 뷰
--	 사용 : FROM

-- Q. 전남드래곤즈(K07), 삼성블루윙즈(K02) 선수들의 정보조회

SELECT t.TEAM_NAME, t.TEAM_ID
	FROM TEAM t
	WHERE t.TEAM_NAME LIKE '%곤즈%';

SELECT t.TEAM_NAME, t.TEAM_ID
	FROM TEAM t
	WHERE t.TEAM_NAME LIKE '%윙즈%';

-- 서브쿼리를 통해서 검색 및 조회
-- ** t.TEAM_NAME LIKE '%곤즈%' OR t.TEAM_NAME LIKE '%윙즈%'는 IN절을 사용하지 못합니다
-- ** SQL의 정규화 표현식 WHERE REGEXP_LIKE '^(드래|삼성)'
SELECT *
	FROM PLAYER p
	WHERE p.TEAM_ID IN( 
						SELECT * 
							FROM TEAM t
							WHERE t.TEAM_NAME LIKE '%곤즈%' OR t.TEAM_NAME LIKE '%윙즈%'
	);

-- Q. 축구선수의 이름중에서 정남일 선수가 소속된 팀의 정보를 조회
SELECT *
	FROM PLAYER p JOIN TEAM t
	USING(TEAM_ID)
	WHERE p.PLAYER_NAME = '정남일';

--서브쿼리랑 비교연산자로 검색할때 많이 하는 실수
--서브쿼리 단일 혹은 다행으로 값이 출력된다
--단일(집계함수), 다행(여러개의 결과) -IN
SELECT *
	FROM PLAYER p JOIN TEAM t 
	USING (TEAM_ID)
	WHERE TEAM_ID = (SELECT p2.TEAM_ID 
						FROM PLAYER p2 
						WHERE p2.PLAYER_NAME ='정현수');

SELECT p2.TEAM_ID
	FROM PLAYER p2
	WHERE p2.PLAYER_NAME ='정현수';

-- Q. 축구선수들 정보에서 각 팀에서 가장 키가 작은 선수들의 정보를 조회 해주세요
				
-- 1단계 : 각팀별 가장 키가 작은 선수들 조회 - GROUP BY는 집계함수 혹은 GROUP BY절에 사용된 컬럼
SELECT p.TEAM_ID, MIN(p.HEIGHT )
	FROM PLAYER p
	GROUP BY p.TEAM_ID;
	
-- 2단계
SELECT *
	FROM PLAYER p
	WHERE (p.TEAM_ID , p.HEIGHT ) IN (
										SELECT p2.TEAM_ID, MIN(p2.HEIGHT )
											FROM PLAYER p2
											GROUP BY p2.TEAM_ID 
	);

-- 3단계 : INLINE VIEW
SELECT *
	FROM PLAYER p JOIN( 
						SELECT p2.TEAM_ID, MIN(p2.HEIGHT ) m
						FROM PLAYER p2
						GROUP BY p2.TEAM_ID 
	) p3
	ON P.TEAM_ID = p3.TEAM_ID 
	AND p.HEIGHT = p3.m;


-- 연관서브쿼리 : 메인쿼리의 하나의 ROW를 통해서 서브쿼리로 진행되는 방식

-- Q. 선수들이 소속된 팀의 평균 키보다 큰 선수들을 조회(팀명, 선수이름, 백넘버, 키, 소속팀 평균키)
-- 1단계
SELECT p.TEAM_ID , p.PLAYER_NAME , p.BACK_NO , p.HEIGHT 
	FROM PLAYER p;

-- 2단계 : 소속되어 있는 "소속팀 평균키"

SELECT p.TEAM_ID , p.PLAYER_NAME , p.BACK_NO , p.HEIGHT, 
	(SELECT AVG(p2.HEIGHT )
		FROM PLAYER p2
		WHERE p.TEAM_ID = p2.TEAM_ID) "소속팀 평균키"
	FROM PLAYER p;

-- 3단계 : 선수들이 소속팀의 평균키보다 큰선수 - 조건절
SELECT p.TEAM_ID , p.PLAYER_NAME , p.BACK_NO , p.HEIGHT, --3번
	(SELECT AVG(p2.HEIGHT )
		FROM PLAYER p2
		WHERE p.TEAM_ID = p2.TEAM_ID) "소속팀 평균키"
	FROM PLAYER p	-- 1번
	WHERE p.HEIGHT > ( 
						SELECT AVG(p3.HEIGHT )
							FROM PLAYER p3
							WHERE p.TEAM_ID = p3.TEAM_ID 	--2번
	)

--1번 : 메인쿼리의 FROM 데이터 가져온다
--2번 : 메인쿼리의 첫번째 ROW를 가져와서 서브쿼리(P3)의 테이블과 TEAM_ID로 조인한다
--	ㄴ HEIGHT를 AVG한다 => 소속팀의 평균키
--  ㄴ 메인쿼리의 WHERE 처리 해서 -> 참이면 메모리에 저장
-- 3번 : 출력

-- 팀명, 선수이름, 백넘버, 키, 소속팀 평균키
SELECT t.TEAM_NAME , p.PLAYER_NAME , p.BACK_NO , p.HEIGHT , p3.AVGH
	FROM PLAYER p JOIN(
						SELECT p2.TEAM_ID, AVG(p2.HEIGHT) AVGH
							FROM PLAYER p2
							GROUP BY p2.TEAM_ID
						)p3
	ON p.TEAM_ID = p3.TEAM_ID 
	AND p.HEIGHT > p3.AVGH 
	JOIN TEAM t
	ON p.TEAM_ID = t.TEAM_ID;

-- EXIST 존재하는가를 판단
-- Q. SCHEDULE에서 20120501 부터 20120502 사이의 경기가 있는 경기장
-- RDBMS는 자동으로 형변환이 발생한다. 따라서 제발 값타입 변경하지 마세요
SELECT *
	FROM SCHEDULE s 
	WHERE s.SCHE_DATE BETWEEN '20120501' AND '20120502';

-- 범위 내에서 존재여부를 판단하여 있으면 저장 없으면 저장하지 않음 EXISTS
SELECT *
	FROM SCHEDULE s
	WHERE EXISTS ( --SELECT절의 결과가 나왔다면 조건에 맞는 값이다
					SELECT 1 --공집합을 판단하는 기준의 값이면 된다
						FROM SCHEDULE s2
						WHERE s.STADIUM_ID = s2.STADIUM_ID 
	);
	

WITH CUSTOM AS (
  SELECT 1 AS CUST_ID, '홍길동' NAME FROM DUAL
  UNION ALL
  SELECT 2 AS CUST_ID, '고길동' NAME FROM DUAL
  UNION ALL
  SELECT 3 AS CUST_ID, '둘리' NAME FROM DUAL
),
ORDERS AS(
	SELECT 100 ORDER_ID , 1 AS CUST_ID FROM DUAL
	UNION ALL
	SELECT 101 ORDER_ID , 2 AS CUST_ID FROM DUAL
)
SELECT *
	FROM CUSTOM c
	WHERE NOT EXISTS (
				SELECT 1
					FROM ORDERS o
					WHERE c.CUST_ID = o.CUST_ID
				) ;


-- UPDATE 문에서 연관서브쿼리
-- 1장의 역정규화, TEAM 테이블에 STADIUM_NAME 컬럼을 추가하고
--				STADIUM 테이블에서 검색하여 UPDATE 해주세요

SELECT t.STADIUM_ID, 
	t.STADIUM_NAME --없는 테이블이다. 만들어서 맞는 정보를 STADIUM에서 조회해서 넣어줘
	FROM TEAM t;
	
-- 1단계 컬럼추가
ALTER TABLE TEAM ADD(STADIUM_NAME VARCHAR2(40));

-- 2단계 : 연관서브쿼리를 통해서 TEAM에 있는 STADIUM_ID를 STADIUM 테이블과 조인하여 값을 추출
UPDATE TEAM t SET STADIUM_NAME = ( 
								SELECT s.STADIUM_NAME 
									FROM STADIUM s
									WHERE t.STADIUM_ID = s.STADIUM_ID 
								);

-- INSERT문
-- SEQUENCE 테이블이 없는 경우 MAX함수를 사용하여 +1 하는 연산을 만들어 ID를 생성

INSERT INTO USERINFO (SEQ, CREATEAT, NAME)
	VALUES(
		(SELECT MAX(SEQ)+1
			FROM USERINFO u)
		,
		SYSDATE	
		,'GUEST'
	);

SELECT *
	FROM USERINFO u 
	ORDER BY 1 DESC;














