function stringTest01(){
    //concatenation
    //두개씩만 가능하다 "java".concat("script","","")....
    //+연산자도 가능
    //join 

    // ** 연산자 우선순위
    var str01="문자";
    //concat함수는 내부 연산이 먼저 실행
    var str02 = str01.concat(1, false, 1+1, 1);
    console.log(str02);

    //join
    //array를 하나의 문자열로 만듦, seperate 값
    var joinStr = ['99', 77, 10].join("/");
    console.log(joinStr);


}

/*
    1) 자바스크립트의 변수는 모두 객체이다
    2) 동적변수(대입연산자 오른쪽에 있는 값으로 타입이 정해진다)
    3) 리터럴 값과 객체(valueOf())
    4) 모든 객체의 타입은 object로 출력
    5) ==, ===(완벽한비교)
 */

function stringTest03(){
    var strVal = prompt("당신의 이름은?");
    //var span = document.getElementById("cmd");
    var span = document.querySelector("span#cmd");  //위와 같다

    //regEx : test() - true/false , match() - regEx의 첫번째 값

    //var result = strVal.match(/[2-9]/);
    //console.log(result[0]);

    if(strVal.match(/[2-9]/)){   //자바스크립트에서는 객체 있다면 모두 true
        alert("숫자 2와9까지는 입력 금지")
    } else if(strVal === '1'){
        span.textContent = strVal + "님 반갑습니다"
    } else{
        span.innerHTML = "<span style='color:red;'>다시 입력해주세요</span>"
    }

}

function stringTest04(){
    //indexOf(), lastIndexOf()
    //indexOf("단어", 5)

    var strWord = "홍길동 놀부 흥부 까치 놀부 도깨비";
    console.log(strWord.indexOf("놀부"));   //4
    //python에서는 뒤쪽이지만 javascript에서는 음수이면 indexOfBouncedException이 아니라 0으로 처리된다
    console.log(strWord.indexOf("놀부", -6));   //4
    console.log(strWord.lastIndexOf("놀부", 5));    //4
    console.log(strWord.lastIndexOf("놀부"));   //13

}

//split() 정규화 표현식을 사용해야 한다
//subString, split
function stringTest05(){
    var str="문자열 추출, indexOf                        :          lastIndexOf       ";
    var comma = str.indexOf(",");
    console.log(str.substring(0, comma));

    //split은 정규화 표현식으로 작성해주세요
    var val = "oop:ooo:foo";
    var split = val.split(/:/); //""아니고 //
    console.log(split, split.length);

    //split의 결과값
    var split_o = val.split("o");
    console.log(split_o, split_o.length);

    //charAt()
    var ch = val.charAt(0);
    console.log(ch+"값"+typeof ch);

}