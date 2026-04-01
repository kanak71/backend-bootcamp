/*
    XSS(Cross Side Script) 조심해야한다

    innerHTML, textContent, innerText

    markup으로 되어 있는 tag + 글은 모두 문자(string) 가져올 수 있다
    ㄴ text만 가져오는 것 : textContent, innerText
    ㄴ 선택된 하위의 tag를 포함하여 가져오는 것 : innerHTML

    ** textarea는 markup으로 표시되어 있다
        하지만 textarea는 반드시 value속성으로 작업해야 한다
        textarea는 글자를 문장을 서버로 전송한다. XSS 대비해야 한다 => editor를 사용
        즉, java문자열과 같은, 엔터(13, \n)
            출력을 할 때 textarea => textarea로 출력할 땐 문제가 없다
                textarea=> html 로 출력하게 되면 브라우저가 실행을 시킨다
        XSS공격을 막기 위해서
        \n => <br>
        혹은 tag를 지워주는 regEx 사용해야 한다 
*/

function txtArea(){
    var txt = document.getElementById("txt");

    console.log(txt.innerHTML)
    console.log(txt.innerText)
    console.log(txt.textContent)
    console.log(txt.value)

    //textarea를 HTML에 작성해 본다
    //document.getElementById("view").innerHTML = txt.value;

    //1) textarea에 있는 모든 tag 제거
    var newText = txt.value;
    //newText = newText.replace(/(<([^>]+)>)/ig, "");
    //document.getElementById("view").innerHTML = newText;

    //2) Entity Tag로 변경
    newText = newText.replace(/(?:\r\n|\n|\r|\n\r)/gm,"<br>")
                                .replace(/</g,"&lt;")
                                .replace(/>/g,"&gt;");
    document.getElementById("view").innerHTML = newText;

    //-----------------------------------------------------

    /*
        form에 있는 submit 이벤트를 통해서 form action을 서버에 전송
        목적 : form을 탐색하여 자바스크립트를 통해서 전송해보자
     */

        //form을 찾는 방법
        //1) id 탐색
        var frm = document.getElementById("frm");
        //2) name 탐색
        frm = document.frm;
        //3) tag 방식
        frm = document.forms[2];

        console.log(frm);
        frm.action ="http://localhost:8080/web00_form_server/formServlet.servlet";
        frm.method="get";
        frm.submit();   //


        /*
            MPA(Multiful Page Application)
              ㄴ 각각의 기능적 페이지가 따로 존재한다

            SPA(Single Page Application)
             ㄴ SpringBoot 서버에서는 값만을 처리
             ㄴ React.. 값을 받아서 화면 구성
               하나의 페이지에서 값을 통해서 생성하고 교체
            Ajax
        */

            
}