-- DML (SELECT, INSERT, DELETE, UPDATE)

-- INSERT(암묵적, 명시적)
-- * 명시적 작성방법에서만 DEFAULT 제약조건이 실행됨

-- 암묵적
-- 정의 : 테이블의 컬럼 순서, 타입을 모두 알고 있어야 한다
-- 		모든 컬럼 입력 대상으로 선택하기 때문 NN(NOT NULL)하지 않은 컬럼도 값을 입력해 줘야 한다

--Q. UNIV 테이블에 학교 정보를 넣어보자
-- INSERT INTO 테이블명 VALUES(값);
-- 컬럼의 개수가 명확해야 한다
INSERT INTO UNIV 	--오류
	VALUES('U01', '대학교');

-- 컬럼의 순서도 명확해야 한다
INSERT INTO UNIV 	--오류
	VALUES('U01', 'http://www,example.ac.kr', '대학교');


--명시적 선언방법(컬럼을 선택, 순서)
INSERT INTO UNIV(UNIV_TYPE, ID)
	VALUES('대학교','U01');

SELECT *
	FROM UNIV;

-- 여러개 입력 할 때
-- TRANSACTION 처리, 하드웨어 부하(많이하지말기)
-- 다중으로 insert 할때는 쿼리를 통해서 진행
INSERT INTO UNIV(ID, UNIV_TYPE, WEBSITE)
	SELECT 'U02', '고등학교', 'http://www.sample.ac.kr' FROM DUAL
	UNION ALL
	SELECT 'U03', '초등학교', 'http://www.sample.ac.kr' FROM DUAL;

-- INSERT 문의 주의 사항
-- FK와 PK의 관계
-- 테이블 생성은 부모 -> 자식
-- 값입력은 부모 -> 자식
-- 삭제 자식 -> 부모

--Q. 자식테이블에 부모(FK-PK)가 없는 값을 사용 입력한다
-- 무결성 제약조건
-- 오류 : 무결성 제약조건(EDU.USERINFO_FK)이 위배되었습니다- 부모 키가 없습니다
-- 분석 : 내가 입력하는 테이블은 어떠한 테이블과 FK-PK관계를 가지고 있고 부모(PK)가 값을 가지고 있지 않다

INSERT INTO USERINFO (SEQ, NAME, TEL, 	--3개씩 나눈 이유 : 보기편해서
					  ROLE, CREATEAT, UNIV_ID)
	VALUES(USERINFO_SEQ.NEXTVAL, '셜록홈즈', '113',
			'', SYSDATE, 'U10');

-- ROLE은 DEFAULT로 선언이 되어 있다
-- 명시적인 방법으로만 DEFAULT값을 입력 할 수 있다
-- **** ''는 입력하면 RDBMS는 NULL로 인식한다

INSERT INTO USERINFO (SEQ, NAME, TEL, 	
					  ROLE, CREATEAT, UNIV_ID)
	VALUES(USERINFO_SEQ.NEXTVAL, '셜록홈즈', '113',
			'', SYSDATE, 'U01');

SELECT *
	FROM USERINFO u;

SELECT *
	FROM UNIV u;

--DEFAULT 값은 명시적으로 작성해야 하고,  입력을 하지 않으면 DEFAULT로 처리 된다
INSERT INTO USERINFO (SEQ, NAME, TEL, 	
					  CREATEAT, UNIV_ID)
	VALUES(USERINFO_SEQ.NEXTVAL, '왓슨', '122',
			SYSDATE, 'U03');

SELECT *
	FROM USERINFO u;

--A. INSERT 문의 확인사항
-- 1) 명시적으로 사용하되 최소의 필수값은 반드시 입력해야 (NN)
-- 2) DEFAULT로 되어 있는 컬럼은 반드시 명시적 작성방법으로 해야 한다
-- 3) 자식은 반드시 부모의(PK_FK)의 값을 사용해야 한다, 관계가 없을때는 상관없다

--Q. PLAYER(자식), TEAM(부모)

--INSERT를 해보자 PLAYER
INSERT INTO PLAYER (PLAYER_ID, PLAYER_NAME, TEAM_ID)
	VALUES ('2026001', '베르나르', 'K99');		--무결성 제약조건(EDU.PLAYER_FK)이 위배되었습니다- 부모 키가 없습니다

--무결성 제약조건(PK) - 중복된 ID를 사용했다
INSERT INTO PLAYER (PLAYER_ID, PLAYER_NAME, TEAM_ID)
	VALUES ('2007155', '베르나르', 'K01');		--무결성 제약 조건(EDU.PLAYER_PK)에 위배됩니다
	
INSERT INTO PLAYER (PLAYER_ID, PLAYER_NAME, TEAM_ID)
	VALUES ('2026001', '베르나르', 'K01');


SELECT *
	FROM PLAYER p
	WHERE p.PLAYER_ID = '2026001';

-- UPDATE : 입력되어 있는 컬럼의 값을 수정
-- UPDATE 테이블명 SET 컬럼명 = '입력값', 컬럼명 = '입력값' .. [WHERE 조건절]

UPDATE PLAYER p
	SET NICKNAME = '개미수열'
	WHERE p.PLAYER_ID = '2026001';

-- DELETE 삭제
-- 테이블을 삭제하는 것은 DDL이다
-- DELETE는 테이블 안에 있는 ROW(데이터)를 삭제	
-- TRUNCATE => 복구가 불가능하다 : 속도가 빠름
-- DELETE 삭제 => 휴지통으로 간다(복구가능하다) : 속도가 느려
	
-- 삭제 할 때 자식 -> 부모를 삭제
DELETE FROM TEAM;	--TEAM은 PLAYER를 자식으로 가지고 있음
-- 무결성 제약조건(EDU.PLAYER_FK)이 위배되었습니다- 자식 레코드가 발견되었습니다
-- 연결되어 있어서 삭제가 안됨
-- 뒤에 옵션으로 CASECADE를 작성하면 추적하여 자식 테이블의 ROW도 같이 삭제해준다

--**** 공집합
--조회했는데 값이 없어 : 공집합
SELECT *
	FROM PLAYER p
	WHERE p.PLAYER_ID  = '2026002';

-- ROW가 있는데 값이 NULL => NULL 컬럼
SELECT p."POSITION"
	FROM PLAYER p
	WHERE p.PLAYER_ID  = '2026001';







