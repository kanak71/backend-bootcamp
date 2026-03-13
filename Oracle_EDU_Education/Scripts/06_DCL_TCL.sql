-- TCL(Tracsaction Controller Lagnuage)
-- 키워드 : ROLLBACK, COMMIT
-- ALL or Nothing(모두 commit, 모두 rollback)
-- ACID(Atomic, Consistance, Isolation, Durability)

-- 주의사항 : 
-- Transaction은 해당 사용자가 접속해 있는 환경에서는 확인하기 어렵다(Cache)
-- Transaction은 DML의 select와는 상관없다. insert delete update row를 처리 할 때 발생한다

SELECT *
	FROM USERINFO u;

DELETE FROM USERINFO;

ROLLBACK;
DELETE FROM USERINFO
	WHERE SEQ = '22';

COMMIT;

--SAVEPOINT
--여러개의 작업이 있다면, 하나로 처리하는 것이 아니라, 각 작업에 SAVEPOINT 위치값을 넣어서 일부분을 ROLLBACK 처리
SAVEPOINT SVP1;

INSERT INTO PLAYER(PLAYER_ID, PLAYER_NAME, TEAM_ID) VALUES (’2026002’,’전민균’,’K01’);

SAVEPOINT SVP2;

UPDATE PLAYER SET PLAYER_NAME =’디딤돌’ WHERE PLAYER_ID =’2026002’;

SAVEPOINT SVP3;

DELETE FROM PLAYER;

