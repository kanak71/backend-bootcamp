import React from 'react'

function Hello({name ="이름없음", color}) {

    const cssStyle = {
        backgroundColor:"black",
        color:"white"
    }

  return (
    <>
    <div style={cssStyle}>Hello {/*주석*/}</div>
    <div style={{color:color}}>{name}</div>
    </>
  )
}


export default Hello