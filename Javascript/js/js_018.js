//checkbox는 value 아니고 checked 상태를 확인한다
function allSelect(bool){
    //this속성을 통해서 HTML의 상태를 전달
    console.log("전달 값:", bool);

    //checkbox의 value는 on으로 출력된다
    var allCheck = document.getElementsByName("allCheck")[0].value;
    console.log("checkbox의 value 값 : ", allCheck);

    var chks = document.getElementsByName("chk");
    console.log("chk name의 개수 :" , chks.length);

    for(let i=0; i<chks.length; i++){
        chks[i].checked = bool;
    }

}
//체크된 checkbox의 값을 가지고 와서 backgroundColor로 사용함
function selColor(){
    var chks = document.getElementsByName("chk");
    //유효성검사
    if(chkChecked(chks) >0){
        for(let i in chks){
            if(chks[i].checked){
                document.getElementById(chks[i].value).style.backgroundColor=chks[i].value;
            } else{
                document.getElementById(chks[i].value).style.backgroundColor="white";
            }
        }
    }

}

//선택된 checkbox의 개수를 반환
function chkChecked(chks){
    let checkCnt = 0;
    for(let c of chks){
        if(c.checked){
            checkCnt++;
        }
    }

    return checkCnt;
}

function clearDiv(){
    //일반 for
    //for(let i in chks){
    //        if(chks[i].checked){
    //            document.getElementById(chks[i].value).style.backgroundColor=chks[i].value;

    //선택자를 통한 DOM 탐색
    var checkBox = document.querySelectorAll("input[type=checkbox]"); 
    for(let c of checkBox){
        c.checked = false;
    }

    var colorBox = document.querySelectorAll("#colorBox>div");
    for(let b of colorBox){
        b.style.backgroundColor = "white";
    }

}

// chk가 한개라도 선택이 되지 않으면 allCheck의 상태를 변경
// 이벤트가 없는 (tag onclick 코드가 없는), tag 화면으로 그려주고(렌더링) 그 다음에 다시 tag를 검색해서 이벤츠를 처리 한다
window.onload = function(){
    var chks = document.getElementsByName("chk");
    var allCheck = document.getElementsByName("allCheck")[0];

    for(let i=0; i<chks.length; i++){
        chks[i].onclick = function(){
            if(chks.length == chkChecked(chks)){
                allCheck.checked = true;
            } else{
                allCheck.checked = false;
            }
        }
    }
}