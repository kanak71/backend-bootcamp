// 즉시 실행 함수(Immediatly Invoked Function Expression)

/*
    var alert = 10;
    alert = 'a';
    => window의 영역을 변경해버린다

*/

(
    function(){
        var alert = 10;
        console.log(`\n alert ☞ ${alert}, typeof(alert) ☞ ${typeof alert}`);
        console.log(window);
    }
)();

alert("봄은 힘들어요");