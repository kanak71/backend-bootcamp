import React, { useState } from 'react'

function MyComponent() {
    
    const [firstName, setFirstName] = useState("강");
    const [lastName, setLastName] = useState("나경");

    const [info, setInfo] = useState({
        address : "김포시",
        phone : "02"
    });

    const changeName = () => setFirstName("이");
    const changePhone = () => setInfo({...info, phone:"010"});

  return (
    <div>
        안녕하세요 {firstName} {lastName} 님<br/>
        {info.address} {info.phone}<br/>
        <button onClick={changeName}>이름변경</button>
        <button onClick={changePhone}>번호변경</button>
    </div>
  )
}

export default MyComponent