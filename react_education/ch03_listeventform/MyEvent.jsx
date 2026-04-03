import React from 'react'

function MyEvent() {

    const buttonPress = ()=>{
        alert("버튼을 눌렀음");
    }

    const propagationSubmit = (event)=>{
        //이벤트를 막을때 false를 반환하는 방법을 사용할 수 없다
        event.preventDefault();
        alert("전파를 막고 Alert 실행")
    }

  return (
    <div>
        <button onClick={buttonPress}>버튼누름</button>
        <br/>
        <form onSubmit={propagationSubmit}>
            <input type='submit' value='전송'/>
        </form>
    </div>
  )
}

export default MyEvent