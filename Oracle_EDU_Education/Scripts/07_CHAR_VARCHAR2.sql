-- CHAR : 고정 길이 문자열
-- VARCHAR2 : 가변 길이 문자열
-- 정리 : 문자열을 사용할 때(저장될때), 공간을 고정 혹은 가변으로 만들거냐 차이점
-- 결론: 값이 고정(GENDER F:M, 삭제여부 Y:N) CHAR
-- 		계속 변하는 값(제목, 내용, 이메일, 전화번호..) VARCHAR2

-- ORACLE : VARCHAR2 / MYSQL... : VARCHAR
-- 주의점 : VARCHAR에서는 문자가 길어질수록 가까운곳에 저장이 되지 않기 때문에 오래 사용하다 보면 튜닝을 해줘야한다
--		세그먼트 발생이 된다

CREATE TABLE STRING(
	NAMEC CHAR(10),
	NAMEV VARCHAR2(10)
);

INSERT INTO STRING VALUES('ABC', 'ABC');	-- 10자리 : 3자리
INSERT INTO STRING VALUES('1234567890', '1234567890');	-- 10자리 : 10자리
INSERT INTO STRING VALUES('123456789', '123456789');	-- 10자리 : 9자리

-- 정리 : CHAR는 크기가 고정되어 있기 때문에 길이가 무조건 크기의 값을 가진다
-- 결론 : CHAR는 고정값을 사용하는 컬럼에서 사용해 주세요


SELECT LENGTH(NAMEC), s.NAMEC C, LENGTH(NAMEV), NAMEV
	FROM STRING s;

-- 결론 : CHAR와 VARCHAR2는  비교 불가능하다 - 길이때문에
-- 출력 : CHAR의 전체 크기와 VARCHARS의 전체크기가 같은 값만을 출력해준다
SELECT *
	FROM STRING s
	WHERE s.NAMEC = s.NAMEV;

-- 해결 방법 : VARCAHR2를 CHAR의 공간만큼 채워서 비교하면 된다
-- Q.123456789 : 9자리
-- 		CHAR 10자리 : 9자리
--		VARCHAR 9자리 : 9자리
SELECT *
	FROM STRING s
	WHERE s.NAMEC = s.NAMEV || ' '; 


-- 추가사항 : CHAR는 숫자, 특수문자, 한글, 영문 => 차지하는 크기가 틀리다
INSERT INTO STRING VALUES('가나다','가나다');
INSERT INTO STRING VALUES('ABCDE', 'ABCDE');

SELECT s.NAMEC 값,
		LENGTH(s.NAMEC), --CHAR 숫자,영문 입력된 경우 크기 출력, 한글은 계산 어렵다
		LENGTH(s.NAMEC),	 --CHAR BYTE 길이 공간을 출력해 준다
		LENGTH(s.NAMEV)
	FROM STRING s;

-- 예시 : 설계중에 회원정보를 입력 NAME 컬럼(한글,영문) - 제갈공명 *3 크기를 최소 12이상을 해야한다
-- VARCHAR2 최대 크기 32000byte
-- 이력서 쓰면 왜 4000자 크기일까? VARCHAR2 입력 될 수 있는 크기는 4000자








