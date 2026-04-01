/*
    radio, checkbox는 상태를 value로 확인하지 않는다
    checked로 확인한다

    select 특수한 tag
    - selected : 자식(<option>을 선택)
    - selectedIndex : 선택된 자식(<option>)의 index 번호
    - options : select tag내에서 option 태그를 모두 탐색한 것
*/

function showFood(){
    //onchange는 값이 변경되어야만 동작한다
    console.log("변하는 값을 선택했을 때 동작");

    //1) 선택된 option을 index로 가져온다
    var food01 = document.getElementsByName("food")[0];
    var idx = food01.selectedIndex;
    console.log("선택된 option의 index : " + idx);

    //2) index를 통해서 해당 option의 value를 탐색한다
    var foodValue = food01.options[idx].value;
    var foodContent = food01.options[idx].textContent;
    console.log("선택된 옵션의 value : ", foodValue)
    console.log("선택된 옵션의 content : ", foodContent);
}