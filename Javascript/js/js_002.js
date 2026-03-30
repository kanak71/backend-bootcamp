/*
1. javascript는 위치에 따라서 embeded와 link 구분이 순차적으로 진행
*/

alert("링크 alert 2")

/*
    defer 지연 처리 방식
    해당 javascript에 defer 속성을 작성하면 마지막에 실행될 수 있도록 해준다
*/

//익명함수 : 함수명을 가지고 있지 않은 함수
//onload는 해당 html(document)의 모든 html 과 javascript가 실행된 후 마지막에 실행된다
window.onload = function() {
     alert("onload 실행")

     // onload는 모두 렌더링 된 후에 동작
     // 이벤트를 dom에 설정 할 때 사용된다
     document.getElementById('div-click').onclick = function(){
        alert("div에 ID를 통해서 onclick 이벤트를 설정한다");
     }
}

// document.addEventListener("DOMContentLoaded", function(){});