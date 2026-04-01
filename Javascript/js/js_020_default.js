//javascript class를 생성하고 생성자를 통해서 실행

class Greeting{
    constructor(name){
        this.greeting = "hello"+name;
    }
}

//일반 변수를 통해서 전달
const name = "둘리";
const age = "50";

//함수를 사용하여 기능을 전달
const message = (name, age)=>{
    return `${name} 는 ${age} 나이이다`;
}

//사용되는 alias로 처리 되는 부분 export
export { message, name, age, Greeting as insa}
//export default message;