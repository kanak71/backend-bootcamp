import React, { useRef, useState } from 'react'

function Variable() {

    const [render, setRender] = useState(false);
    const countRef = useRef(0);
    let countVar = 0;

    console.log("^^ 렌더링 후 useRef", countRef);
    console.log("^^ 렌더링 후 일반 var", countVar);

    const increaseRef = ()=>{
        countRef.current = countRef.current +1;
        console.log("useRef변수 증가", countRef.current)
    }

    const increaseVar = ()=>{
        countVar = countVar +1;
        console.log("일반변수 증가", countVar)
    }

    const doRender = () =>{
        setRender(!render);
    }

    

  return (
    <div>
        <button onClick={increaseRef}>Ref Up!</button>
        <button onClick={increaseVar}>Var Up!</button>
        <button onClick={doRender}>Render</button>
    </div>
  )
}

export default Variable