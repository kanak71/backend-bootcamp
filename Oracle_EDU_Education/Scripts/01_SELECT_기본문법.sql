-- SELECT 기본 문법 INTRO

-- 기본 SYNTEX
-- SELECT 컬럼명, 컬럼명 FROM 테이블명 [WHERE 컬럼='값']

-- 1) 와일드카드 * (wild card - 전체 컬럼)
-- Q. 축구선수들(PLAYER)의 정보를 모두(*) 조회(SELECT)하고 싶다

SELECT * 
	FROM PLAYER p;

-- '(Single Quote), "(Double Quote)
-- ' SQL문에서 값, " 대소문자의 예약어 컬럼의 정의 할 때 사용

--Q. 축구선수들 중에서 PLAYER_ID가 2008468인 선수의 아이디와, 선수이름, 포지션을 조회하고싶다

SELECT p.PLAYER_ID, p.PLAYER_NAME, p."POSITION"	--POSITION은 예약어이기 때문에 ""으로 컬럼지정해 줘야 한다
	FROM PLAYER p
	WHERE p.PLAYER_ID = '2008468';

--Q. 축구선수들 중에서 선수 이름 김성환인 선수의 아이디와, 선수이름, 포지션의 정보를 조회하고싶다
-- 테이블선정 : 축구선수들(PLAYER)
-- 조건(선택) : 선수 아이디가 김성환, PLAYER_NAME ='김성환'
-- 조회컬럼 : 아이디와, 선수이름, 포지션 | PLAYER_ID, PLAYER_NAME, "POSITION"

SELECT p.PLAYER_ID, p.PLAYER_NAME, p."POSITION"
	FROM PLAYER p
	WHERE p.PLAYER_NAME = '김성환';

--Q. 축구선수 정보중에서 선수 아이디, 선수 이름, 포지션을 조회
-- 출력되는 컬럼명을 한글로 변경해 주세요
SELECT p.PLAYER_ID AS 아이디,	--AS는 생략이 가능
	p.PLAYER_NAME 성명,
	p."POSITION" 포지션
	FROM  PLAYER p; 

-- "사용할때는 Alias에는 공백이 있을 때 하나의 묶음으로 정의
SELECT p.PLAYER_ID AS 아이디,	--AS는 생략이 가능
		p.PLAYER_NAME "선수 성명",
		p."POSITION" 포지션,
		p.BACK_NO,
		'1'
	FROM  PLAYER p; 

-- 축구선수에서 POSITION은 예약어이다. 따라서 대소문자를 구분, 예약어는 사용하지 않아야하고, 명확하게 컬럼명을 정의 해줘야 한다
-- " 지정해줘야한다. USER
CREATE TABLE "USER"(
	ID NUMBER,
	NAME VARCHAR2(100)
);

SELECT *
	FROM "USER";

SELECT *
	FROM player;

--Alias (테이블, 컬럼)
-- 컬럼 : 출력되는 컬럼의 명은 변경, ID AS 컬럼명, 공백이 있거나 예악어라면 ID AS "컬 럼명"
-- 테이블 FROM 절에서 사용되는 테이블의 간편이름
-- ** ANSI/ISO 표준기구, FROM절 Alias 사용하라고 권고
-- ** PROGRAMRS 에서 DB FROM Alias가 없으면 정답이라고 인정하지 않음

--Q. 축구선수들의 정보를 모두 조회해 주세요
SELECT *
	FROM PLAYER p;
	
SELECT PLAYER.*
	FROM PLAYER p;


SELECT p.*
	FROM PLAYER p;

--Q. 축구선수들의 정보중에서 선수이름 선수영문이름을 조회해 주세요
-- 1) Alias 없이 사용
SELECT PLAYER_NAME, E_PLAYER_NAME  
	FROM PLAYER p ;

-- 2) Alias를 통해서 명확한 테이블을 지정한다
SELECT P.PLAYER_NAME, P.E_PLAYER_NAME  
	FROM PLAYER p ;

-- 3) Alias의 사용과 테이블의 사용 혼합 => 문제 발생
SELECT PLAYER_NAME, p.E_PLAYER_NAME  
	FROM PLAYER p ;

SELECT PLAYER_NAME, E_PLAYER_NAME
	FROM PLAYER;
-- 정리 : FROM절 Alias는 필수는 아니지만 권고사항, 모든 ide가 자동으로 Alias를 만듦
--		Alias가 있다면 무조건 Alias만을 사용
--		*** 테이블명으로 컬럼을 호출하지 마세요

-- 테이블의 JOIN : Alias의 문제점
-- 결론 : 같은 컬럼의 명을 가지고 있다면, 명확하게 어떠한 테이블의 컬럼인지를 선정해 줘야 한다.
-- 원래 테이블은 하나로 되어있는데 
-- 무결성제약조건, 이상현상, 정규화

--Q. 축구선수들의 정보와 선수들의 소속 팀명을 같이 조회하고 싶다
-- 테이블 : PLAYER, TEAM
SELECT p.PLAYER_NAME, p.TEAM_ID
	FROM PLAYER p;

SELECT t.TEAM_ID, t.TEAM_NAME
	FROM  TEAM t;

--TEAM_ID 컬럼은 PLAYER 테이블도 가지고 있고, TEAM 테이블도 가지고 있다
--		따라서 명확하게 어떠한 TEAM_ID를 가져올 지 선택
--		FROM절 Alias를 통해서 명확하게 선택해 줘야한다
SELECT p.PLAYER_NAME, p.TEAM_ID, t.TEAM_ID, t.TEAM_NAME
	FROM PLAYER p JOIN TEAM t
	ON P.TEAM_ID = T.TEAM_ID;

-- 4) 조건절
-- 조건절 비교 , AND(교집합), OR(합집합)
-- 연산자 우선순위 : () , SQL연산자(예약어로 되어 있는 연산자), AND, OR

--Q. 사원테이블에서 사원아이디가 7369인 사원의 정보를 조회
-- 사원테이블 : EMP
-- 사원아이디 컬럼 : EMP_ID
-- 조건 : EMPNO = '7369;

SELECT *
	FROM EMP
	WHERE EMPNO = '7369';

--Q. 사원테이블에서 사원의 업무가 CLERK인 사원의 정보를 조회
SELECT *
	FROM EMP e
	WHERE e.JOB = 'CLERK';

--Q. 사원테이블에서 사원의 업무가 CLERK인 사원과 사원 번호가 '7782'인 사원의 정보를 조회
-- 사원테이블 : EMP
-- 사원아이디 컬럼 : JOB, EMPNO
-- 조건 : JOB = 'CLERK' 과(OR) EMPNO = '7782'
SELECT *
	FROM EMP
	WHERE JOB = 'CLERK' OR EMPNO = '7782';

SELECT *
	FROM EMP
	WHERE JOB = 'CLERK' OR EMPNO = '7369';

--Q. 사원 테이블에서 직원 아이디가 '7369', '7876'인 사원의 정보를 조회
SELECT *
	FROM EMP e
	WHERE e.EMPNO = '7876' OR e.EMPNO = '7369';

-- SQL 연산자(IN)을 사용하면 코드가 간결해진다
-- 계속해서 조건의 EMPNO가 늘어나면 반복되는 코드가 많아지게 된다. IN SQL연산자를 통해서 해당 코드를 줄일 수 있다
SELECT *
	FROM EMP e
	WHERE e.EMPNO IN('7876', '7369') ;

----




-- 시험문제
-- Q. 사원테이블에서 사원아이디가 7369이면서 업무가 CLERK인 사원과
--				사원아이이가 7566이면서 업무가 MANAGER인 사원을 조회
SELECT *
	FROM EMP e
	WHERE e.EMPNO ='7369' AND e.JOB ='CLERK'
	OR e.EMPNO = '7566' AND e.JOB ='MANAGER';

SELECT *
	FROM EMP e
	WHERE (e.EMPNO , e.JOB) IN (('7369', 'CLERK'), ('7566','MANAGER'));

-- 시험문제(DISTINCT) 함수
-- 정의 : SELECT 절에 검색된 컬럼의 결과에 중복되는 값이 있다면 한개로 만들어준다
-- 주의점 : !! 단, 선택된 SELECT 절의 다른 컬럼에 영향을 받는다
--Q. 축구선수의 이름과 포지션의 정보를 조회
SELECT p.PLAYER_NAME , p.:
	FROM PLAYER p;














	