/*
    VSCode 터미널에서 node -v 실행이 안되고 오류
    Set-ExcutionPolicy : => 필요한 정책이 없다(권한이 없다)
    해결방법 : Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope LocalMachine

    1) 기본적인 흐름
     javascript에 선언된 변수는 선언되고 다시 재입력된다
     즉각적인 서버의 요청으로 변수의 값이 변경되어 나온다

     ** 변수를 사용할 때 name처럼 삭제선 표시가 되면 window에서 사용하고 있는 예약어, 반드시 변경해서 사용해야한다. global오염

*/

var name = "coffee";
name = 'milk';
console.log(name);
