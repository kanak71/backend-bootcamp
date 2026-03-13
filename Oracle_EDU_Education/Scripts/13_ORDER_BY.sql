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
