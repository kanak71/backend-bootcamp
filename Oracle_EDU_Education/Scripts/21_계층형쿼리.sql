-- 계층형쿼리
-- 계층형 쿼리의 결과는 셀프조인이 여러번 진행된 결과와 같다
-- 테이블에 같은 값을 사용하는 컬럼이 있어야 한다

-- 분석 : 사원테이블(EMP)
--		사원은 사원번호를 가지고 있다(EMPNO), 각 사원의 관리자도 사원이다 따라서 사원번호를 가지고 있다(MGR)

SELECT e.EMPNO 사원번호, e.ENAME 사원이름,
	e.MGR "관리자번호(사원번호)", e.ENAME "관리자이름"
	FROM EMP e JOIN EMP e2
	ON e.MGR = e2.EMPNO;


CREATE TABLE EMPLOYESS(
	EMP VARCHAR(1),
	MGR VARCHAR(1)
	);

INSERT INTO EMPLOYESS VALUES('A',NULL);
INSERT INTO EMPLOYESS VALUES('B','A');
INSERT INTO EMPLOYESS VALUES('C','A');
INSERT INTO EMPLOYESS VALUES('D','C');
INSERT INTO EMPLOYESS VALUES('E','C');

SELECT *
	FROM EMPLOYESS e ;

-- 샘플의 계층 구조
--A
-- ㄴB
-- ㄴC
--   ㄴ D
--   ㄴ E

-- 정리 : 순차진행 - A부터 하위로 진행
--		 역차진행 - 특정값(D) -> C -> A 상위로 진행
-- ***** 키워드
-- LEVEL, CONNECT BY, PRIOR, START WITH
-- CONNECT_BY_ISLEAF(1 자식이 없다), SYS_CONNECT_BY_PATH(현재 위치를 추적 A>C>D), SYS_CONNECT_BY_ROOT(최상위 A)

SELECT e.EMP, e.MGR,
	LEVEL 계층, CONNECT_BY_ISLEAF, -- 0이면 하위(자식)가 있다, 1이면 없다(마지막 NODE이다)
	LPAD(' ', 10*(LEVEL-1)) || EMP
	FROM EMPLOYESS e
	START WITH MGR IS NULL	--시작하는 값 순차 MGR이 NULL인 값이 NULL : 내 위에 관리자가 없음으로 최상위
--	CONNECT BY MGR = PRIOR EMP; -- CONNECT BY 시작 값 : MGR(NULL) -> A를 다시 MGR로 사용하겠다
	CONNECT BY PRIOR EMP = MGR ;	--MGR(NULL) -> A -> MGR(A) -> B -> MGR(B) 값이 없다
--																  C -> MGR(C) -> D
--																				 E
	
	
SELECT e.EMP, e.MGR,
	LEVEL 계층, CONNECT_BY_ISLEAF,
	LPAD(' ', 10*(LEVEL-1)) || EMP
	FROM EMPLOYESS e
	CONNECT BY EMP = PRIOR MGR 
	START WITH MGR = 'C';	-- MGR이 C인 EMP는 두명이다 / START WITH 순서 상관 없어
	
-- *** 주의점
-- START WITH ~ CONNECT BY 절뒤에 WHERE이 올 수 없다. WHERE은 반드시 FROM절 뒤에 와야 한다
-- START WITH는 단독으로 사용이 불가능하다
-- CONNECT BY는 단독으로 사용이 가능하다
-- 예> 
SELECT LEVEL
	FROM DUAL
	CONNECT BY LEVEL <= 10;
--CONNECT BY START WITH를 기준으로 앞/뒤 어느곳이든 올 수 있다
--PRIOR(값이 재입력 되는 곳) CONNECT BY EMP = PRIOR MGR 컬럼 앞에 위치하여 해당 컬럼이 다시 시작점이 될 수 있도록 한다

--용어정리
--LEVEL : 순차/역차에서 DEPTH(깊이)를 나타냄 1(최상위)부터 시작
--CONNECT_BY_ISLEAF : 마지막 NODE를 1로, 자식 NODE가 있다면 0이다
--CONNECT_BY_ROOT : 최상단 값
--SYS_CONNECT_BY_PATH(컬럼, '>') 예] A>B>C 현재까지의 상위값을 누적하여 보여줌
--START WITH : 선택 ROW의 컬럼값(시작값)
--CONNECT BY : 전개방식 A->B 이동 PRIOR(MGR) = EMP
--PRIOR : 값이 다시 시작되는 점
--		EX) 순차 : MGR = PRIOR(EMP)
--			설명 : 처음에 START WITH에 MGR IS NULL 인 값의 EMP값을 찾는다 => MGR로 사용한다
--			분석 : MGR이 NULL 것의 EMP A 이다
--					ㄴMGR이 A인 것의 EMP B와 C이다
--						ㄴMGR이 B는 없다
--						ㄴMGR이 C인 EMP D와 F다
--							ㄴMGR이 D는 없다
--							ㄴMGR이 E는 없다

-- Q. 사원테이블 EMPMO와 MGR의 관계 도식
/*KING (7839)
├─ JONES (7566)
│  ├─ SCOTT (7788)
│  │  └─ ADAMS (7876)
│  └─ FORD (7902)
│     └─ SMITH (7369)
│
├─ BLAKE (7698)
│  ├─ ALLEN (7499)
│  ├─ WARD (7521)
│  ├─ MARTIN (7654)
│  ├─ TURNER (7844)
│  └─ JAMES (7900)
│
└─ CLARK (7782)
   └─ MILLER (7934)*/

--MGR이 NULL인 사원의 정보부터 하위 사원들의 순차계층을 출력
--PRIOR EMPNO = MGR
-- 부모의 EMPNO = 자식의 MGR
-- 부모 -> 자식
-- 7566 -> (MGR이 7566인 직원)
SELECT LEVEL 계층, EMPNO, ENAME,
	CONNECT_BY_ISLEAF 마지막노드확인,
	CONNECT_BY_ROOT(ENAME) 부모노드확인,
	SYS_CONNECT_BY_PATH(EMPNO,'->')
	FROM EMP e
	START WITH MGR IS NULL
	CONNECT BY PRIOR EMPNO = MGR;

-- 역차
-- 7900인 사원의 정보를 역차계층으로 출력해주세요
SELECT LEVEL 계층, EMPNO, ENAME,
	CONNECT_BY_ISLEAF 마지막노드확인,
	CONNECT_BY_ROOT(ENAME) 부모노드확인,
	SYS_CONNECT_BY_PATH(EMPNO,'->')
	FROM EMP e
	START WITH EMPNO = 7900
	CONNECT BY EMPNO = PRIOR MGR;













