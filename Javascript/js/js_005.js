/**
    propagation을 막아내는 방법
    1) tag의 on 이벤트를 막는 방식
     ㄴ 탐색된 객체의 속성중에 "stopPropagation()"을 실행
    2) tag의 속성이벤트를 막는 방법
     ㄴ eventPreventDefault()를 통해서 속성 이벤트를 막는다
    **** 3) 1)번과 2)번을 동시에 막는 방법은 return false
 */


var num = 1;
function preGallary(){
    num--;
    if(num <1) {
        num = 5;
    }
    document.getElementById("gallary").src="./img/" + num+".png";

    return false;
}

function nextGallary(){
     num++;
    if(num > 5) {
        num = 1;
    }
    document.getElementById("gallary").src="./img/" + num+".png";

    return false;

}