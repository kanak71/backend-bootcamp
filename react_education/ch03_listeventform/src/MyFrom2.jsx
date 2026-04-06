import React, { useState } from 'react'

function MyFrom2() {

    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');

    const handleSubmit = (event) => {
        //alert(`서브밋 처리. ${firstName} ${lastName}`);
        event.preventDefault();// propagtion

        // AJAX (비동기처리 방식 - REST-ful API : 값을 전송받아서 값을 화면에 출력 - SPA)
        // fetch, axios => Promise 객체로 받아서 callback문제를 해결 
        // jQuery Ajax  => 문자열로 처리
        fetch("http://localhost:8080/api/form", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                firstName: firstName,
                lastName: lastName,
                email: email
            })
        })
            .then((res) => res.json())
            .then((data) => {
                console.log("서버 응답 데이터 ", data)
            })
            .catch((err) => console.log(err))
    };


  return (
    <div>
        <form onSubmit={handleSubmit}>
        <table >
          <tr>
            <th>성</th>
            <td>
              <input type='text' name='firstName' onChange={(e)=>setFirstName(e.target.value)} value={firstName}/>
            </td>
          </tr>
          <tr>
            <th>이름</th>
            <td>
              <input type='text' name='lastName' onChange={(e)=>setLastName(e.target.value)} value={lastName}/>
            </td>
          </tr>
          <tr>
            <th>이메일</th>
            <td>
              <input type='text' name='email' onChange={(e)=>setEmail(e.target.value)} value={email}/>
            </td>
          </tr>
          <tr>
            <td colSpan='2'>
              <input  type='submit' value="전송"/>
            </td>
          </tr>
        </table>
      </form>
    </div>
  )
}

export default MyFrom2 