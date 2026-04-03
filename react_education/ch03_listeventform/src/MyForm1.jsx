import React, { useState } from 'react'
import 'bootstrap/dist/css/bootstrap.min.css'

function MyForm1() {

  const [user, setUser] = useState({
    firstName:'',
    lastName:'',
    email: ''
  });

  const handleSubmit = (event)=>{
    alert(`안녕하세요 ${user.firstName} ${user.lastName}`);
    event.preventDefault();
  }

  const inputChange = (event) =>{
    setUser({...user, [event.target.name]:event.target.value});
  }

  return (
    <form onSubmit={handleSubmit}>
        <table className='table table-hover'>
          <tr>
            <th>성</th>
            <td>
              <input type='text' name='firstName' onChange={inputChange} value={user.firstName}/>
            </td>
          </tr>
          <tr>
            <th>이름</th>
            <td>
              <input type='text' name='lastName' onChange={inputChange} value={user.lastName} />
            </td>
          </tr>
          <tr>
            <th>이메일</th>
            <td>
              <input type='text' name='email' onChange={inputChange} value={user.email}/>
            </td>
          </tr>
          <tr>
            <td colSpan='2'>
              <input  type='submit' className='btn btn-primary' value="전송"/>
            </td>
          </tr>
        </table>
      </form>
  )
}

export default MyForm1