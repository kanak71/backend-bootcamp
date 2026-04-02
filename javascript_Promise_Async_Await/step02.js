/*
    2) 요청된 주소에 상태에 따라서
        요청/대기/에러를 나타낼 시간을 갖게 된다
        이러한 문제점을 해결하기 위해서
         *** Promise 객체를 만들어서 사용하게 된다
*/

//외부에서 서버를 요청 fetch()
var req = fetch("https://jsonplaceholder.typicode.com/posts");
console.log(req);   //뭐야 브라우저는 잘 나와서 데이터 봤는데 왜? Promise { <pending> }
