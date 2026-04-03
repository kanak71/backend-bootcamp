import React from 'react'

function List() {

    const arr = [1,2,3,4];


  return (
    // 절대 프레그먼트 안에 있는 javascript를 입력할때는 ; 사용하면 안됩니다
    <div>
        <ul>
        {
            arr.map((number, index)=>{
                return <li key={index}>List Item {number}</li>
            })
        }
        </ul>
    </div>
  )
}

export default List