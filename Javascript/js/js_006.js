/* 
    DOM(Document Object Model) 탐색이란?
     ㄴ HTML 문서를 객체(Object) 형태로 변환한 구조
     ㄴ Element를 찾는다
    
    찾는방식
        1) document.getElement***
        2) document.querySelector() => Node
            document.querySelectorAll() => NodeList
        => CSS 선택자를 통한 방법
*/


function searchQS() {
    //var doc = document.getElementById("querySelector")
    var doc = document.querySelector("#querySelector");
    doc.innerHTML = "<span>셀렉터표현식의 querySelector은 Node로 가져온다</span><br>"
}

function searchId(){
    var docId = document.getElementById("testId");
    //내용변경, 배경색변경
    //내용변경 : innerHTML - 탐색된 Element내의 HTML을 포함하여 가져온다
    //          textContent - 탐색된 Element내의 Text만을 가져온다

    docId.innerHTML = "<b>ID 탐색된 Node 콘텐츠를 변경</b>";
    docId.style.backgroundColor="skyblue";

    //주의할점---------------------------------------------
    //querySelectorAll은 무조건 nodeList로 변환한다. Array로 처리해 줘야 한다
    var docQs = document.querySelectorAll("#testId");
    console.log(docQs.length);
    docQs[0].style.color="green";
    docQs[1].style.color="orange"
}


//----------------------------------------------------------------------
//checkbox는 상태를 "checked"로만 확인 가능하다
//유일하게 value로 확인하지 못한다
function checkAll(bool) {
    var allCheck = document.getElementById("allCheck");
    console.log("checkbox는 절대 value로 상태값을 확인하지 말 것!!!!!!", allCheck.value);
    console.log("checkbox는 checked를 통해서 상태값을 확인한다", allCheck.checked);

    // 상태를 변경할 checkbox를 탐색한다 name
    var names = document.getElementsByName("chk");  //NodeList
    console.log("checkbox의 타겟 개수 :", name.length);

    for(let i=0; i<names.length; i++){
        names[i].checked = bool;
    }

}

window.onload = function() {
    var names = document.getElementsByName("chk");
    for(let i=0; i<names.length; i++){
        names[i].onclick = checkCnt;
    }
}

var checkCnt = function(){
    var names = document.getElementsByName("chk");
    var cnt = 0;
    for(let i=0; i<names.length; i++){
        if(names[i].checked){ //boolean, 객체만 있어도 true
            cnt++;
        }
    }

    if(cnt == names.length){    //체크된 개수와 chk가 같다면 모두 체크된 상태이구나
        document.getElementById("allCheck").checked = true;
    } else{
        document.getElementById("allCheck").checked = false;
    }
}

//*** 여러개로 되어 있는 DOM 탐색을 하면 javascript의 Array가 아니다!!!!!!!!!1
//tagName, name, class 검색을 하면 Node List => [HTMLCollection] 객체니깐
function tagNameSearch(){
    var fieldSets = document.getElementsByTagName("fieldset");    //HTMLCollection 객체가 들어가있다
    console.log(fieldSets);
    Array.from(fieldSets).forEach(ele => {
        ele.style.backgroundColor = "#b95f5f";
    });
}