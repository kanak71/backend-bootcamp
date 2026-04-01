/*
    Array의 선언과 기본사용
    - 동적변수이기 때문에 어떠한 타입과도 복합적으로 사용이 가능하다
    - 크기의 선언 및 확장이 자유롭다

    let array = [1,2,3,4,'d',3.14,false];
    console.log(typeof array);  //object

    출력 4가지 방식
    1) index for문 : for(let i=0; i<arg.length; i++){}
    2) in 문법 : for(let i : arg) {arg[i]}
    3) of 문법 : for(let o : arg) {  o  }
    4) forEach : array.forEach(function(x){  x  });
                array.forEach((x) => {  x  })
*/

//생성방법 1
var array01 = new Array();  //new 생성자를 통해서 클래스를 선언
var array02 = [1, '1', false];  //권장생성방법
console.log(typeof array01);    //object로 출력

//생성방법 2
var array_01 = new Array(); //값이 없고 공간이 없다
var array_02 = new Array(3);    //한개의 정수값을 입력 했을 경우 공간의 크기 [ , , ]
var array_03 = new Array(1,2,3,4);  //4개의 값을 가지고 있는 4개의 공간[1,2,3,4]


//길이 확인
//자바같은 정적변수이기 때문에 int[] a = new int[3]; 공간이 초기화 된다
//하지만 javascript 동적변수이기 때문에 초기화가 없고 undefinded가 된다
console.log("array_01 길이 - 비어있음", array_01.length, array_01[0]);
console.log("array_02 길이 - 공간만 있음", array_02.length, array_02[0]);
array_03[10] = 10;
console.log("array_03 길이 - 없는 index의 크기", array_03.length);
console.log(array_03[0], array_03[5], array_03[10]);

/*
    공간의 크기 제약이 없다
    공간이 만들어지면 undefinded의 값이 입력된다
 */

function multiArray(){
    var len = 3;
    var multiArray = new Array(len);
    for(let i=0; i<len; i++){
        multiArray[i] = new Array(len);
    }

    multiArray[0][0] = "아이스아메리카노";
    multiArray[0][1] = "커피";
    multiArray[0][2] = "프라프치노";

    multiArray[1][0] = 1;
    multiArray[1][1] = 2;
    multiArray[1][2] = 3;

    multiArray[2][0] = ["html","css"];
    multiArray[2][1] = ["javascript", "react"];
    multiArray[2][2] = ["spring","java"];

    //javscript를 가져오고 싶다
    console.log(multiArray[2][1][0]);
    


}

function joinArray(){
    var array_001 = [["Apple","Banana","Tomato",10]];
    var array_002 = [["가","나",2]];

    var sumArray = array_001 + array_002;   //각 요소(, 포함)을 한줄의 문자열로 만들어준다
    for(let i=0; i<sumArray.length; i++){
        console.log(i, sumArray[i]);
    }

    var arrayConcat = array_001.concat(array_002);
    console.log(arrayConcat);

    //Array는 문자열 Concat처럼 동작 되지 않는다
    // + 요소를 모두 나열하는 Array로 만들어짐
    //array concat은 앞에 있는 array 0 가 되고, 뒤에 있는 array 1로 만들어 진다
}

function stringSort(){
    //소문자, 대문자, null, 숫자가 있다면 우선순위는 어떻게 될까?
    var arr = ["a","b","c", null, 1, "A"];
    //문자형 숫자의 정렬 letter와 약간 다름
    var arrNum = ["1", "50", "100"];

    arr.sort(); //ASC , 숫자 => 대문자 => 소문자 => null 순으로 정렬
    arrNum.sort();  //문자 indexing으로 처리 "1" => "100" => "50"

    console.log("혼합 :", arr)
    console.log("문자형 숫자 : ", arrNum);
}

function numberSort(){
    // ** 입력된 값을 숫자이지만 문자로 처리된다
    var arr = [1, 20, 10, 2, 30];
    //arr.sort();
    //console.log(arr);

    //1.비교 함수를 만들어 양수/음수 판단하여 처리
    // 함수 리터럴, 콜백 => 함수도 값이 될 수 있다, 함수를 입력해서 함수가 나오는 형태
    //arr.sort(compare);
    //console.log(arr);

    //2. 함수를 생성하지 않고 화살표 함수를 사용하여 연산처리
    //arr.sort((a,b)=>a-b);
    //console.log(arr);

    //3.숫자와 문자가 함께 있다면?
    var arrCompare = [100, "a", "ab", "b", 2, 5];
    arrCompare.sort((a,b)=>{
        //숫자와 문자를 구분하여 비교
        if(typeof a === 'number' && typeof b ==='number'){
            return a-b;
        }
        if(typeof a==='string' && typeof b === 'string'){
            return a.localeCompare(b)
        }

        //숫자가 앞에 있도록
        if(typeof a == 'number'){
            return -1;
        }
        if(typeof b == 'number'){
            return 1;
        }
        return 0;
    });

    console.log(arrCompare);

}

function compare(a, b) {
    return a-b;
}

//-----------------------------------------------
/*
    1.Stack
        : LIFO(Last In First Out)
         쌓여있는 블럭
         push() - 데이터넣기
         pop() - 데이터제거
         peek() - 맨 위의 데이터 확인

    2.Queue
        : FIFO(First IN First Out)
         먼저 들어온 데이터가 먼저 나간다
         enqueue() - 데이터 넣기
         dequeue() - 데이터 제거
         peek() - 앞 데이터 확인

 */
function fn(){
    var queue = new Array();
    //index에 상관 없이 값을 입력 push
    queue.push(10);
    queue.push("first");
    queue.push("second");
    queue.push("third");
    console.log(queue)

    //array를 앞부터 잘라냄 : shift()
    var array0 = queue.shift();
    console.log(array0);
    console.log(queue);

    //array 뒷부분부터 잘라냄 : pop()
    var array1 = queue.pop();
    console.log(array1);


}

function sliceFn(){
    var array = [1,2,3,4,5,6];

    var array_slice01 = array.slice(3); //시작 index 포함
    console.log(array_slice01);
    console.log(array);

    //slice는 잘라내는 end index를 포함하지 않는다
    var array_slice02 = array.slice(2,3);
    console.log(array_slice02);

    //다차원이라면??
    var multi = new Array(3);
    multi[0] = new Array(1,2);
    multi[0] = new Array(3,4);
    multi[0] = new Array(5,6);

    var array_slice03 = multi.slice(2,3);
    console.log(array_slice03);

}