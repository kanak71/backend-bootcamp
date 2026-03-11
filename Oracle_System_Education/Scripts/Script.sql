-- DDL 명령어
-- ALTER (존재하는 테이블 수정), CREATE(생성), GRANT(권한부여), REVOKE(권한제거)

--컨트롤 엔터 : 실행

-- 계정의 비밀번호를 유호시간을 무한설정
ALTER PROFILE DEFAULT LIMIT PASSWORD_LIFE_TIME UNLIMITED;

-- 1. 사용자 계정 생성
-- 계정명, 비밀번호, 권한, **테이블스페이스

-- 1) 사용자 조회(DML - SELECT)
-- 명령어 컬럼 FROM 조회테이블
SELECT USERNAME FROM DBA_USERS;

-- 2) 테이블스페이스(물리적인 데이터가 저장되는 곳 - DBF파일)
--* (와일드카드 - 모든것)

SELECT FILE_NAME, TABLESPACE_NAME
	FROM DBA_DATA_FILES;

-- *** 12C 버전 이상부터는 계정을 생성할 때 일반 계정과 관리자 계정을 구분하기 위한 SUFFIX를 사용한 ## ex)DEV##
ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;

-- 3) 계정 생성
CREATE USER EDU IDENTIFIED BY EDU;
SELECT USERNAME FROM DBA_USERS; 

-- 4) 계정은 만들었지만 계정이 하는 역할 없다. 역할 부여 GRANT 역할 부여함
--	ROLE : 
--	권한 : 테이블 만들 수 있어(CREATE TABLE), 테이블 삭제 할 수 있어(DELETE TABLE) ...
GRANT DBA, RESOURCE, CONNECT TO EDU;

-- 5) 계정 만들었고, 계정에 권한도 줬고
--	ADMIN이라면 사용되는 물리적인(DBF) 테이블스페이스 선택해줘야한다
--	계정이 해당 테이블(데이터를 쓰는 곳)을 사용할 수 있도록 해줘야 QUOTA
--수정 EDU라는 계정의 | 기본 저장하는 물리적인 곳은 | USERS 이고 | USERS 공간을 최대로 사용할 수 있도록 설정

ALTER USER EDU DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;

SELECT *
	FROM DBA_USERS
	WHERE USERNAME = 'EDU';



