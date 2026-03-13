-- OUTER JOIN
-- 선행/후행 테이블
-- 선행 혹은 후행 테이블을 기준으로 JOIN 하는 방법

--Q. STADIUM에 등록된 운동장 중에서 홈팀에 없는 경기장이 있다
--	 STADIUM과 TEAM을 JOIN할 때 홈이 없는 경기장의 정보도 보고싶다

SELECT *
	FROM STADIUM s --20개의 경기장
	
SELECT *
	FROM STADIUM s JOIN TEAM t
	ON s.HOMETEAM_ID = t.TEAM_ID;	--15개 경기장만 보인다 ?? 5개는 뭐지? 구단이 없는 경기장
	
SELECT *
	FROM STADIUM s LEFT JOIN TEAM t
	ON s.HOMETEAM_ID = t.TEAM_ID;
	
-- 정의 : FROM절 조인으로는 어떻게 표현할까
SELECT *
	FROM STADIUM s ,TEAM t
	WHERE S.HOMETEAM_ID = T.TEAM_ID (+);


---------------------------------------------------------------
SELECT *
	FROM STADIUM s RIGHT JOIN TEAM t	--TEAM의 갯수 15개
	ON s.HOMETEAM_ID = t.TEAM_ID;
--위와같다
SELECT *
	FROM STADIUM s ,TEAM t
	WHERE S.HOMETEAM_ID(+) = T.TEAM_ID;
	
---

SELECT *
	FROM STADIUM s FULL JOIN TEAM t	--ORACLE에만 있음
	ON s.HOMETEAM_ID = t.TEAM_ID;	--양쪽 모두 테이블의 ROW를 유지한채 출력

SELECT *
	FROM STADIUM s ,TEAM t
	WHERE S.HOMETEAM_ID(+) = T.TEAM_ID(+);	--이런건 없다
	
	
	
	
	
	

