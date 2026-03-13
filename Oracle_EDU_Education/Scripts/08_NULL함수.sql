-- NULL 함수
-- 정의 : NULL의 미지의 값
-- 결론 : NULL을 연산하면 NULL 이다(SELECT)
-- 		 NULL을 비교하면 FALSE로 반환된다(WHERE)
-- 추가 : **** NULL(깂)과 공집합(어떠한 결과도 없는 것)은 다르다

SELECT *
	FROM PLAYER p
	WHERE p.PLAYER_ID ='1111';	--공집합입니다
	
--NULL 값이 : 컬럼의 값
-- ''는 NULL
SELECT *
	FROM EMP e
	WHERE COMM IS NULL;

--NULL 처리를 위한 함수
-- 1) NVL : NULL로 되어 있는 컬럼의 값을 치환하여 반환하게 된다
--		주의점 : 컬럼의 타입과 같은 타입을 작성 --> CASE WHEN THEM ELSE END 문법을 사용
-- 2) NULLIF : 두개의 컬럼의 값이 같으면 NULL을 반환
-- 3) COALESCE : 컬럼중에 NULL이 아닌 최초의 값이 있을 때 최초의 값을 출력한다
--				NULL | 'A' | 'B' -> 'A'
--				NULL | NULL| 'C' -> 'C'

-- Q. 모든 사원 보너스(COMM)의 평균(AVG)을 조회
-- 결론 : 수치의 계산에서 NULL의 값은 대상이 되지 않는다. 금액에서의 NULL은 통상적으로 0을 의미한다 
SELECT AVG(COMM) "평균 보너스 금액"	--550 : 잘못된 통계다 
	FROM EMP;

SELECT AVG(NVL(COMM,0))
	FROM EMP;

--정리
SELECT COMM, NVL(COMM,0) "NVL치환",
--		NVL(COMM,0) --COMM값이 있는 셀의 타입은 NUMBER, 치환되는 값은 CHAR이다 따라서 출력되지 않는다
		-- 자동형변환 : RDBMS값이 자동으로 형변환
		NVL(COMM,'1'), NVL(COMM,1), --DB에서의 값은 무조건 ''로 작성
		NVL(COMM, '00001')
	FROM EMP;
--	WHERE COMM = NULL;	--NULL의 비교는 모두 FALSE

--**추가사항(공집합)
SELECT NVL(COMM, 10)
	FROM EMP e
	WHERE e.EMPNO ='11' --없는값
	

--2) NULLIF 같은 값이면 NULL
--	사용 : 값 변경할 때, 홍길동(guest 아이디) -> 출력 GUEST
-- Q. DEPT 정보중에서 DNAME이 SALES라면 NULL로 변환해서 출력해 주세요, '판매업무'
	
SELECT d.DEPTNO , d.DNAME ,
	NVL(NULLIF(d.DNAME,'SALES'), '판매업무')
	FROM DEPT d;

-- 질문 :
--	SELECT 절은 무엇인가요? FROM절에 가지고 있는 값을 조회 하는 것, 컬럼작성 여러번 가능
--						제약조건... 와는 전혀 상관 없다
SELECT NULLIF(e.DEPTNO, 20)PK, e.*	--실수에서 사용하지 말기
	FROM EMP e;
	
-- 3) COALESCE : NULL이 아닌 최초의 값
-- 주의점 : 같은 타입의 컬럼이여야 한다
-- 사용 : 웹사이트 - 가입된 회원, 로그인 API(NAVER, GOOGLE)
SELECT e.*, COALESCE(COMM, MGR, SAL) 선택,
	COALESCE(COMM, MGR, SAL) 선택2	--COMM과 MGR은 NUMBER이다. 하지만 JOB은 문자이다
	FROM EMP e; 



	
	
	
	
	
	