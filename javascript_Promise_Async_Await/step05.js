/*
    3-3) Async Await 로 변경

    await는 async에 의해서 실행된 요청 주소에서 데이터가 넘어올 때 까지 자동으로 확인한다
    이 방식은 오류가 발생하면 Promise객체 처럼, then()이나 catch()에서 처리 할 수 없다.
    따라서 try - catch를 통해서 처리 한다

*/

const axios = require("axios");

let d;

const fetch = async() => {
    try {
        const data = await axios.get("https://jsonplaceholder.typicode.com/comments")
        d = data.data;
        console.log(data);
    } catch (error) {
        console.log(error+"잘못된 동작");
    }finally{
        console.log("async await 동작");
    }
}

(
    async () => {
        await fetch();
        console.log("^^", d)
    }
)();
