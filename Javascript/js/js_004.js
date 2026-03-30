// 1. 명시적 함수는 함수의 이름을 가지고 있는 함수
function function01(){
    console.log("명시적 함수 : function 함수명(){}");

}

// 2. 익명 함수 : 함수인데 이름을 가지지 않고 변수의 값으로 담겨 있는 함수
//  함수를 리터럴을 argument로 사용하는 함수나, 함수의 기능을 제거하기 위해서 사용하는 함수
var function02 = function(){
    console.log("익명 함수 : var 변수명 = function(){};")
};

// 3. 함수 리터럴(값, 컴퓨터 번역되지 않고 입력되는 값)
//  ㄴ 변수에 담겨 있는 function이 아닌 값의 역할인 function

function literalFn(literal){
    literal("회사에 지원하는 이력서")
}

function function03(){
    literalFn(function(mgs){alert(msg)})
}

function pPrint(){
    var obj = document.getElementsByTagName("p");
    console.log("검색된 p tag의 개수 : ", obj.length);

    for(let i = 0; i<obj.length; i++){
        console.log(obj[i].innerHTML);
    }

    for(let i in obj){
        console.log(obj[i].textContent, obj[i].tagName);
    }

    for(let v of obj){
        console.log(v)
    }
}


//------------------------------------------------
//1) 화면에 출력한 시분초를 만들어 내는 함수
var updateClock = function(){
    const now = new Date();

    //시분초 만들기
    const hour = now.getHours();

    const minute = now.getMinutes();
    const second = now.getSeconds();

    const timeString = `${String(hour).padStart(2,'0')} : ${String(minute).padStart(2,'0')} : ${String(second).padStart(2,'0')}`;

    //시계를 화면 영역에 출력
    document.getElementById("clock").textContent = timeString;
}

var clockInterval;

function startClock(){
    clockInterval = setInterval(updateClock, 1000);
}

function stopClock(){
    clearInterval(clockInterval);
}

//-----------------------------------------------
/*
    함수 리터럴 : 함수도 값이 될 수 있다
    콜백(call-back) 함수란?
     클로저 함수(closure function)
        - 콜함수는 특정 함수의 arguments 부분으로 함수고 받는 이야기 한다
          외부에서 선언된 변수를 내부에서 활용, 내부 함수 부분을 클로저 함수

*/

function closureFn(val){
    function addVal(msg){
        alert(val + ":" + msg);
    }
    return addVal;
}

var amEdu = closureFn("HTML");
var pmEdu = closureFn("javascript")

function closureTest(){
    var fn = closureFn("JS")("HTML");
    console.log(fn);
}