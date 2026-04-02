function searchParent(){
    //p tag를 모두 찾는다
    var child = document.getElementsByTagName("p");
    console.log("p tag의 개수 :", child.length);

    //셀렉터 표현시기으로 첫번째 div를 찾아보자
    var div = document.querySelector("div");

    //markup(Element)의 콘텐츠를 찾아보자
    console.log(div.innerHTML);
    console.log(div.innerText);
    console.log(div.length);

    //선택된 node 최근접 상위 노드를 찾음
    var divParent = child[1].parentNode;
    console.log(divParent.tagName);
    console.log(divParent.textContent);

    divParent.style.backgroundColor = "pink";
}

function searchChild(){
    var div = document.getElementsByTagName("div")[0];
    //console.log(div.length,div);

    //하위의 node를 모두 가져옴
    //** 주석, 태그, 줄바꿈까지
    var divChild = div.childNodes;
    console.log(divChild.length);
    for(let i=0; i<divChild.length; i++){
        console.log(i, divChild[i], divChild[i].tagName);
    }
}

function domExam(){
    var p = document.getElementsByTagName("p")[3];
    var div = p.parentNode;
    div.style.backgroundColor = "orange";

    var div2 = document.getElementsByTagName("div")[3];
    var p2 = div2.childNodes;

    for(let i=0; i<p2.length; i++){
        console.log(i, p2[i], p2[i].tagName);
    }

    var p3 = div2.childNodes[3];
    p3.style.fontSize = "30pt";
}

/*
    정리
     1) tag는 Element로 구성이 되어 있다
     2) tag의 구성을 가져오는 방법은 innerHTML
     3) 구성은 모두를 포함
      ㄴ Element 내의 구성요소 : 줄바꿈, 주석도 포함된다
      ㄴ textNode, Node, 주석
    
    결론
     부모에서 자식을 탐색했을 경우 반드시 node를 확인해주세요
*/