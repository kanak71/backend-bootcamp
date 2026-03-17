-- WINDOW FUNCTIONO 이란?
/*
* SELECT절에서 필요한 추가연산 함수로 만들어 사용
* ***WINDOWING 절 ***
* WINDOW FUNCION의 문법
*  1) FUNCTION() OVER()
*  2) FUNCTION() OVER([PARTITION BY 컬럼명] [ORDER BY 컬럼] [WINDOWING 절 - ORDER BY가 있을경우만])
* 		ㄴ GROUP BY를 할 경우에는 해당 참여하는 컬럼만 SELECT절에서 사용 가능하다
* 		ㄴ SELECT절에서 WINDOW FUNCTION을 통해서 다시 GROUP BY 혹은 ORDER BY를 할 수 있도록 지원한다
* 
* - PARTITION BY : SELECT절에서 묶음을 만들어 냄
* - ORDER BY : SELECT절에서 컬럼의 결과를 정렬**(현재부터, 범위의 ROW - 1칸앞, 2칸앞뒤)
* - WINDOWING 절 : 현재 ROW부터, 범위 ROW 등의 범위를 지정한다
* 
*/

/*
* WINDOWING 절!
*  범위(BETWEEN), 없거나
*  값의 범위, ROW의 범위
*  - 문법
*  ROWS(ROW기준) | RANGE(값) BETWEEN    UNBOUNDED PECEDING : 현재 선택된 ROW|RANGE를 기준으로 이전 끝까지
* 									  CURRENT ROW : 현재 선택된 ROW
* 						    AND
* 									  FOLLOWING : 현재 선택된 ROW를 기준으로 뒤쪽 
* 	ex) ROWS UNBOUNDED PRECEDING : 현재 선택된 ROW를 기준으로 앞으로 끝
* 		ROWS BETWEEN 1 PRECEDING AND 2 FOLLOWING : 현재를 기준으로 앞으로 한칸 뒤로 2칸
* 
*/

-- 순위 함수
-- Q. 급여에 따른 순위를 표기
-- RANK : 같은 값은 같은 순위, 다음값 +N을 통해서 번호를 부여 
-- DENSE_RANK : 같은 값이면 같은 순위, 다음값을 번호 부여
-- ROW_NUMBER : ORDER BY된 순서대로 번호를 부여
SELECT SAL, 
	RANK() OVER(ORDER BY SAL DESC) RANK,	-- 결과의 표기를 건너 뛴다
	DENSE_RANK() OVER(ORDER BY SAL DESC) DENSERANK,	-- 같은 값을 가지고 있다면 묶음으로 표시
	ROW_NUMBER() OVER(ORDER BY SAL DESC) ROWNUMBER -- 순위에 의미 없이 ROW에 순차적으로 1부터 작성
	FROM EMP e;

/*
 * RANK() OVER() 는 건너 뛴다 : 같은 결과가 있는 다음은 해당결과는 다음값
 * 예) 10:1, 10:1, 10:1, 9:4
 * 
 * DENSE_RANK() OVER() : 묶음으로 계산된다
 * 예) 10:1, 10:1, 10:1, 9:2
 * 
 * ROW_NUMBER() OVER() : ROW를 번호를 차례대로 1부터 출력한다
 * 예) 10:1, 10:2, 10:3, 9:4
 */






