SELECT *
	FROM PLAYER p
	WHERE p.PLAYER_ID = '2011057';

--** INDEX란(WHERE)?
-- 	 PK를 사용하면 RDDMS가 검색, 그냥 검색 Full-Table Scan : 전체를 검색 - 속도가 느려
--							INDEX를 생성하면 속도가 빨라질 수도 있음, 그러나 잘못 만들면 느려진다

-- Q. K-리그 일부 선수들의 이름, 포지션, 등번호를 알고싶다
--	소속팀이 삼성블루윙즈 이거나 전남드레곤즈에 소속된 선수들 중에서
--	포지션이 미드필더(MF) 이면서
--	키는 170cm 이상이고 180이하여야 한다

-- 1) 분석
-- 테이블 : PLAYER 
-- 컬럼 : 선수이름(PLAYER_NAME), 포지션(POSITION), 등번호(BACKNO)
-- 조건 : 소속팀(삼성블루윙스 or 전남드래곤즈) - TEAM에 들어가 있어요
-- 		and
--		포지션(MF)
--		and
--		HEGITH ( 170 <= A <= 180)

-- 2) 1번 조건 찾음 : 소속팀(삼성블루윙스 or 전남드래곤즈) - TEAM에 들어가 있어요
-- 테이블 : TEAM
-- 컬럼 : 소속팀명(TEAM_NAME)
-- 조건 : 삼성블루윙스, 전남드레곤즈
-- 이유 : PLAYER의 TEAM_ID는 TEAM의 테이블의 TEAM_ID와 FK로 되어 있다
-- 		따라서 TEAM테이블에서 TEAM_ID를 찾아 내야 한다

SELECT t.TEAM_ID, t.TEAM_NAME
	FROM TEAM t
	WHERE t.TEAM_NAME = '삼성블루윙즈' OR t.TEAM_NAME = '전남드래곤즈';

-- LIKE 문 => 값을 추측(갯수, 일부단어)
-- 일부분의 단어를 포함하는 값을 찾아냄 LIKE (SQL연산자)를 사용하여 찾아보자
-- 정의 : (%) 모든 것 이라는 뜻, %삼성% - 사용하지 마세요(하드웨어 부하), %삼성 - 덜 사용, 삼성% / 삼성이포함된문자, 뒷글자가 삼성, 앞글자가 삼성
--  특정 갯수(_ 임의 단어) - 권장함, 삼성____ (삼성 뒤에 네글자를 가지고 있는 것) -> auto complete => elastic search => logstack

-- K02, 삼성블루윙즈
SELECT t.TEAM_ID , t.TEAM_NAME 
	FROM TEAM t
	WHERE t.TEAM_NAME LIKE '%블루%';

-- k07, 드래곤즈
SELECT t.TEAM_ID , t.TEAM_NAME 
	FROM TEAM t
	WHERE t.TEAM_NAME LIKE '드래__';

--OR절은 IN절 사용하면 돼요
--PLAYER중에서 드래곤즈(K07), 삼성블루윙즈(K02)

SELECT *
	FROM PLAYER p
	WHERE p.TEAM_ID ='K07' OR p.TEAM_ID = 'K02';

--위와 같음
SELECT *
	FROM PLAYER p
	WHERE p.TEAM_ID  IN ('K07','K02');

--3) 포지션이 MF(미드필더)
SELECT p.PLAYER_NAME "선수이름", p."POSITION" 포지션, p.BACK_NO 등번호
	FROM PLAYER p 
	WHERE p.TEAM_ID IN ('K07','K02')
	AND p."POSITION" = 'MF';

SELECT p.PLAYER_NAME "선수이름", p."POSITION" 포지션, p.BACK_NO 등번호
	FROM PLAYER p 
	WHERE (p.TEAM_ID ='K07' OR p.TEAM_ID ='K02')
	AND p."POSITION" ='MF';

--Q. K02 선수들은 공격수(FW)와 
--	 K07 선수들은 미드필더(MF)인          선수들을 조회
--컬럼 : 팀(TEAM_ID) AND 포지션(POSITION)

SELECT p.PLAYER_NAME "선수이름", p."POSITION" 포지션, p.BACK_NO 등번호
	FROM PLAYER p 
	WHERE (p.TEAM_ID , p."POSITION" ) IN (('K02','FW'),('K07','MF'));


SELECT p.PLAYER_NAME "선수이름", p."POSITION" 포지션, p.BACK_NO 등번호
	FROM PLAYER p 
	WHERE (p.TEAM_ID ='K02' AND p."POSITION" ='FW')
	OR p.TEAM_ID ='K07' AND p."POSITION" ='MF';

-- 4) HEGITH ( 170 <= A <= 180)
-- 분석 : 이상/이하 <=, >=
--		 미만/초과 <, >
-- 연산자로 처리 했을 경우(AND, >= <=) 순서에 상관이 없다. 자유롭게 작성해도 된다
SELECT *
	FROM PLAYER p
	WHERE HEIGHT >= 170 AND HEIGHT <= 180;

SELECT *
	FROM PLAYER p
	WHERE HEIGHT <= 180 AND HEIGHT >=170;

--"이상과 이하"를 처리할 수 있는 BETWEEN a AND b (SQL연산자)
-- 반드시 a자리에 작은 값이 있어야 한다
SELECT *
	FROM PLAYER p 
	WHERE p.HEIGHT BETWEEN 170 AND 180;	--반대로 쓰면 안나온다
	
-- 부정연산자
-- NOT(SQL연산자), !, <>, ^
--Q. K01에 소속된 선수들 중에서 포지션이 MF인 선수
SELECT *
	FROM PLAYER p
	WHERE  p.TEAM_ID ='K01'
	AND p."POSITION" = 'MF';

--Q. K01에 소속된 선수들 중에서 포지션이 MF이 아닌 선수
SELECT *
	FROM PLAYER p
	WHERE  p.TEAM_ID ='K01'
	AND NOT p."POSITION" = 'MF'; --SQL 부정연산자 NOT은 컬럼 앞에 작성
	AND p."POSITION" != 'MF';	--! 연산자는 비교연산자
	AND p."POSITION" ^= 'MF';	--^ 연산자는 비교연산자
	AND p."POSITION" <> 'MF';	--! 연산자는 비교연산자
	
	
SELECT *
	FROM PLAYER p
	WHERE  p.TEAM_ID ='K01'
	AND p."POSITION" NOT IN('MF');	--경험이 있는 사람
	AND NOT p."POSITION" IN('MF');	--NOT IN인데 NOT 컬럼 앞에 적어도 된다
	
SELECT *
	FROM PLAYER p
	WHERE  p.TEAM_ID ='K01'
	AND p."POSITION" IN ('FW', 'GK','DF');

-- ** NOT은 같은 SQL연산자와 많이 사용
-- *** ^ <> ! 연산자

--NULL은 값이 아니다 -> 비교연산자를 사용할 수 없다
--NULL은 NULL 만을 위한 함수 
-- IS
SELECT p.NICKNAME 
	FROM PLAYER p
	WHERE p.NICKNAME IS NULL;	--NULL은 IS로 판단
	
	SELECT p.NICKNAME 
	FROM PLAYER p
	WHERE p.NICKNAME IS NOT NULL;	--NULL은 IS로 판단
--	WHERE NOT p.NICKNAME IS NULL;	--가능
	
	
-- 고민사항
SELECT *
	FROM PLAYER p
	WHERE NOT (p.HEIGHT BETWEEN 170 AND 180);

-- NOT 부정연산자
-- 모두 다 반대로 >= 는 <, <= 는 >, AND는 OR, OR은 AND로 바뀐다

SELECT *
	FROM PLAYER p
	WHERE HEIGHT >= 170 AND HEIGHT <= 180;

--위의 애를 부정연산자 안쓰고 부정한 것
SELECT *
	FROM PLAYER p
	WHERE HEIGHT < 170 OR HEIGHT > 180;


SELECT p.PLAYER_NAME 이름 , p."POSITION" 포지션, p.BACK_NO 등번호
	FROM PLAYER p
	WHERE p.TEAM_ID IN ('K02', 'K07')
	AND p."POSITION" = 'MF'
	AND p.HEIGHT BETWEEN 170 AND 180;


	
	
	
	
	
	
	
	
	
	



