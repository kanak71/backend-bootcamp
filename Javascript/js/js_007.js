/*
    1. 객체의 작성 방법은 명시적/익명적 방법
        ** 명시적 방법에서 this를 사용하여 객체 내부와 외부를 구분할 수 있다
    2. 객체의 작성 방법은 함수의 작성 방법과 같음
    Pascal 방식을 사용하고, new를 통해서 사용한다
    ex) var n = new Number(); n.valueOf()

    명시적 방법의 작성
    - this는 new를 통해서 객체를 생성하면, 객체명을 통해서 속성 접근이 가능하다(수정/삭제)
    - 객체 내부에 생성된 (var로 생성) 변수를 외부에서는 절대 접근이 불가능하다. 
        따라서 값을 은닉화 할 수 있다
    - 만약, 외부에서 값을 가져가거나 혹은 입력만 하는 경우를 만들고 있다면 익명 함수를 통해서 정의 할 수 있다

*/

/*
    *** 클래스는 생성자(Constructor)를 가지고 있다 
    자바와 같이 생성자 오버로딩이 되지 않고, 한개만 가능하다  
*/
function Class08(){
    this.name = "eclipse";  //public변수 = 외부에서 사용할 수 있는 Class 변수
    var name02 = "javascript";  //private변수 = 외부에서 사용할 수 없고 내부에서 연산으로 사용할 수 있다
    this.getName02 = function(){    //외부에서 가져갈 수 있는 getter 메소드
        return name02;
    }
}

// 캡슐화(Encapsulation - 익명적 작성 방법) : private멤버필드 + getter
// 반드시 getter를 통해서만 접근이 가능
var Class08_02 = {
    name : "like_lion",
    print : function(){
        alert(Class08_02.name + "^^");
        return Class08_02.name;
    }
};

function objectTest(){
    //객체의 사용방법
    var class008 = new Class08();
    class008.name = "사자";
    alert("class008의 속성값 name : " + class008.name)  //this로 선언되면 외부에서 사용이 가능하다
    alert("class008의 속성값 name02" + class008.name02) //객체 내부에 var로 선언되어 있어서 접근이 불가능
    alert("class008의 은닉화된 내부 함수 getName02() :"+ class008.getName02()); //name02는 은닉화 되어 있기 때문에 this.get***을 통해서 출력만 가능

    //익명적 객체 사용방법
    //익명함수는 모두 외부에 노출된다
    //new 필요 없음, 값을 전달할 때 사용한다
    Class08_02.name="정글";
    alert("class08_02.name의 속성값 :" + Class08_02.name);
    alert("class08_02.name의 함수 : " + Class08_02.print());
}

//프로토타입
//윈도우의 콘솔에서 console.log(new Class08)을 통해서 프로토타입을 확인할 수 있다

var class008proto = new Class08()   //객체 생성

/*
    객체만 단독으로 출력 : 객체의 정보가 나온다
    객체와  Concat을 하게되면 : object
*/
console.log("**" + class008proto);  //문자열 **때문에 객체가 출력되는 것이 아니라 객체의 타입 [object]
console.log(class008proto); //단독으로 출력은 정보가 나온다

Class08.prototype.printName = function(){
    //this는 name과 getName02()가 있다
    //Prototype 영역은 외부에 있는 영역이기 때문에 반드시 this를 사용해아 한다
    alert(this.name + "/" + this.getName02())
}

class008proto.printName();