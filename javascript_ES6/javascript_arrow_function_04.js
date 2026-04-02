// 화살표 함수(Arrow Function) : ES6에서만 가능
// 장점 : 화살표 함수 표현식은 기본 function 작성 방법보다 구문이 짧다
// 단점 : this, arguments, new.target을 바인딩하지 못한다

/*
    화살표 함수는 항상 "익명함수"
                간단함수를 변환할 수 있다
                생성자 사용이 불가능하다

    (param1, param2) => 문법
    (param1, param2) => 표현식

    parameter가 하나인 경우 () 선택사항
    (param1) => {}
    param1 => {}
    ()=>{}

*/

(
    function(){
        //기존방식의 function 작성방법
        function onAdd(){
            var x = 10, y = 20, result = 0;
            result = x+y;
            console.log(`${x} + ${y} = ${result}`);
        }

        // 1) Parameter가 없는 화살표 함수
        var onAdd = () => {
            var x = 10, y = 20, result = 0;
            result = x+y;
            console.log(`${x} + ${y} = ${result}`);
        }

        //2) parameter 두개 이상인 경우
        var onMinus = (x, y) =>{
            var result = x-y;
            console.log(`${x} - ${y} = ${result}`);
        }

        //3) parameter가 한 개 있는 경우
        //  없다면 반드시 ()
        //  한개만 있다면 () 선택

        var onSample1 = x =>{return `${x} * 10 = ${x*10}`};
        var onSample1 = (x) =>{return `${x} * 10 = ${x*10}`};

        //4) {} block은 자동리턴이기 때문에 return을 사용하지 않아도 된다
        var onSample2 = x =>`${x} * 10 = ${x*10}`;

        //5) {} 어디에 쓰나요? 실행구문이 두개 이상일 때 사용
        var onDiv = (x, y) =>{
                                var result = x-y;
                                console.log(`${x} - ${y} = ${result}`);
                            }
    }
)();