-- 집계함수
-- ** 집계함수는 여러개의 ROW가 입력된 하나의 결과를 가져온다. 따라서 여러개의 결과를 반환할 수 없다
-- ** SELECT절의 집계함수는 집계함수만 사용이 가능하다
-- ***** DISTICNT : SELECT의 출력된 컬럼을 단순히 중복된 값을 묶음으로 만들어 줌, 다른 컬럼이 묶음이 풀린다
--			ㄴ NULL도 묶음으로 처리한다
-- ** 집계 함수의 NULL : 대상이 아니다
--		ㄴEMP(COMM) - AVG를 하면 NULL은 개수로 체크하지 않고 값이 있는 컬럼만 대상으로 /4로 처리를 한다 

SELECT DISTINCT (TEAM_ID), p."POSITION"
	FROM PLAYER p
	ORDER BY 1;

--집계 함수의 종류
--1) COUNT(*) : 게시글의 전체 개수
SELECT COUNT(*),	--482명의 선수가 있다
		COUNT(p.E_PLAYER_NAME),	--NULL은 집계가 되지 않는다
		COUNT(NVL(p.E_PLAYER_NAME,'EMPTY'))
--		p.PLAYER_ID --집계함수는 하나의 결과를 출력한다
	FROM PLAYER p;

--2) MAX(), MIN()
--Q. 선수들 중에서 키가 가장 큰 / 작은 선수의 키를 출력
SELECT MAX(p.HEIGHT ) 큰선수, MIN(p.HEIGHT ) 작은선수, MAX(p.WEIGHT ) 
	FROM PLAYER p;

--사용 : 많이 팔린 물품, 최근 날짜, ID만들어 낼 때 사용
-- 예> 2026001 -> 2026033
SELECT *
	FROM USERINFO u;
-- 기존에는 Sequence 테이블을 사용해서 NEXTVAL를 통해 값을 사용
-- Q. 다음 SEQ값을 알고싶다. USERINFO_SEQ로 생성되어 있다. CURRVAL은 사용이 불가능. NEXTVAL 다음값
SELECT MAX(SEQ) + 1
	FROM USERINFO u;

SELECT MAX(p.PLAYER_ID )
	FROM PLAYER p;

--다음 아이디값 만들기
--부서명 + 입사년도 + 순번 => JPA ID Long으로 자동 생성
SELECT TO_CHAR(SYSDATE, 'YYYY'),
		SUBSTR(MAX(p.PLAYER_ID), 5, 3) +1 "최대값의 다음값"
	FROM PLAYER p;

SELECT LPAD(MAX(p.PLAYER_ID), 5, 3) +1,3,'0'
	FROM PLAYER p; 

--Q. 실제적으로 어떻게 사용될까?
-- 분석 : 선수ID는 년도가 변경되면 다시 2026 -> 2027 + 시퀀스 "현재년도+000" 작성
--		같은 헤라면 입력되어 있는 최대값의 +1 입력하면 된다

INSERT INTO PLAYER (PLAYER_ID, PLAYER_NAME, TEAM_ID )
	VALUES(
	-- 서브쿼리
		(
			SELECT TO_CHAR(SYSDATE, 'YYYY') ||
				CASE 
					WHEN SUBSTR(MAX(p.PLAYER_ID),1,4) = TO_CHAR(SYSDATE, 'YYYY') 
						THEN LPAD(SUBSTR(MAX(p.PLAYER_ID ),5,3)+1, 3,'0')
					ELSE '001' 
				END
				FROM PLAYER p 
		)
	,
	'포테토칩', 'K01'
	);

SELECT *
	FROM PLAYER p
	ORDER BY 1 DESC;

--Q. 선수들 중에서 키가 가장 큰 선수의 이름, 소속팀, 등번호, 포지션을 조회하고 싶다
--FROM절을 사용하는 INLINE VIEW

-- 1단계
SELECT MAX(p.HEIGHT)
	FROM PLAYER p ;

--2단계 - 실수 많이 하는 부분 : WHERE절에는 집계함수를 사용할 수 없다
SELECT *
	FROM PLAYER p 
	WHERE p.HEIGHT = MAX(p.p.HEIGHT );

-- 3단계 - 결과를 출력이 단일로 나오기 때문에 추가적인 쿼리를 작성한다(서브쿼리 - Scala)
SELECT p.PLAYER_NAME, p."POSITION" , p.TEAM_ID , p.BACK_NO 
	FROM PLAYER p
	WHERE p.HEIGHT = (SELECT MAX(p.HEIGHT)
						FROM PLAYER p);

SELECT p.PLAYER_NAME, p."POSITION" , p.TEAM_ID , p.BACK_NO 
	FROM PLAYER p JOIN(SELECT MAX(p.HEIGHT) HEIGHT
						FROM PLAYER p) t1
	ON p.HEIGHT = t1.HEIGHT;





