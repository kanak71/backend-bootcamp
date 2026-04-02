//javascript 변수 선언 방법
// *** javascript 변수의 선언은 var global 변수 => 호이스팅

var a = 10;
console.log("a->", a);
//사용하는 방법 터미널 -> node 파일명.js

//1) javascript에서는 같은 변수명으로 하위에 재선언해도 오류가 발생하지 않는다
var a = '200';
console.log("a->", a,typeof a);

//2) ESMAScript 2015 (ES6) 버전 이상에서만 지원하는 함수
// let, const
// let 지역변수 선언 및 재입력은 가능하고 재선언은 되지 않는다

let b = 'Human';
console.log("b -> ", b);
b = "Robot";
console.log("b -> ", b);
b = 77; //javascript는 동적할당
console.log("b -> ", b);
// 재선언 안된다
//let b ='7';   => 오류
//var b = 1;  //한번 선언된 변수이기 때문에 var타입으로도 선언이 되지 않는다

//let를 사용하는 이유
//** 1) let 변수를 사용하여 global 영역을 오염시키지 않는다
//** 2) 변수의 범위를 제한할 수 있다
let alert = "Morning";
console.log(`\n alert -> ${alert}, typeof(alert) -> ${typeof alert}`);

//window 브라우저의 객체
//console.log(window);

//const 상수를 정의 할 때 사용한다
//상수로 정의되어 있기 때문에 재입력 및 재선언이 불가능하다
const CONST_VAL = 33.12;
console.log(`CONST_VAL -> ${CONST_VAL}, typeof(CONST_VAL) -> &{typeof CONST_VAL}`);
//CONST_VAL = 4; //Assignment to constant variable.
//const CONST_VAL_2;  //SyntaxError
