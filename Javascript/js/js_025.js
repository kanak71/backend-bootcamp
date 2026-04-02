document.addEventListener("DOMContentLoaded", function(){
    var anchs = document.querySelectorAll("a");
    var count = 1;
    var img = document.querySelector("img");

    //속성 여부
    //hasAttribute, 있으면 값을 변경할 수 있고, 없으면 생성 후 변경

    console.log("alt 속성이 있니?", img.hasAttribute("alt"))
    console.log("title 속성이 있니?", img.hasAttribute("title"))

    //왼쪽
    anchs[0].onclick = function(){
        var imgAlt = img.getAttribute("alt");
        var imgTitle = img.getAttribute("title");
        console.log(imgAlt, imgTitle)

        if(imgAlt == "img01"){
            alert("첫번째 이미지 입니다")
        } else{
            img.setAttribute("alt", "img0" + (--count))
            img.setAttribute("src", "./img/"+count+".png");
        }
    };

    //오른쪽
    anchs[1].onclick = function(){
        var imgAlt = img.getAttribute("alt");
        var imgTitle = img.getAttribute("title");
        console.log(imgAlt, imgTitle)

        if(imgAlt == "img03"){
            alert("마지막 이미지 입니다")
        } else{
            img.setAttribute("alt", "img0" + (++count))
            img.setAttribute("src", "./img/"+count+".png");
        }
    };



})