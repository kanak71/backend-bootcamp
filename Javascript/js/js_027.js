function tableInput(){
    var doc = document.frm;

    var vals = [doc.id.value,
                doc.pw.value,
                doc.address.value,
                doc.phone.value
                ];

    
    //유효성 검사
    for(let i=0; i<vals.length; i++){
        if(vals[i] == ""){
            alert("모든 값은 필수입니다");
            return;
        }
    }

    console.log("for문 실행 후");

    var tbody = document.getElementById("arrd");
    var len_tbody = tbody.children.length;  //하위의 tr 개수

    //java에서는 반드시 문법이 반환타입이 있어야 한다 String s = (str == null)? "널임":"널아님";
    //자바스크립트에서는 반환타입이 없어도 된다 (str == null)? "널임":"널아님"

    len_tbody < 10 ? tbody.appendChild(createRow(vals)) : alert("10개까지만 추가 가능합니다");


}

//hadlerbar.js를 많이 사용한다
function createRow(vals){
    var tr = document.createElement("tr");
    for(let i=0; i<vals.length; i++){

        tr.dataset.rowId = i;
        
        var td = document.createElement("td");
        td.textContent = vals[i];

        tr.appendChild(td);
    }

    var delBtd = document.createElement("td");
    var input = document.createElement("input");
    input.setAttribute("type","button");
    input.setAttribute("value", "삭제");
    input.setAttribute("onclick","delRow(this)");

    delBtd.appendChild(input);
    tr.appendChild(delBtd);

    return tr;

}

function deleteTable(){
    var tbody = document.getElementById("arrd");
    tbody.removeChild(tbody.lastChild);
}

/*
    ** 동적으로 만들어낸 onclick = delRow(this)는 화면이 로드된 후에 생성되었다
        이전에 처리된 onclick이 아니기 때문에 기능을 동작 시킬 수 없다
*/

function delRow(elem){
    // delRow(this) => 클릭하는 대상을 이야기 한다
    
    //var delTr = elem.parentNode.parentNode;
    //1) 자신을 삭제
    delTr.remove();
    //2) 부모를 통해서 삭제, 교체, 이동
    var tbody = document.getElementById("addr");
    tbody.removeChild(delTr);
}

window.onload = function(){
    var div = document.querySelector("form>div");
    div.onclick = function(){
        alert(this.tagName);
    };

    var trs = document.getElementById("arrd");

    /*
        *** 동적으로 생성된 tag에 이벤트를 걸어주는 방법
            chaning을 통해서 상위 tag의 이벤트를 통해서 하위를 검색
            event.target
     */

    trs.onclick = function(event){
        var btn = event.target;

        var tr = event.target.closest("tr");
        console.log("event.target 객체 :" + btn);
        console.log("closest tr" + tr);

        console.log("dataset.rowId" + tr.dataset.rowId)

        //영역을 누르면 그냥 삭제
        if(event.target.tagName == "TD"){
            tr.remove();
        }
    }
}