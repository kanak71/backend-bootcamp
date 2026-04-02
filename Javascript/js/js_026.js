function childAppend(){
    var fieldSet = document.getElementById("addElement");

    var p = document.createElement("p");
    p.textContent="한글";   //같다 var txt = document.createTextNode("한글"); p.appendChild(txt);

    fieldSet.appendChild(p);
}

var cnt = 1;

function beforeInsert(){
    var newP = document.createElement("p");
    newP.textContent = (cnt++) + ": Element";

    var fieldSet = document.getElementById("addElement");

    var firstChild = fieldSet.firstElementChild;
    fieldSet.insertBefore(newP, firstChild);
}

function moveElement(){
    //fieldset에 div태그 가져오기
    var moveEle = document.getElementById("addElement").children[1];
    //body의 위치 탐색
    var addElem = document.body;

    //Element의 복제
    var copyElem = moveEle.cloneNode(true);

    //addElem.append(copyElem);
    addElem.append(moveEle);

}

function addTest(){
    var divAdd = document.createElement("div");
    divAdd.textContent = "DOM TEST";

    document.getElementById("text01").appendChild(divAdd);
}

function moveTest(){
    var text02 = document.getElementById("text02");
    var childNode = document.getElementById("text01").children[0];

    text02.appendChild(childNode);
}

