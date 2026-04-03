import React from 'react'

function MyTable() {
    const passport = [
        { "id": "kokoball", "name": "코코볼", "address": "서울" },
        { "id": "banana", "name": "바나나", "address": "강원" },
        { "id": "energy", "name": "에너지", "address": "충남" },
    ];

  return (
    <table>
        {
            passport.map((item, index)=>
                <tr key={index}>
                    <td>{item.id}</td>
                    <td>{item.name}</td>
                    <td>{item.address}</td>
                </tr>
            )
        }
    </table>
  )
}

export default MyTable