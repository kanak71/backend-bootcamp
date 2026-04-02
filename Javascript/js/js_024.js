function createImage(){
    var radio = document.getElementsByName("rdoBtn");
    var radioValue="";

    // checkbox와 radio의 상태는 checked를 통해서 확인
    for(let i=0; i<radio.length; i++){
        if(radio[i].checked){
            radioValue = "./img/"+radio[i].value;
        }
    } //for문 끝

    //img tag를 생성하고 src 속성을 지정한다
    var image = document.createElement("img");
    image.setAttribute("src", radioValue);

    //div image에 자식 태그로 append 한다
    var div = document.getElementById("imgView");
    div.appendChild(image);
}

function createRemove(){
    var div = document.getElementById("imgView");
    /*
        div에 자식노드가 있다면 삭제하고 replace하여 새로운 img를 붙여 넣음
        
        ** childsNodes로 검색된 전체(주석, textnode 포함)노드를 가져오면 개수를 예측하여 for문을 사용하기 어렵다
           Elements만을 검색하기 위해서 child가 아닌 **children **을 사용하면 Element만을 가져온다

    */
    console.log("childNodes의 개수 :" , div.childNodes.length);
    console.log("childeren의 개수 :" , div.children.length);
    
    console.log("첫번째 node 찾기 :", div.firstChild);

    var radio = document.getElementsByName("rdoBtn");
    var radioValue ="";
    for(let i=0; i<radio.length;i++){
        if(radio[i].checked){
            radioValue = "./img/"+radio[i].value;
        }
    }

    var img = document.createElement("img");
    img.setAttribute("src", radioValue);

    var oldImg = document.querySelector("#imgView>img");
    div.replaceChild(img, oldImg);
}
