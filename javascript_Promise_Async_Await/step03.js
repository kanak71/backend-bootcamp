/*
    3-1) 기본적인 Promise 객체의 문법 이해
*/

const choiceEvent = new Promise((resolve, reject)=>{
    var name='coffee';
    if(name == 'coffee'){
        resolve(name)
    }else{
        reject("이름이 Coffee가 아닙니다");
    }
});

// 1. then / catch 문법 사용시
// choiceEvent
//     .then(result =>{
//         console.log("resolve", result)
//     })
//     .catch(error =>{
//         console.log("reject", error);
//     });

// 2. async / await 문법 사용시 

async function runEvent(){
    try {
        const result = await choiceEvent;
        console.log("result:", result)
    } catch (error) {
        console.log("error", error);
    }
}

runEvent();