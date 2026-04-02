function elementCreate(){
    //body에 div를 작성하고
    //속성을 입력하고
    //글을 입력하고
    //p tag에 자식으로 붙여 넣음

    var tmp = "<div style='background-color:skyblue;'>한건했다</div>";
    var p = document.getElementById("loc");

    //p.innerHTML = tmp;  //text로 되어 있는 HTML이 입력되어 처리 된다
    //p.append(tmp);  //string 입력값을 textNode로 처리 하기 떼문에 html이 적용되지 않음
    //p.appendChild(tmp); //textNode를 입력 할 수 없고 반드시 node만 가능, createElement된 Node 기능

    var div = document.createElement("div");    //<div></div>
    var attr = document.createAttribute("style")    //style=
    var txt = document.createTextNode("날씨가 좋은 봄날");

    //속성도 입력하면서 속성 값을 입력하는 방법
    div.setAttribute("style", "background-color:skyblue");  //<div style='background-color:skyblue;'>한건했다</div>
    div.appendChild(txt);
    p.appendChild(div);

    //사용하지는 않지만 attr에 값을 입력하는 방법
    // var attr = document.createAttribute("style")    //style=
    // attr.nodeValue = "background-color:skyblue";    //<div style='background-color:skyblue;'>한건했다</div>
    // div.setAttribute(attr);

    //속성을 삭제하는 방법
    div.removeAttribute("style");

    //하지말아야 할 코드 : none, block로 거의 구성되어 있고. "" 입력해도 적용되지 않음
    //document.getElementsByTagName("button")[0].onclick="";

    document.getElementsByTagName("button")[0].removeAttribute("onclick");


}