// inner function : 내부 함수
// 즉시 실행 함수
// javascript 동적바인딩(동적할당) javascript 타입 Object(Array, function)
// 즉시 실행함수는 global 영역을 사용하지 않는다

/*
    *** 호이스팅 이란?
        선언된 함수 혹은 변수의 수행이 작성된 하위라도 먼저 실행
         ㄴ 선언메모리 : 선언보다 메모리의 공간은 먼저 할당
*/

(
    function(){
        onAdd();
        onMinus(10, 4);

        function onAdd(){
            var x = 10, y = 20, result = 0;
            result = x+y;
            console.log(`${x} + ${y} = ${result}`);
        }

        function onMinus(x, y){
            var result = x-y;
            return (`${x} - ${y} = ${result}`);
        }

        function onMulti(x,y){
            var result = x*y;
            return (`${x} * ${y} = ${result}`);
        }

        //함수 리터럴 : 함수를 값으로 가지고 있는 변수
        var onDiv = function(x, y){
            var result = x/y;
            return (`${x} / ${y} = ${result}`)
        }

        var result = onMulti;   //onMulti는 일반 선언 방식이지만 값을 입력하여 함수 리터럴로도 사용이 가능하다
        console.log(result);    //function의 코드가 출력된다
        console.log(result(10,4))   //실행된 결과를 춭력한다

        var result = onDiv(10,3);
        console.log(result);


    }
)();