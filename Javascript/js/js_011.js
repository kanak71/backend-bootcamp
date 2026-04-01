function numTest(){
    //화면에서 탐색되어서 가져온 값은 모두 string이다
    var val = document.querySelector("#num").value;
    console.log(typeof val, val);

    //받은 값이 연산을 필요로한다면 반드시 형변환을 해줘야 한다
    var cal = val+10;   //"11"+10
    console.log(cal);
    
    //new Number(): 객체를 사용할때는 valueOf()
    // Number()
    // parseInt()

    var newNum = new Number(val);   //객체
    var number = Number(val);
    var parse = parseInt(val);

    console.log(typeof newNum, typeof number, typeof parse);
}

function textNum(){
    var val = document.getElementById("textNum").value;
    //숫자아니라면 -> NaN
    console.log(typeof parseInt(val), parseInt(val));   //number, NaN
}

function textFloat(){
    var val = document.getElementById("textFloat").value;
    console.log(parseFloat(val) + 10);
    console.log(typeof parseFloat(val));
}

function calculation(){
    var txt = document.getElementById("evalValue")[0].value;
    document.getElementById("showCal").textContent = txt;
    var result = eval(txt);
    document.getElementById("resultCal").textContent = result;
}