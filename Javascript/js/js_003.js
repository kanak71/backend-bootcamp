//전역변수
//선언되어 있는 javascript에서 모두 사용가능하다
//*** 유의사항 함수 내부의 선언명을 조심해야 한다

var variable = 10;

function global_variable(){
    console.log("전역변수")
    variable = variable+10;
    document.getElementById("v1").innerHTML = "<marquee>"+variable+"</marquee>";

    
}

function local_scope(){
    console.log("지역변수 scope");
    //전역변수 variable로 선언되어 있다
    //Q1. 함수에서 전역변수와 같은 이름으로 다시 정의한다면??
    //A1. 지역변수화 된다

    //*** undefinded 알 수 없음
    alert(variable);    //undifinded
    var variable = variable+99; //undifinded+99 => NaN(Not a Number)
    alert(variable);    //NaN(Not a Number)

    //전역변수이기 때문에 10이 출력되고 109 출력이 될 것 같다
    //하지만 javascrip의 scope는 먼저 선언되어 있던 후에 선언되어 있던 상관 없다
}

function local_variable(){
    //전역변수 선언된 variable의 변수 명이 있기 때문에
    //let 변수는 생성되거나 초기화 되지 않음
    //var는 재생성해서 내부 local로 undifinded가 된다
    let variable = variable+99;
    alert(variable);
    document.getElementById("v2").textContent = variable;

    /*
        HTML 문서에 값을 입력하는 방법
        1. form 요소 : ~value = 
        2. tag의 콘텐츠 요소 :  HTML인 경우는 innerHTML =
                                글자면 경우는 textContent = 
        
    */
}

function variableType(){
    var var02 = 5;//숫자
    var var03 = 3.14; //숫자

    var newVar = new Number(10);    //객체

    console.log(typeof var02, var02);   //number
    console.log(typeof var03, var03);   //실수 number
    console.log(typeof newVar, newVar);
    console.log(typeof newVar.toString(), newVar.toString());
    console.log(typeof newVar.valueOf(), newVar.valueOf());

    var var04 = '문자'; //문자 입력 "", '' 구분하지 않는다

    console.log(typeof var04, var04);

    var var05 = [1,2,3,'a']; //동적변수이기 때문에 입력되는 타입을 정하지 않는다
    console.log(typeof var05, var05);   //object
    console.log("길이:" , var05.length);
    console.log("index로 출력:", var05[3]);
    console.log("길이", var05.length);
    
    //Interator 총 3가지 방법
    //index for문
    //향상된 in, of 문법
    for(let i of var05){    //index없이 값을 바로 변수에 저장해서 사용
        console.log(i)
    }

    for(let i in var05){    //index를 통해서 출력
        console.log(i, var05[i])
    }

    //boolean : true, false 가능, 연산에서는 1, 0으로 변경이 되어 사용
    var var06 = false; //0과 1로 변경되어 연산 가능
    // ****** javascript 에서는 변수에 값이 있다면 true 판단

    /*
        var v = 10;
        if(v==10){} => x
        if(v){} 판단을 true로 한다
        *** === 완벽한 비교(값과 타입을 모두 비교할때 사용)
    */

    var tmp01;  //선언=> 판단이 되지 않음, undefinded
    var tmp02 = true;
    var tmp03 = "값";

    if(tmp01){
        console.log("판단");
    }

    if(tmp03){  //비교를 사용하지 않았지만 객체의 값이 있다면 true 판단
        console.log("판단");
    }

    console.log(var06 + true + 1);  //false(0) + true(1) + 1 =>2

    //--------------null과 undefided의 차이점
    //null은 탐색의 결과가 없다
    //undefinded는 미지의 값(알 수 없음)
    var var07 = null;
    console.log(typeof var07, var07);   //null도 object 판단
    console.log(var07+1);   //null연산의 경우 0으로 처리 된다
    console.log(var07 +'a') //



    var tmpUndefinded;  //
    console.log(typeof tmpUndefinded, tmpUndefinded);   //타입도 undefinded
    console.log(tmpUndefinded +1);  //NaN
    console.log(tmpUndefinded +'a');    //undifinded

    //javascript에서 타입은 총 6가지로 되어 있다
    //함수(메소드)도 변수의 값이 될 수 있다

    //익명함수 : 이름이 존재하지 않는 함수
    /* 
        만약에 val argument를 전달하지 않으면
        강제 초기화하기 때문에 전달하지 않으면 undefinded로 된다
    */
    var var08 = function (val){ 
                    alert(val + "님 안녕하세요");
                    return val;
    };
    var returnVal = var08("홍길동");    
    console.log(returnVal)

    /*
        1. 이름없는 함수는 익명함수
            함수도 변수의 값이 될 수 있다
            사용할때는 console.log()로 사용하지 마세요
                ㄴ var08() : 값인 함수가 실행된다  
                ㄴ var08 : 코드가 출력된다
    */

    //변수를 dom탐색과 같이 확인해보자

    /*
        객체 : Node, Element
            HTML Body의 tag를 DOM탐색하여 Element를 가져옴 => Object
            **** 탐색된 객체가 없다면 null
    */
    var dd = document.getElementById('v1'); //HTMLObject
    console.log(typeof dd); //화면에서 탐색된 결과는 객체(object)

    var dd_un = document.getElementById('v10');
    console.log(typeof dd_un, dd_un);


}

function alertGlobal(){
    console.log(window)
    //함수 내부에서 alert를 상위 변수화 되면 문제를 발생시킨다
    //재정의 하면 global함수가 오염된다
    alert("대화형 함수");
    var alert = "문자";
    // 해결방법 => 즉시 실행 함수로 동작시킨다
    console.log(window);
}