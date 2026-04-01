// 화면에 출력
//dom create를 사용하게 된다
//innerHTML과 textContent
function antQuizPrint(){
    var printArea = document.getElementById("printArea");
    //append할 변수
    var html="";
    var stage = document.getElementById("stageValue");
    console.log(stage.value);

    var initValue="11";
    html += initValue+"<br>";
    for(let i=0; i<stage.value; i++){
        //결과를 출력하는 함수 실행 => 누적
        initValue = antNextStage(initValue);
        html += initValue +"<br>";

    }
    printArea.innerHTML = html;

}

// 수열의 다음 값을 연산하고 반환
function antNextStage(initValue){
    var c = initValue.charAt(0);
    var cnt = 1;
    var result ="";

    for(let i=1; i<initValue.length; i++){
        if(c == initValue.charAt(i)){
            cnt++;
        } else{
            result = result + c + cnt;
            cnt = 1;
            c = initValue.charAt(i);
        }

    }

    result = result + c + cnt;
    return result;

}