-- 정의
-- DML(Data Manipulation Language) : 데이터 조작 언어(조회, 입력, 수정, 삭제)
-- DDL(Data Definition Language) : 데이터 정의 언어(생성, 수정, 삭제, 이름변경)

-- DDL을 통한 테이블 생성
-- CREATE TABLE
-- ** 제약조건(Constraint)
--   NN(Not Null):필수입력컬럼, PK(Primary key), FK(Foreign Key), CHECK(if문), DEFAULT(기본)

-- Q. 회원정보 테이블을 만들보자
-- 이름, 전화번호, 권한, 등록일
--  1) 요청받은 컬럼중에서 식별자가 될 수 있는 컬럼을 선택, 없다면 코드성 컬럼을 추가(SEQ)
--     ** 식별자는 테이블에서 하나의 ROW(한줄)을 증명할 수 잇는 컬럼
--     값이 중복될 수 있기 때문에 하나의 ROW를 증명할 수 있는 컬럼을 추가 SEQ(Sequence - 앞으로만 증가)
--  2) 테이블명(USERINFO)과 컬럼명의 정의 SEQ, 이름(NAME), 전화번호(TEL), 권한(ROLE), 등록일(CREATEAT)
--  3) 제약조건 설정 SEQ(PK), 이름(NN), 전화번호, 권한, 등록일(NN)
--  4) 타입설정 SEQ(NUMBER), 이름(VARCHAR2), 전화번호(VARCHAR2), 권한(VARCHAR2), 등록(DATE)
--  SAMPLE DATA
--  1 | 홍길동 | 01012345566 | 반장 |   2026-03-12
--  2 | 또치   |            |      |  2026-03-12


CREATE TABLE USERINFO(
	SEQ NUMBER PRIMARY KEY, -- 컬럼선언과 같이 제약조건을 작성하는 "COLUMN 정의 방식"
	NAME VARCHAR2(20) NOT NULL,
	TEL VARCHAR2(20),
	ROLE VARCHAR2(10),
	CREATEAY DATE NOT NULL
);

CREATE TABLE USERINFO(
	SEQ NUMBER , 
	NAME VARCHAR2(20) NOT NULL,
	TEL VARCHAR2(20),
	ROLE VARCHAR2(10),
	CREATEAY DATE NOT NULL,
	CONSTRAINT INFO_PK PRIMARY KEY (SEQ) -- TABLE정의 방식
);

CREATE TABLE USERINFO(
	SEQ NUMBER , 
	NAME VARCHAR2(20) NOT NULL,
	TEL VARCHAR2(20),
	ROLE VARCHAR2(10),
	CREATEAY DATE NOT NULL
);
-- DDL ALTER 명령어를 통해서 테이블에 제약조건을 작성 방법 : 추천, 설정 상세로 할 수 있다. 이행스크립트 처리가 편다
ALTER TABLE USERINFO ADD CONSTRAINT INFO_PK PRIMARY KEY (SEQ);

-- 테이블의 삭제
DROP TABLE USERINFO; -- CASCADE 연관된 모든 컬럼을 제거하겠다. 


-- 2) Sequnce 테이블 생성(**주의 다른 RDBMS는 사용 여부를 확인)
--  숫자만 자동으로 증가되는 값을 가지고 있는 테이블
--  사용방법
--   - 테이블.NEXTVAL : 다음 숫자를 반환
--   - 테이블.CURRVAL : 현재 숫자를 반환
--   - CURRVAL은 NEXTVAL을 실행시켜서 SESSION이 생성되어 있지 않으면 사용하지 못함

CREATE SEQUENCE USERINFO_SEQ START WITH 1 INCREMENT BY 1;


-- DUAL : 문법을 맞추기 위한 가상테이블
SELECT USERINFO_SEQ.CURRVAL
	FROM DUAL;

SELECT USERINFO_SEQ.NEXTVAL
	FROM DUAL;


-- 3) CONSTRAINT 제약조건 PK, FK 생성방법
-- 조건 : CONSTRAINT에서 P, FK는 사용하기 위해서 반드시 테이블이 생성되어 있어야 한다
--       DEFAULT , CHECK TABLE을 생성할때 작성하는게 편하다 : 데이터에의 문제 
-- 결론 : 데이터가 있을때는 왠만하면 하지 마세요

-- PK 생성 문법
--  ALTER TABLE 테이블명
--      ADD CONTSTRAINT 제약조건명 PRIMARY KEY (컬럼);

-- FK 생성 문법 : 자식 테이블에서만 만듬
-- ALTER TABLE 테이블명
--      ADD CONSTRAINT 제약조건면 FOREIGN KEY (내컬럼)
--      REFERENCES 부모테이블명 (부모컬럼명);
 

CREATE TABLE USERINFO(
	SEQ NUMBER , 
	NAME VARCHAR2(20) NOT NULL,
	TEL VARCHAR2(20),
	ROLE VARCHAR2(10),
	CREATEAT DATE NOT NULL
);
-- DDL ALTER 명령어를 통해서 테이블에 제약조건을 작성 방법 : 추천, 설정 상세로 할 수 있다. 이행스크립트 처리가 편다
ALTER TABLE USERINFO ADD CONSTRAINT INFO_PK PRIMARY KEY (SEQ);

--Q. USERINFO 테이블 자식으로 사용하고, 대학정보 테이블 만들어 FK로 연결하도록 해보겠다
-- 부모테이블 만들기
CREATE TABLE UNIV(
	ID CHAR(3),
	UNIV_TYPE VARCHAR2(20) NOT NULL,
	WEBSITE VARCHAR2(200)
);

-- UNIV PK 설정
ALTER TABLE UNIV ADD CONSTRAINT UNIV_PK PRIMARY KEY (ID);

-- 부모와 자식관계를 위해서 자식테이블 FK를 작성
-- USERINFO에 UNIV의 ID와 연결되는 FK 컬럼을 추가 한다
ALTER TABLE USERINFO ADD UNIV_ID CHAR(3);


-- USERINFO(자식-UNIV_ID) 과 UNIV(부모-ID) FK 연결
ALTER TABLE USERINFO 
	ADD CONSTRAINT USERINFO_FK
	FOREIGN KEY (UNIV_ID)
	REFERENCES UNIV (ID);

-- CONSTRAINT (제약조건)
-- PK, FK, DEFAULT, CHECK, NN, UNIQUE
ALTER TABLE USERINFO MODIFY (ROLE DEFAULT 'U');






















