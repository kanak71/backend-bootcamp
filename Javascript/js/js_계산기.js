let input1 = "";

function press(hi){
    input1 += hi;
    document.getElementById("result1").value = input1;
}

function calculate(){
    let result = eval(input1);
    document.getElementById("result1").value = result;
    input1 = result;
}