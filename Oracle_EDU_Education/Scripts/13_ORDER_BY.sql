-- ORDER BY 절
-- 정의 : SQL의 SELECT절 결과를 정렬(ASC, DESC) 때 사용

-- SELECT 절			SELECT *
-- FROM 절			FROM PLAYER p
-- WHERE 절			WHERE P.PLAYER_NAME  IS NOT NULL
-- GROUP BY 절		GROUP BY p.TEAM_ID 
-- ORDER BY 절		ORDER BY 1;

--*** SQL문의 실행순서
-- FROM절 -> WHER절 -> GROUP절 -> SELECT절 -> ORDER BY절
-- ROWNUM이 FROM절에서 정리하지 않으면 순서를 원하는 형태(ASC,DESC)으로 처리 불가능

--작성방법 : 컬럼명, SELECT절의 순서(INDEX), SELECT절의 ALIAS => 혼합도 가능
SELECT P.PLAYER_ID 아이디, P.PLAYER_NAME 이름 , P.BACK_NO 등번호
	FROM PLAYER p
--	ORDER BY 1,2,3;	--기본 ASC, NULL이 가낭 높은 값
	ORDER BY 3,2,1;

 --Q. PLAYER_ID, PLAYER_NAME. BACK_NO를 조회 오름차순으로 정렬
-- 기본졍랼 ASC
SELECT PLAYER_ID, PLAYER_NAME, BACK_NO 등번호
	FROM PLAYER p	--INSERT된 순서이거나, RDBMS가 가장 빠른 출력으로 만들어준다
--	ORDER BY 1,2,3;
--	ORDER BY PLAYER_ID, PLAYER_NAME, BACK_NO
	ORDER BY PLAYER_ID, 2, 등번호;
	
 -- **** ORDER BY 집계함수
 SELECT ENAME, LENGTHB(ENAME) "이름의 길이"
 	FROM EMP e
 	ORDER BY "이름의 길이";
 
 --Q. 선수들 중에서 각 팀별 가장 키가 큰 선수들의 키를 알고 싶다
 SELECT p.TEAM_ID, MAX(HEIGHT)
 	FROM PLAYER p
 	GROUP BY p.TEAM_ID
 	ORDER BY 2 DESC;