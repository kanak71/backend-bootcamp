function windowOpen(){
    //window.open(url, title, 속성) => 새로운 팝업창을 열어 줌
    var url = "./js_016_window_open_child.html";
    var title = "자식화면";
    var prop = "top = 100px, left=300px, width=300px, height=500px";
    window.open(url, title, prop);
}

window.onload = function(){
    document.getElementsByName("btn_1")[1].addEventListener("click", registform);
}

function registform(){
    console.log("회원가입 다이얼로그 창");


    document.getElementById("regist").style.display="block";
    // 약간의 딜레이를 두어서 css 'transform'의 효과를 트리거
    requestAnimationFrame(()=>{
        document.getElementById("regist").style.transform = "scale(1)"
    });

    document.body.style.backgroundColor = "#ccc";
    var btns = document.getElementsByName("btn_1");
    for(let i in btns){
        btns[i].disabled ="disabled";
    }

}

function cancel(){
    document.getElementById("regist").style.transform = "scale(0.5)"
    setInterval(()=> {
       document.getElementById("regist").style.display= "none"; 
    }, 1000);

    document.body.style.backgroundColor = "while";
    var btns = document.getElementsByName("btn_1");
    for(let i in btns){
        btns[i].disabled ="";
    }
}

function idChk(){
    var id = document.getElementById("id").value;
    //화면에서 탐색된 결과는 undefinded가 아니라 ""
    if(id == ""){
        alert("중복검사를 먼저 실행해주세요");
        return;
    }
}

function idCheck(){
    open("./js_016_window_open_중복검사.html","","width=400px, height=500px");
}