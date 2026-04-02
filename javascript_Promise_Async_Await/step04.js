/*
    https://dog.ceo/api/breeds/image/random
    3-2) 실질적인 데이터를 사용하여 처리

        호출을 fetch() 비동기를 위한 패키지
        axois
        

    java프로젝트로 빌드/배포 => Maven, gradle
    python 프로젝트 빌드/배포 => pip
    javascript 프로젝트 빌드/배포 => npm(node package manager)

*/

const axios = require("axios");

const data = axios.get("https://dog.ceo/api/breeds/image/random");
console.log(data);  //pending으로 값이 들어오며, 이것은 값이 Promise 객체이다
                    //즉, 데이터를 가져오기 위해서는 promise객체를 처리해줘야 한다. step03에 then catch, async await

data   
    .then((res)=>{
        console.log(res.data);  //Promise 객체를 data 키에 값을 담아서 준다
    })
    .catch((err)=>{
        console.log(err)
    })
    .finally(()=> {
        console.log("Promise 객체 설명중");
    });