onload = function(){
    var date = new Date();
    var year = date.getFullYear();
    
    //form요소의 date는 yyyy-mm-dd 형태로 되어 있다
    //Date()바로 값을 전달하면 화면에 출력이 되지 않는다. 형식이 다르기 때문에
    //javascript의 날짜표현은 1자리로 표현
    //string의 padStart를 통해서 두자리로 반드시 변경

    var month = String(date.getMonth()+1).padStart(2,'0');
    var day = String(date.getDate()).padStart(2,'0');

    var graveEx = `${year}-${month}-${day}`;
    console.log(graveEx);
    document.getElementById("inputDate").value =graveEx;

    //DOM탐색을 통해서 button에 onclick 이벤트를 처리해보자
    document.getElementsByTagName("button")[0].onclick = testDate00;
    document.getElementsByTagName("button")[1].onclick = testDate01;
    document.getElementsByTagName("button")[2].onclick = testDate02;
    document.getElementsByTagName("button")[3].onclick = testDate03;
}

function testDate00(){
    console.log("오늘 날짜 출력");
    // 월 : 입력 -1. 출력 +1
    var nowDay = document.getElementById("nowDay");

    //날짜 객체 생성
    var date = new Date();

    //날짜의 형태
    /*
        javascript : 문자열로 처리
        java : SimpleDateFormat("YYYY-mm-DD"); 날짜 =>문자((format()), 문자 => 날짜(parser())
        DB : TO_CHAR(컬럼, 'YYYY-MM-DD hh:mm:ss')
    */

    //출력 : 
    nowDay.innerHTML = date;
    nowDay.innerHTML = date.toDateString();
    nowDay.innerHTML = date.toLocaleDateString();
    nowDay.innerHTML = date.toLocaleTimeString();

    console.log("현재월 :" + date.getMonth())

}

function testDate01(){
    console.log("특정날짜 세팅");
    //문자열의 날자를 입력할때는 month를 -1하지 않아도 된다
    // 2026-03-31, 2026-1-1, 2026.1.1, 2026/1/11, 2026_11_11

    //화면에서 input type="date"는 보여지는 그대로 가져오게 된다
    var inputDate = document.getElementById("inputDate").value;
    console.log(typeof inputDate);  //2026-03-31 string

    //연산의 처리 : 날짜를 하루 더하고 싶다
    //실수 : date는 화면에서 가져왔기 때문에 string 날짜 더하게 되면 concat이 발생한다
    var date = new Date(inputDate); //Date타입으로 2026-03-31으로 세팅 됨
    date = date+999;
    console.log(typeof date, date)

    //하루 더하기
    var dateAdd = new Date(inputDate);
    dateAdd.setDate(dateAdd.getDate()+1);
    console.log(dateAdd.toLocaleDateString());

    //출력 : 요일은 0부터 시작한다. 즉 일요일이 0이다
    var day = dateAdd.getDay();
    console.log("4월 1일의 요일 :", day);
}

function testDate02(){
    console.log("경과 날짜 구하기");
    var dates = document.getElementById("dates").value;
    var inputD = document.getElementById("inputD").value;

    var date = new Date(dates); //세팅

    //그냥 연산하면 concat 반드시 setDate를 통해서 작업해야 한다
    date.setDate(date.getDate()+ parseInt(inputD));

    document.getElementById("resultDate").value = date.toLocaleDateString();
}

function testDate03(){
    console.log("D-Day 구하기");
    var date1 = document.getElementById("inputDate2").value;
    var inputDate1 = document.getElementById("inputDate1").value;

    var startDate = new Date(date1);
    var endDate = new Date(inputDate1);

    //일수 계산은 밀리세컨드로 계산된다 (1000*60*60*24)
    var resultDate = (endDate.getTime() - startDate.getTime()) / (1000*60*60*24);
    document.getElementById("result1").value = resultDate;


}