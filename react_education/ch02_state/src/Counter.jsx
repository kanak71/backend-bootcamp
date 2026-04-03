import React, { useEffect, useState } from 'react'

function Counter() {

    //초기값을 0으로 갖는 state : count
    const [count, setCount] = useState(0);
    const [count1, setCount1] = useState(0);

    const increament = ()=>{
        setCount(count+1);
        setCount1(count1+1);
    }
    
    useEffect(()=>{
        console.log("렌더링 후 실행되는 useEffect Hook");
        return ()=>{
            console.log("렌더링 후 다음 동작 실행 return");
        }
    },[count])






  return (
    <div>
        <p>count = {count}, count1 ={count1}</p>
        {/* onClick 이벤트를 통해서 state 값을 입력한다 */}
        {/* <button onClick={() => setCount(count=>count+1)}>숫자 증가</button> */}
        <button onClick={increament}>숫자 증가</button>
        <button onClick={()=>setCount(count+1)}>count 숫자 증가</button>
        <button onClick={()=>setCount1(count1+1)}>count1 숫자 증가</button>
    </div>
  )
}

export default Counter