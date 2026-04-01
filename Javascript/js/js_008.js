function numberFeature(){

    var tmp = 'a';
    var tmpNum = Number(tmp);
    var tmpNumber = new Number(tmp);
    console.log(tmp, tmpNum, tmpNumber);

    //작성방법
    var num1 = new Number(7);   //객체 선언방법
    var num2 = 7; //리터럴 선언방법, 기본적으로 자바스크립트는 객체이다

    console.log(num1.valueOf);
    console.log(num2.valueOf);

    //비교
    //객체로 선언된 Number의 리터럴 값은 같으나 타입이 다르다
    // ==> javascript에서 완벽한 비교를 통해서 객체를 판별해 줘야 한다

    console.log(typeof num1);
    console.log(typeof num2);

    //== : 값을 변환하여 비교
    //=== : 완벽한 비교, 값 뿐만 아니라 타입도 비교한다
    console.log(num1 === num2); //false

    //Number의 객체의 함수중에서 toString() : 문자열, valueOf() : 숫자 를 통해서 값을 추출
    console.log(num1.valueOf() === num2); //true valueOf를 통해서 리터럴을 비교한다
    console.log(num1.toString() === num2);    //false toString을 통해서 string비교 number비교
    console.log(num1 == num2);  //true

    //NaN(Not a Number) : 숫자가 아닌 문자열 숫자인지 판별해 주는 중
    console.log("속성 NaN : " + parseInt('a'));
    if(isNaN(parseInt('a'))) {
        console.log("숫자로 변환할 수 없는 값");
    }


    //Number 객체의 함수
    //toFixed() : 자리수 반올림
    //toString() : 문자열로 출력

    var d = 3.15151515;
    var fix = d.toFixed(3); //argument는 보여주는 자리 수 3이면 3.152 
    console.log("toFixed : " + fix);

    console.log(10/3);  //산수시간에 배운 나누기
    console.log(10%3);  //나머지계산

    console.log(Math.floor(10/3));  //몫계산, 버림으로 처리한다


}

/*
    * HTML에 있는 모든 값은 문자
    ** HTML을 통해서 서버로 값을 전송(form요소)하면 모두 문자
*/
function isNumber(){
    var htmlNum = document.getElementById("numValue").value;
    console.log(typeof htmlNum, htmlNum, isNaN(htmlNum));

    //숫자로 변경하는 한 문자인가?
    //**** 값이 없는 것 "" => 0으로 변경해서 처리
    if(isNaN(htmlNum)){
        console.log("숫자가 아닙니다")
    }else{
        console.log("숫자입니다")
    }
}

function isRegEx(){
    //[0-9]
    //\d(숫자인 것), \D(숫자가 아닌 것)

    var regEx = /^[0-9]*$/; //숫자판별
    var regExPhone = /\d{2,3}-\d{3,4}-\d{4}/gim;
    var textValue = document.getElementById("textValue").value;
    if(textValue == "" || !regEx.test(textValue)){
        console.log("숫자만 입력해주세요")
    } else {
        console.log("숫자만 입력되었습니다");
    }
}